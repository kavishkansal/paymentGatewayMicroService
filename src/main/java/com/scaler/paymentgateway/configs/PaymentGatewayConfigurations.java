package com.scaler.paymentgateway.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentGatewayConfigurations {

    @Value("${razorpay.keyId}")
    private String razorpaykeyId;

    @Value("${razorpay.keySecret}")
    private String razorpaykeySecret;

    @Bean
    RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpaykeyId, razorpaykeySecret);
    }
}
