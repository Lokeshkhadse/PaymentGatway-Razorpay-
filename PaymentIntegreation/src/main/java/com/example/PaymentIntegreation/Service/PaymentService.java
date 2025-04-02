package com.example.PaymentIntegreation.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;


    public String createOrder(int amount , String currency , String receiptId) throws RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient(apiKey,apiSecret); //connecting with razorPay

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount" , amount * 100); //rupees to paise
        orderRequest.put("currency",currency);
        orderRequest.put("receipt",receiptId);

        Order order =  razorpayClient.orders.create(orderRequest);
        return  order.toString();
    }

}
//package com.example.PaymentIntegreation.Service;
//
//import com.razorpay.Order;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentService {
//
//    @Value("${razorpay.api.key}")
//    private String apiKey;
//
//    @Value("${razorpay.api.secret}")
//    private String apiSecret;
//
//    public Order createOrder(int amount, String currency, String receiptId) throws RazorpayException {
//        RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);
//
//        JSONObject orderRequest = new JSONObject();
//        orderRequest.put("amount", amount * 100); // Convert rupees to paise
//        orderRequest.put("currency", currency);
//        orderRequest.put("receipt", receiptId);
//        orderRequest.put("payment_capture", 1); // Auto capture payment
//
//        return razorpayClient.orders.create(orderRequest);
//    }
//}
