package me.learnspring.restservices.controllers;

import me.learnspring.restservices.models.PaymentDetails;
import me.learnspring.restservices.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentControllerAspectHandling {

    private static final Logger logger = Logger.getLogger(PaymentControllerAspectHandling.class.getName());
    private final PaymentService paymentService;

    public PaymentControllerAspectHandling(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {
        PaymentDetails paymentDetails = paymentService.processPayment();

        return ResponseEntity
                .accepted()
                .body(paymentDetails);
    }

    @GetMapping("/pay")
    public ResponseEntity<PaymentDetails> makePaymentWithBody(@RequestBody PaymentDetails paymentDetails) {
        logger.info("You are trying to pay " + paymentDetails.getAmount());

        return ResponseEntity
                .accepted()
                .body(paymentDetails);
    }
}
