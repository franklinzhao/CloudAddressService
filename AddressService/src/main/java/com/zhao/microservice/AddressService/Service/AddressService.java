package com.zhao.microservice.AddressService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zhao.microservice.AddressService.Entity.Address;
import com.zhao.microservice.AddressService.Repository.AddressRepository;


@Service
@Component
public class AddressService {
	@Autowired
	AddressRepository addressRepo;

	public List<Address> GetAllAddress() {
		
		return addressRepo.findAll();
	}

	public void addAddress(Address address) {
		addressRepo.save(address);
	}

	public Address GetAddressById(Long id) {
		return addressRepo.findAddressById(id);
	}

	public String deleteAddressById(Long id) {
		addressRepo.deleteById(id);
		
		return "The Address with id: "+id+" was deleted successfully!";
	}

	public Address updateAddressById(Long id, Address newAddress) {
		
		   return addressRepo.findById(id)
				      .map(address -> {//optional.map is a function mapper
				    	  //for convertion or tranforming objects into another obj
				    	  //see optional.map reference
				        address.setFirstName(newAddress.getFirstName());
				        address.setLastName(newAddress.getLastName());
				        address.setAddressLine1(newAddress.getAddressLine1());
				        address.setAddressLine2(newAddress.getAddressLine2());
				        address.setAddressLine3(newAddress.getAddressLine3());
				        address.setCityOrtown(newAddress.getCityOrtown());
				        address.setCountry(newAddress.getCountry());
				        address.setEmail(newAddress.getEmail());
				        address.setPhone(newAddress.getPhone());
				        address.setPostcode(newAddress.getPostcode());
				        address.setStateOrprovince(newAddress.getStateOrprovince());
				        return addressRepo.save(address);
				      })
				      .orElseGet(() -> {
				        newAddress.setId(id);
				        return addressRepo.save(newAddress);
				      });

	}


	
	
}
