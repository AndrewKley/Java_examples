package com.example.controllers;

import com.example.Exceptions.ErrorDetails;
import com.example.Exceptions.NotEnoughMoneyException;
import com.example.models.PaymentDetails;
import com.example.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    @GetMapping("/payment")
//    public ResponseEntity<?> makePayment() {
//        try {
//            PaymentDetails paymentDetails = paymentService.processPayment();
//
//            return ResponseEntity
//                    .status(HttpStatus.ACCEPTED)
//                    .body(paymentDetails);
//        } catch (NotEnoughMoneyException e) {
//            ErrorDetails errorDetails = new ErrorDetails();
//            errorDetails.setMessage("Not enough money to take the payment");
//            return ResponseEntity
//                    .badRequest()
//                    .body(errorDetails);
//
//        }

    @GetMapping("/payment")
    public ResponseEntity<?> makePayment() {
        PaymentDetails paymentDetails = paymentService.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());
    // curl -v POST http://localhost:8080/payment -d '{"amount": 1001}' -H "Content-Type: application/json"
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePaymentPost(
            @RequestBody PaymentDetails paymentDetails
    ) {
        logger.info("Received payment " + paymentDetails.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
