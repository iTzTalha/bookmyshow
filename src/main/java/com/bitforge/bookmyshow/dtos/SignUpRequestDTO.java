package com.bitforge.bookmyshow.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequestDTO {
    private String email;
    private String password;
}
