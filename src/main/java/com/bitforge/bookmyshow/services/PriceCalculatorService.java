package com.bitforge.bookmyshow.services;

import com.bitforge.bookmyshow.models.Show;
import com.bitforge.bookmyshow.models.ShowSeat;
import com.bitforge.bookmyshow.models.ShowSeatType;
import com.bitforge.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculatePrice(Show show, List<ShowSeat> showSeats) {
        double amount = 0d;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
