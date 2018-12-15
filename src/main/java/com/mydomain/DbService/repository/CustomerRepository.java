package com.mydomain.DbService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mydomain.DbService.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByClientName(String clientName);

}
