package com.scaler.paymentgateway.controllers;

import com.scaler.paymentgateway.dtos.CreatePaymentLinkRequestDto;
import com.scaler.paymentgateway.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request){
        return paymentService.createPaymentLink(request.getOrderId());
    }

    @PostMapping("/webhook")
    public String handleWebhook(@RequestBody String payload){
        System.out.println("WebHook Triggered " + payload);
        return "OK";
    }
}
