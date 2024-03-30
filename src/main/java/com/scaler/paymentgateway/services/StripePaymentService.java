package com.scaler.paymentgateway.services;

import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements PaymentService{
    @Override
    public String createPaymentLink(String orderId) {
        return null;
    }
}
