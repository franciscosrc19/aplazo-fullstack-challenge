package com.aplazo.msprptakehome.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Setter
public class LoanResponse {

  private Long id;
  private Long customerId;
  private double amount;
  private LocalDate createdAt;
  private List<InstallmentResponse> paymentPlan;


}