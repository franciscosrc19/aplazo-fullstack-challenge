package com.aplazo.msprptakehome.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class CustomerResponse {

  private Long id;
  private double creditLineAmount;
  private double availableCreditLineAmount;
  private LocalDateTime createdAt;


}