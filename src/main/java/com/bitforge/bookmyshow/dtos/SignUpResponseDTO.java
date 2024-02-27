package com.bitforge.bookmyshow.dtos;

import com.bitforge.bookmyshow.enums.ResponseStatus;
import lombok.Data;

@Data
public class SignUpResponseDTO {
    private Long userId;
    private ResponseStatus responseStatus;
}
