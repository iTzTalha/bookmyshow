package com.bitforge.bookmyshow.models;

import lombok.Data;

@Data
public class ShowSeatType extends BaseModel {
    private Show show;
    private SeatType seatType;
    private Double price;
    private ShowSeatType showSeatType;
}
