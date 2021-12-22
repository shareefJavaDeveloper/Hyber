package com.hyber.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyber.customer.repository.dataentity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
