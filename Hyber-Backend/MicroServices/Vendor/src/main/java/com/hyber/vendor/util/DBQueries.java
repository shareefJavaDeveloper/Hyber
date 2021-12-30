package com.hyber.vendor.util;

public class DBQueries {
	
	public static final String UPDATE_ACCEPTED_VENDORSTATUS = "update Vendor_Registration set vendorStatus = 'Accepted'" + 
														"where vendorRegId = :vendorRegId";
	
	public static final String UPDATE_REJECTED_VENDORSTATUS = "update Vendor_Registration set vendorStatus = 'Rejected'" + 
														"where vendorRegId = :vendorRegId";

}
