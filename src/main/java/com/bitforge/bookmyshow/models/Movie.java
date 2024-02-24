package com.bitforge.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "movies")
public class Movie extends BaseModel {
    private String name;
    //Movie : Actor
    //1 : M
    //M : 1
    //@ManyToMany
    //private List<String> actors;
}
