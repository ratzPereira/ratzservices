package com.ratz.fraud.service.Impl;

import com.ratz.fraud.entity.FraudCheckHistory;
import com.ratz.fraud.repository.FraudRepository;
import com.ratz.fraud.service.FraudService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudServiceImpl implements FraudService {

  private final FraudRepository repository;

  public FraudServiceImpl(FraudRepository repository) {
    this.repository = repository;
  }


  @Override
  public boolean isFraudulentCustomer(Integer customerId) {

    FraudCheckHistory savedFraudHistory = repository.save(FraudCheckHistory.builder()
        .customerId(customerId)
        .isFraudster(false)
        .createdAt(LocalDateTime.now())
        .build());

    return savedFraudHistory.getIsFraudster();
  }
}
