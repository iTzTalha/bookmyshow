package com.bitforge.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "regions")
public class Region extends BaseModel {
    private String name;
    //Region : Theatre
    //1 : M
    //1 : 1
    @OneToMany
    private List<Theatre> theatres;
    //Region : Theatre
    //1 : M
    //M : 1
    @ManyToMany
    private List<Movie> movies;
}
