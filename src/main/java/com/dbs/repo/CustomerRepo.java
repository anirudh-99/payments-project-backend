package com.dbs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.data.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
