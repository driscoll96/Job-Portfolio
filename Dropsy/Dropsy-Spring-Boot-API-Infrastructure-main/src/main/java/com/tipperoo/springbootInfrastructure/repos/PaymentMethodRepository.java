package com.tipperoo.springbootInfrastructure.repos;

import com.tipperoo.springbootInfrastructure.dao.PaymentMethod;
import org.springframework.data.repository.CrudRepository;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, String> {
}
