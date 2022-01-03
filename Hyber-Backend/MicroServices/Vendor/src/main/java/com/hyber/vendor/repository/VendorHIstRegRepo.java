package com.hyber.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyber.vendor.repository.dataentity.VendorHistReg;
import com.hyber.vendor.repository.dataentity.VendorReg;
import com.hyber.vendor.repository.dataentity.compositeId.VendorHistRegCompositeId;

@Repository
public interface VendorHIstRegRepo extends JpaRepository<VendorHistReg, VendorHistRegCompositeId>{
	
	/**
	 * @param vendorRegId
	 * @return Object that fetched using vendorRegId
	 */
	
	public VendorHistReg findByVendorRegId(int vendorRegId);
	
	public boolean existsByVendorRegId(int vendorRegId);
}
