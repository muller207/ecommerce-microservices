package br.muller.ecommerce.paymentapi.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
public class PaymentEntity  {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String code;

    @Column
    private String checkoutCode;
}
