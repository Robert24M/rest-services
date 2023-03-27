package me.learnspring.restservices.controllers;

import me.learnspring.restservices.exceptions.NotEnoughMoneyException;
import me.learnspring.restservices.models.ErrorDetails;
import me.learnspring.restservices.models.PaymentDetails;
import me.learnspring.restservices.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentControllerTryCatch {

    private final PaymentService paymentService;

    public PaymentControllerTryCatch(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity
                    .accepted()
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");

            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}
