package com.aplazo.msprptakehome.service;


import com.aplazo.msprptakehome.dto.CustomerRequest;
import com.aplazo.msprptakehome.dto.CustomerResponse;
import com.aplazo.msprptakehome.model.Customer;
import com.aplazo.msprptakehome.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerResponse createCustomer(CustomerRequest request) {
    Customer customer = new Customer();
    customer.setFirstName(request.getFirstName());
    customer.setLastName(request.getLastName());
    customer.setSecondLastName(request.getSecondLastName());
    customer.setDateOfBirth(request.getDateOfBirth());

    Customer savedCustomer = customerRepository.save(customer);

    CustomerResponse response = new CustomerResponse();
    response.setId(savedCustomer.getId());
    response.setCreditLineAmount(1000.0);
    response.setAvailableCreditLineAmount(1000.0);
    response.setCreatedAt(savedCustomer.getDateOfBirth().atStartOfDay());

    return response;
  }

  public Optional<CustomerResponse> getCustomerById(Long id) {
    return customerRepository.findById(id)
             .map(customer -> {
               CustomerResponse response = new CustomerResponse();
               response.setId(customer.getId());
               response.setCreditLineAmount(1000.0);
               response.setAvailableCreditLineAmount(1000.0);
               response.setCreatedAt(customer.getDateOfBirth().atStartOfDay());
               return response;
             });
  }
}