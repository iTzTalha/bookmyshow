package com.bitforge.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Movie extends BaseModel {
    private String name;
    private List<String> actors;
}
