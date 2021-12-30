package com.hyber.vendor.repository.dataentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hyber.vendor.repository.dataentity.compositeId.VendorRegCompositeId;
import com.hyber.vendor.util.VendorConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = VendorConstants.VENDOR_REG)
@Data
@IdClass(VendorRegCompositeId.class)
public class VendorReg implements Serializable{
	
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
