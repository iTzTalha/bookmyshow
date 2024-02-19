package com.bitforge.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Theatre extends BaseModel {
    private String name;
    private Region region;
    private List<Screen> screens;
}
