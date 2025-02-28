package com.aplazo.msprptakehome.service;


import com.aplazo.msprptakehome.dto.LoanRequest;
import com.aplazo.msprptakehome.dto.LoanResponse;
import com.aplazo.msprptakehome.model.Loan;
import com.aplazo.msprptakehome.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService {

  private final LoanRepository loanRepository;

  public LoanService(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
  }

  public LoanResponse createLoan(LoanRequest request) {
    Loan loan = new Loan();
    loan.setAmount(request.getAmount());
    loan.setCreatedAt(java.time.LocalDate.now());

    Loan savedLoan = loanRepository.save(loan);

    LoanResponse response = new LoanResponse();
    response.setId(savedLoan.getId());
    response.setCustomerId(request.getCustomerId());
    response.setAmount(savedLoan.getAmount());
    response.setCreatedAt(savedLoan.getCreatedAt());

    // Generar y agregar el plan de pago
    response.setPaymentPlan(java.util.Collections.emptyList());

    return response;
  }

  public Optional<LoanResponse> getLoanById(Long id) {
    return loanRepository.findById(id)
             .map(loan -> {
               LoanResponse response = new LoanResponse();
               response.setId(loan.getId());
               response.setCustomerId(loan.getCustomer().getId());
               response.setAmount(loan.getAmount());
               response.setCreatedAt(loan.getCreatedAt());
               response.setPaymentPlan(java.util.Collections.emptyList());
               return response;
             });
  }
}
