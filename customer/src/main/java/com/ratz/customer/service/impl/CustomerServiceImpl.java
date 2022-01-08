package com.ratz.customer.service.impl;

import com.ratz.customer.entity.Customer;
import com.ratz.customer.repository.CustomerRepository;
import com.ratz.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository repository;


  @Override
  public Customer save(Customer customer) {
     return repository.save(customer);
  }
}
