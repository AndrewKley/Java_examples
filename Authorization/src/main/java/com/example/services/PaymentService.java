package com.example.services;

import com.example.Exceptions.NotEnoughMoneyException;
import com.example.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
