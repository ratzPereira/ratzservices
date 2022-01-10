package com.ratz.fraud.controller;


import com.ratz.fraud.entity.FraudCheckResponse;
import com.ratz.fraud.service.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {

  private final FraudService fraudService;

  public FraudController(FraudService fraudService) {
    this.fraudService = fraudService;
  }

  @GetMapping("/{id}")
  public FraudCheckResponse isFraudster(@PathVariable Integer id){

    boolean fraudulentCustomer = fraudService.isFraudulentCustomer(id);

    FraudCheckResponse fraudCheckResponse = new FraudCheckResponse();
    fraudCheckResponse.setFraudulent(fraudulentCustomer);

    log.info("fraud check request for customer id = {}", id);

    return fraudCheckResponse;
  }
}
