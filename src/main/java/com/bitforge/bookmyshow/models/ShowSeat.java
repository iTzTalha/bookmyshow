package com.bitforge.bookmyshow.models;

import com.bitforge.bookmyshow.enums.ShowSeatStatus;
import lombok.Data;

@Data
public class ShowSeat extends BaseModel {
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
