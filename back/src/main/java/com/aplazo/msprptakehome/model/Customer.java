package com.aplazo.msprptakehome.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Setter
@Getter
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotBlank
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @NotBlank
  @Column(name = "second_last_name", nullable = false)
  private String secondLastName;

  @Past
  @Column(name = "date_of_birth", nullable = false)
  private LocalDate dateOfBirth;



}
