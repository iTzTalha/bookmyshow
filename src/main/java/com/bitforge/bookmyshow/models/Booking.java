package com.bitforge.bookmyshow.models;

import com.bitforge.bookmyshow.enums.BookingStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Booking extends BaseModel {
    private Show show;
    private Double amount;
    private List<ShowSeat> showSeats;
    private BookingStatus bookingStatus;
    private User user;
    private List<Payment> payments;
    private Date bookedAt;
}
