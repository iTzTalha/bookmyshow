package com.bitforge.bookmyshow.dtos;

import com.bitforge.bookmyshow.enums.ResponseStatus;
import lombok.Data;

@Data
public class BookMovieShowResponseDTO {
    private Long bookingId;
    private double amount;
    private ResponseStatus responseStatus;
}
