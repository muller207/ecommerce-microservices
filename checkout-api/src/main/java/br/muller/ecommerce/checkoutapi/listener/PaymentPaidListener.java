package br.muller.ecommerce.checkoutapi.listener;

import br.muller.ecommerce.checkoutapi.entity.CheckoutEntity;
import br.muller.ecommerce.checkoutapi.repository.CheckoutRepository;
import br.muller.ecommerce.checkoutapi.streaming.PaymentPaidSink;
import br.muller.ecommerce.paymentapi.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event){
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow(IllegalStateException::new);
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        checkoutRepository.save(checkoutEntity);
    }
}
