package com.aplazo.msprptakehome.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class CustomerRequest {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  private String secondLastName;

  @Past
  private LocalDate dateOfBirth;


}
