package com.hyber.admin.repository.dataentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorReg {
	
	private int VendorRegId;
	private String password;
	private String firstName;
    private String lastName;
    private String gender;
    private long contactNumber;
    private String city;
    private String countryCode;
}
