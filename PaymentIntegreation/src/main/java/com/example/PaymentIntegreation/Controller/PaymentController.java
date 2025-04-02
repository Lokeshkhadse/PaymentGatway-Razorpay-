package com.example.PaymentIntegreation.Controller;

import com.example.PaymentIntegreation.Service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {


    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create-order")
    public String createOrder(@RequestParam int amount , @RequestParam String currency ){
        try{
            return paymentService.createOrder(amount, currency, "recepient_100");
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }
}

//package com.example.PaymentIntegreation.Controller;
//
//import com.example.PaymentIntegreation.Service.PaymentService;
//import com.razorpay.Order;
//import com.razorpay.RazorpayException;
//import org.json.JSONObject;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/payments")
//@CrossOrigin(origins = "*") // Allow frontend access
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    @PostMapping("/create-order")
//    public Map<String, Object> createOrder(@RequestParam int amount, @RequestParam String currency) {
//        Map<String, Object> response = new HashMap<>();
//        try {
//            Order order = paymentService.createOrder(amount, currency, "receipt_" + System.currentTimeMillis());
//            JSONObject orderDetails = new JSONObject(order.toString());
//
//            response.put("id", orderDetails.getString("id"));
//            response.put("amount", orderDetails.getInt("amount"));
//            response.put("currency", orderDetails.getString("currency"));
//            response.put("status", orderDetails.getString("status"));
//            return response;
//        } catch (RazorpayException e) {
//            response.put("error", e.getMessage());
//            return response;
//        }
//    }
//}
//
