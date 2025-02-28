package com.aplazo.msprptakehome.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
public class InstallmentResponse {

  private double amount;
  private LocalDate scheduledPaymentDate;
  private String status;


}
