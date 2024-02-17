package com.bitforge.bookmyshow.models;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {
    private Long id;
    private Date createdOn;
    private Date updatedOn;
}
