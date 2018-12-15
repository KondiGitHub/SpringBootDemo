package com.mydomain.DbService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydomain.DbService.model.Customer;
import com.mydomain.DbService.repository.CustomerRepository;

@RestController
public class DbServiceController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	
	@RequestMapping(value ="/", method=RequestMethod.GET)
	public String getClientDetails(@RequestParam(value="clientId",required=true) String clientId,
			                       @RequestParam(value="clientName",required=true) String clientName) {
		
		List<Customer> cusomerList = customerRepository.findByClientName(clientName);
		//userList.forEach(System.out::println);
		
		Customer customer = new Customer();
		customer = cusomerList.get(0);
		return customer.toString();
	}

}
