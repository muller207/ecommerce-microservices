package br.muller.ecommerce.checkoutapi.resource.checkout;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CheckoutRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String address;
    private String address2;
    private String country;
    private String state;
    private String zip;
    private Boolean saveAddress;
    private Boolean saveInfo;
    private String paymentMethod;
    private String cardName;
    private String cardNumber;
    private String cardDate;
    private String cardCvv;
}
