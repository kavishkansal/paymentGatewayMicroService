package com.scaler.paymentgateway.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorPayPaymentService implements PaymentService{

    private RazorpayClient razorpayClient;

    public RazorPayPaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String createPaymentLink(String orderId) {
        //TODO: Get order details from orderService to create payment link
        try{
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",1000); //Rs 10.
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",true);
            paymentLinkRequest.put("first_min_partial_amount",100);
            paymentLinkRequest.put("description","Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name","+918568022000");
            customer.put("contact","Kavish Kansal");
            customer.put("email","markwebtechnologies@gmail.com");
            paymentLinkRequest.put("customer",customer);
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);

            JSONObject options = new JSONObject();
            JSONObject notes = new JSONObject();
            notes.put("branch","Acme Corp Bangalore North");
            notes.put("name","Bhairav Kumar");

            JSONObject theme = new JSONObject();
            theme.put("hide_topbar",true);
            JSONObject checkout = new JSONObject();
            checkout.put("theme",theme);
            options.put("checkout",checkout);
            paymentLinkRequest.put("options",options);
            paymentLinkRequest.put("callback_url","https://google.com/");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url");
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }
}
