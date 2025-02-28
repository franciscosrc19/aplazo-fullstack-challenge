package com.aplazo.msprptakehome.controller;

import com.aplazo.msprptakehome.dto.CustomerRequest;
import com.aplazo.msprptakehome.dto.CustomerResponse;
import com.aplazo.msprptakehome.model.Customer;
import com.aplazo.msprptakehome.service.CustomerService;
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
@RequestMapping("/v1/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest request) {
    CustomerResponse createdCustomer = customerService.createCustomer(request);
    return ResponseEntity.created(URI.create("/v1/customers/" + createdCustomer.getId()))
             .body(createdCustomer);
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long customerId) {
    return customerService.getCustomerById(customerId)
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
  }
}