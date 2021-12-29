package com.hyber.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyber.vendor.repository.dataentity.VendorReg;

@Repository
public interface VendorRepo extends JpaRepository<VendorReg, Integer>{

}
