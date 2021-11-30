package com.zhao.microservice.AddressService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhao.microservice.AddressService.Entity.Address;
import com.zhao.microservice.AddressService.Service.AddressService;



@RestController
@RequestMapping("/address")
public class AddressServiceController {

	@Autowired
	AddressService addressService;
	
	@GetMapping("/all")
	public List<Address> getAllAddress() {
		
		return addressService.GetAllAddress();
		
	}
//	@GetMapping(value = "/{id}", 
//			produces = { MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE, 
//            MediaType.TEXT_XML_VALUE })
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable("id") Long id) {
		
		return addressService.GetAddressById(id);
		
	}
	
	@PostMapping("/add")
	public Address addAddress(@RequestBody Address address) {
		
		addressService.addAddress(address);
		return address;
	}
	
	@DeleteMapping("/{id}")
	public String deleteAddressById(@PathVariable("id") Long id) {
		
		return addressService.deleteAddressById(id);
		
	}
	
	@PutMapping("/{id}")
	public Address updateAddressById(@PathVariable("id") Long id, 
			@RequestBody Address address) {
		
		return addressService.updateAddressById(id, address);
		
	}
}
