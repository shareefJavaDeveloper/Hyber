package com.hyber.vendor.repository.dataentity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hyber.vendor.repository.dataentity.compositeId.VendorHistRegCompositeId;
import com.hyber.vendor.util.VendorConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = VendorConstants.VENDOR_HIST_REG)
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VendorHistRegCompositeId.class)
public class VendorHistReg implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer vendorRegId;
	private String password;
	private String firstName;
    private String lastName;
    private String Gender;
    private long contactNumber;
    private String city;
    private String countryCode;
    @Id
    private String emailId;
    private String vendorStatus;

}
