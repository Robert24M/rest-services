package me.learnspring.restservices.controllers;

import me.learnspring.restservices.models.PaymentDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentsControllerForRestConsumption {

    @PostMapping
    public ResponseEntity<PaymentDetails> createPayment(
            @RequestHeader String requestId,
            @RequestBody PaymentDetails paymentDetails
    ) {
        paymentDetails.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .accepted()
                .header("requestId", requestId)
                .body(paymentDetails);
    }
}
