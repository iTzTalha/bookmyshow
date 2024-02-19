package com.bitforge.bookmyshow.models;

import com.bitforge.bookmyshow.enums.Feature;
import com.bitforge.bookmyshow.enums.ShowStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Show extends BaseModel {
    private Movie movie;
    private Screen screen;
    private Date startDate;
    private Date endDate;
    private List<Feature> features;
    private ShowStatus showStatus;
}
