package com.bitforge.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "seat_types")
public class SeatType extends BaseModel {
    private String name;
}
