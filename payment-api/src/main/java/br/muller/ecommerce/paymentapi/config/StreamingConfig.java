package br.muller.ecommerce.paymentapi.config;

import br.muller.ecommerce.paymentapi.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {CheckoutProcessor.class})
public class StreamingConfig {
}
