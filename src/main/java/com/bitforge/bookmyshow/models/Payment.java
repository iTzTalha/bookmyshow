package com.bitforge.bookmyshow.models;

import com.bitforge.bookmyshow.enums.PaymentMode;
import com.bitforge.bookmyshow.enums.PaymentProvider;
import com.bitforge.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity(name = "payments")
public class Payment extends BaseModel {
    private String referenceNumber;
    private Double amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
