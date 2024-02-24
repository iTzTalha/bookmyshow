package com.bitforge.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "theatres")
public class Theatre extends BaseModel {
    private String name;
    //Theatre : Region
    //1 : 1
    //M : 1
    @ManyToOne
    private Region region;
    //Theatre : Screen
    //1 : M
    //1 : M
    @OneToMany
    private List<Screen> screens;
}
