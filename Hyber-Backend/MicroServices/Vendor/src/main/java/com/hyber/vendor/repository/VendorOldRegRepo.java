package com.hyber.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyber.vendor.repository.dataentity.VendorOldReg;
@Repository
public interface VendorOldRegRepo extends JpaRepository<VendorOldReg, Integer>{

}
