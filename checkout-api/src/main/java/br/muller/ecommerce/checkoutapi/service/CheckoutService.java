package br.muller.ecommerce.checkoutapi.service;

import br.muller.ecommerce.checkoutapi.entity.CheckoutEntity;
import br.muller.ecommerce.checkoutapi.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {
    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
