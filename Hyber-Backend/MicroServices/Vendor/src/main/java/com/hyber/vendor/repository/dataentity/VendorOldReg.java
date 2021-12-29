package com.hyber.vendor.repository.dataentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hyber.vendor.util.VendorConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = VendorConstants.VENDOR_OLD_REG)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorOldReg implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer VendorRegId;
	private String password;
	private String firstName;
    private String lastName;
    private String Gender;
    private long contactNumber;
    private String city;
    private String countryCode;

}
