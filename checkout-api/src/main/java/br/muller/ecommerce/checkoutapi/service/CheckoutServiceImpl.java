package br.muller.ecommerce.checkoutapi.service;

import br.muller.ecommerce.checkoutapi.entity.CheckoutEntity;
import br.muller.ecommerce.checkoutapi.event.CheckoutCreatedEvent;
import br.muller.ecommerce.checkoutapi.repository.CheckoutRepository;
import br.muller.ecommerce.checkoutapi.resource.checkout.CheckoutRequest;
import br.muller.ecommerce.checkoutapi.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();
        final CheckoutEntity saved = checkoutRepository.save(checkoutEntity);

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(saved.getCode())
                .setStatus(saved.getStatus().name())
                .build();

            checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(saved);
    }
}
