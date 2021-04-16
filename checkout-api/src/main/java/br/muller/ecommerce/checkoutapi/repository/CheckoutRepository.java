package br.muller.ecommerce.checkoutapi.repository;

import br.muller.ecommerce.checkoutapi.entity.CheckoutEntity;
import br.muller.ecommerce.checkoutapi.resource.checkout.CheckoutRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {

    Optional<CheckoutEntity> findByCode(String code);
}
