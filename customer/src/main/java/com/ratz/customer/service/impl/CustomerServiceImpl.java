package com.ratz.customer.service.impl;

import com.ratz.customer.entity.Customer;
import com.ratz.customer.entity.FraudCheckResponse;
import com.ratz.customer.repository.CustomerRepository;
import com.ratz.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository repository;

  @Autowired
  private RestTemplate restTemplate;


  @Override
  public Customer save(Customer customer) {

     repository.saveAndFlush(customer);

    FraudCheckResponse object = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
        FraudCheckResponse.class,
        customer.getId()
    );

    if (object.isFraudulent()){
      throw new IllegalStateException("fraudster");
    }

    return customer;
  }
}
