package com.ratz.customer.controller;


import com.ratz.customer.entity.Customer;
import com.ratz.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {


  private final CustomerService customerService;


  @PostMapping
  public Customer registerCustomer(@RequestBody Customer customer) {
    log.info("new customer registration {}", customer);

    return customerService.save(customer);
  }
}

