package br.muller.ecommerce.paymentapi.listener;

import br.muller.ecommerce.checkoutapi.event.CheckoutCreatedEvent;
import br.muller.ecommerce.paymentapi.event.PaymentCreatedEvent;
import br.muller.ecommerce.paymentapi.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.avro.generic.GenericData;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(GenericData.Record event){
        // Process payment
        // Save payment data
        // Send payment event

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(event.get("checkoutCode"))
                .setStatus(event.get("status"))
                .build();

        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(checkoutCreatedEvent.getCheckoutCode())
                .setCheckoutStatus(checkoutCreatedEvent.getStatus())
                //.setPaymentCode(UUID.randomUUID().toString())
                .build();
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}

