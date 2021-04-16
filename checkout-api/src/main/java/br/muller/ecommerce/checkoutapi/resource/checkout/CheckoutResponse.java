package br.muller.ecommerce.checkoutapi.resource.checkout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class CheckoutResponse implements Serializable {
    private String code;
}
