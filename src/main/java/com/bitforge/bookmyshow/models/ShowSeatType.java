package com.bitforge.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "Show_seat_types")
public class ShowSeatType extends BaseModel {
    //ShowSeatType : Show
    //1 : 1
    //M : 1
    @ManyToOne
    private Show show;
    //ShowSeatType : SeatType
    //1 : 1
    //M : 1
    @ManyToOne
    private SeatType seatType;
    private Double price;
}
