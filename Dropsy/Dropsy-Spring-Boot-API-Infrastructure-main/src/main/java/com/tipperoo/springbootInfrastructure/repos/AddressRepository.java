package com.tipperoo.springbootInfrastructure.repos;

import com.tipperoo.springbootInfrastructure.dao.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer>  {
}
