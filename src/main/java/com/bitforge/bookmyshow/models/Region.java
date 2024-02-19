package com.bitforge.bookmyshow.models;


import lombok.Data;

import java.util.List;

@Data
public class Region extends BaseModel {
    private String name;
    private List<Theatre> theatres;
    private List<Movie> movies;
}
