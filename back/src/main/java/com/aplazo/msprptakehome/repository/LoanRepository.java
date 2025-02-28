package com.aplazo.msprptakehome.repository;

import com.aplazo.msprptakehome.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}