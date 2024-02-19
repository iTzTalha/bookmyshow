package com.bitforge.bookmyshow.models;

import lombok.Data;

@Data
public class Seat extends BaseModel {
    private String seatNumber;
    private int row;
    private int col;
    private SeatType seatType;
}
