package com.zhao.microservice.AddressService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zhao.microservice.AddressService.Entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

	Address findAddressById(Long id);


}
