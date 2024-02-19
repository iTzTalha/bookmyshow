package com.bitforge.bookmyshow.models;

import com.bitforge.bookmyshow.enums.Feature;
import lombok.Data;

import java.util.List;

@Data
public class Screen extends BaseModel {
    private String name;
    private Theatre theatre;
    private List<Seat> seats;
    private List<Feature> features;
}
