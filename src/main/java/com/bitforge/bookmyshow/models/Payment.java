package com.bitforge.bookmyshow.models;

import com.bitforge.bookmyshow.enums.PaymentMode;
import com.bitforge.bookmyshow.enums.PaymentProvider;
import com.bitforge.bookmyshow.enums.PaymentStatus;
import lombok.Data;

@Data
public class Payment extends BaseModel {
    private String referenceNumber;
    private Double amount;
    private PaymentMode paymentMode;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
}
