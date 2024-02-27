package com.bitforge.bookmyshow.services;

import com.bitforge.bookmyshow.enums.BookingStatus;
import com.bitforge.bookmyshow.enums.ShowSeatStatus;
import com.bitforge.bookmyshow.exceptions.SeatNotEmptyException;
import com.bitforge.bookmyshow.exceptions.ShowNotFoundException;
import com.bitforge.bookmyshow.exceptions.UserNotFoundException;
import com.bitforge.bookmyshow.models.Booking;
import com.bitforge.bookmyshow.models.Show;
import com.bitforge.bookmyshow.models.ShowSeat;
import com.bitforge.bookmyshow.models.User;
import com.bitforge.bookmyshow.repositories.BookingRepository;
import com.bitforge.bookmyshow.repositories.ShowRepository;
import com.bitforge.bookmyshow.repositories.ShowSeatRepository;
import com.bitforge.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final BookingRepository bookingRepository;
    private final PriceCalculatorService priceCalculatorService;

    @Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository, PriceCalculatorService priceCalculatorService) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, SeatNotEmptyException {

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User NOT found :(");
        }
        User bookedBy = userOptional.get();

        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()) {
            throw new ShowNotFoundException("Show NOT Found :(");
        }
        Show bookedShow = showOptional.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.EMPTY)) {
                throw new SeatNotEmptyException("Not all selected seats are available");
            }
        }
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(bookedBy);
        booking.setShow(bookedShow);
        booking.setShowSeats(showSeats);
        booking.setBookedAt(new Date());
        booking.setAmount(priceCalculatorService.calculatePrice(bookedShow, showSeats));
        booking.setPayments(new ArrayList<>());

        return bookingRepository.save(booking);
    }
}
