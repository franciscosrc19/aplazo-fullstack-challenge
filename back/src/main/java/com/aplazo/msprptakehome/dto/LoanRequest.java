package com.aplazo.msprptakehome.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
public class LoanRequest {

  @NotNull
  private Long customerId;

  @Min(value = 1, message = "The loan amount must be greater than 0")
  private double amount;


}

