package me.learnspring.restservices.controllers;

import me.learnspring.restservices.models.PaymentDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsControllerForRestConsumption {

    private final Logger logger = Logger.getLogger(PaymentsControllerForRestConsumption.class.getName());

    @PostMapping("/payments")
    public ResponseEntity<PaymentDetails> createPayment(
            @RequestHeader String requestId,
            @RequestBody PaymentDetails paymentDetails
    ) {
        logger.info("Received request with ID " +
                requestId + " ;Payment Amount: " + paymentDetails.getAmount());

        paymentDetails.setId(UUID.randomUUID().toString());
        paymentDetails.setAmount(paymentDetails.getAmount() + 100d);

        return ResponseEntity
                .accepted()
                .header("requestId", requestId)
                .body(paymentDetails);
    }
}
