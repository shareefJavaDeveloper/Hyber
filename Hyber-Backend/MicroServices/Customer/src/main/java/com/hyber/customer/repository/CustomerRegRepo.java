package com.hyber.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyber.customer.repository.dataentity.CustomerReg;
import com.hyber.customer.repository.dataentity.compositeId.CustomerRegCompositeId;


@Repository
public interface CustomerRegRepo extends JpaRepository<CustomerReg,CustomerRegCompositeId>{
    
}
