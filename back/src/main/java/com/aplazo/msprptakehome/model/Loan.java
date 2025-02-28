package com.aplazo.msprptakehome.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "loans")
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Column(name = "amount", nullable = false)
  private double amount;

  @Column(name = "created_at", nullable = false)
  private LocalDate createdAt;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "loan")
  private List<Installment> installments;

  @PrePersist
  public void generateInstallments() {
    double installmentAmount = this.amount / 5;
    for (int i = 1; i <= 5; i++) {
      Installment installment = new Installment();
      installment.setAmount(installmentAmount);
      installment.setScheduledPaymentDate(this.createdAt.plusMonths(i));
      installment.setLoan(this);
      this.installments.add(installment);
    }
  }


}