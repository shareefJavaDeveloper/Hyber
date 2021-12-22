package com.hyber.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyber.vendor.repository.dataentity.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Integer>{

}
