package com.hyber.admin.repository.dataentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
	
	private int VendorId;
	private String firstName;
    private String lastName;
    private String gender;
    private long contactNumber;
    private String city;
    private String countryCode;
}
