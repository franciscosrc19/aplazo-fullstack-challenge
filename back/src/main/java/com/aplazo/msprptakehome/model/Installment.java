package com.aplazo.msprptakehome.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "installments")
@Setter
@Getter
public class Installment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "amount", nullable = false)
  private double amount;

  @Column(name = "scheduled_payment_date", nullable = false)
  private LocalDate scheduledPaymentDate;

  @ManyToOne
  @JoinColumn(name = "loan_id", nullable = false)
  private Loan loan;

}
