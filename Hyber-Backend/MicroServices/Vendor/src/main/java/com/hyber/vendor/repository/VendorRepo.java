package com.hyber.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hyber.vendor.repository.dataentity.VendorHistReg;
import com.hyber.vendor.repository.dataentity.VendorReg;
import com.hyber.vendor.repository.dataentity.compositeId.VendorRegCompositeId;
import com.hyber.vendor.util.DBQueries;

@Repository
public interface VendorRepo extends JpaRepository<VendorReg, VendorRegCompositeId>{
	
	public VendorReg findByVendorRegId(int vendorRegId);
	
	public boolean existsByVendorRegId(int vendorRegId);
		
	@Modifying
	@Transactional
	@Query(value = DBQueries.UPDATE_ACCEPTED_VENDORSTATUS , nativeQuery = true)
	public void UpdateStatusSuccess(int vendorRegId);
	
	@Modifying
	@Transactional
	@Query(value = DBQueries.UPDATE_REJECTED_VENDORSTATUS , nativeQuery = true)
	public void UpdateStatusRejected(int vendorRegId);
}
