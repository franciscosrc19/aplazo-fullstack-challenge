package com.aplazo.msprptakehome.repository;


import com.aplazo.msprptakehome.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}