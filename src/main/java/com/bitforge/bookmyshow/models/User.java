package com.bitforge.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "users")
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String contact;
    //User : Booking
    //1 : M
    //1 : 1
    @OneToMany
    private List<Booking> bookings;
}
