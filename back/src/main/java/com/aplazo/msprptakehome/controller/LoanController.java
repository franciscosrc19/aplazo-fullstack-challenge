package com.aplazo.msprptakehome.controller;

import com.aplazo.msprptakehome.dto.LoanRequest;
import com.aplazo.msprptakehome.dto.LoanResponse;
import com.aplazo.msprptakehome.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
@RestController
@RequestMapping("/v1/loans")
public class LoanController {

  private final LoanService loanService;

  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  @PostMapping
  public ResponseEntity<LoanResponse> createLoan(@RequestBody @Valid LoanRequest request) {
    LoanResponse createdLoan = loanService.createLoan(request);
    return ResponseEntity.created(URI.create("/v1/loans/" + createdLoan.getId()))
             .body(createdLoan);
  }

  @GetMapping("/{loanId}")
  public ResponseEntity<LoanResponse> getLoanById(@PathVariable Long loanId) {
    return loanService.getLoanById(loanId)
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
  }
}