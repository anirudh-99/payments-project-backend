package com.dbs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dbs.data.entities.Customer;
import com.dbs.utils.TopCustomer;

public interface CustomerRepo extends JpaRepository<Customer, String> {

	@Query(value = "SELECT customer.name as name,sum(amount) as amount FROM transaction join customer on transaction.account_number=customer.account_number group by transaction.account_number", nativeQuery = true)
	List<?> getTopCustomersByRemittance();

}
