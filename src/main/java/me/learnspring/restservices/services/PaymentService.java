package me.learnspring.restservices.services;

import me.learnspring.restservices.exceptions.NotEnoughMoneyException;
import me.learnspring.restservices.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
