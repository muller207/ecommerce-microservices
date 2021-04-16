package br.muller.ecommerce.checkoutapi.config;

import br.muller.ecommerce.checkoutapi.streaming.CheckoutCreatedSource;
import br.muller.ecommerce.checkoutapi.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
