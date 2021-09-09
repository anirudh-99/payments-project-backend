package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.data.entities.BankBic;

public interface BankBicRepo extends JpaRepository<BankBic, String>{

}
