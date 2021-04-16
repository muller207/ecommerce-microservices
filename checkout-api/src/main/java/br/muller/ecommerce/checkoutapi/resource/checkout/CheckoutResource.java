package br.muller.ecommerce.checkoutapi.resource.checkout;

import br.muller.ecommerce.checkoutapi.entity.CheckoutEntity;
import br.muller.ecommerce.checkoutapi.event.CheckoutCreatedEvent;
import br.muller.ecommerce.checkoutapi.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutService checkoutService;

    //private final CheckoutCreatedEvent checkoutCreatedEvent;

    @PostMapping("/")
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest){
        final CheckoutEntity checkoutEntity = checkoutService.create(checkoutRequest).orElseThrow(IllegalStateException::new);
        CheckoutResponse checkoutResponse = CheckoutResponse.builder()
                .code(checkoutEntity.getCode())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse);
    }
}
