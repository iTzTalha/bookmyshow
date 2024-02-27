package com.bitforge.bookmyshow.controllers;

import com.bitforge.bookmyshow.dtos.BookMovieShowRequestDTO;
import com.bitforge.bookmyshow.dtos.BookMovieShowResponseDTO;
import com.bitforge.bookmyshow.enums.ResponseStatus;
import com.bitforge.bookmyshow.models.Booking;
import com.bitforge.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieShowResponseDTO bookTicket(BookMovieShowRequestDTO requestDTO) {
        BookMovieShowResponseDTO responseDTO = new BookMovieShowResponseDTO();
        try {
            Booking booking = bookingService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatIds());
            responseDTO.setBookingId(booking.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
