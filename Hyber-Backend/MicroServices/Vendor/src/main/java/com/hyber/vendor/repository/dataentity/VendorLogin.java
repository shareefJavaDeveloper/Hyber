package com.hyber.vendor.repository.dataentity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hyber.vendor.repository.dataentity.compositeId.vendorLoginCompositeId;
import com.hyber.vendor.util.VendorConstants;

import lombok.Data;

@Data
@Entity
@Table (name = VendorConstants.VENDOR_LOGIN)
@IdClass(vendorLoginCompositeId.class)
public class VendorLogin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer vendorRegId;
	private String password;
	@Id
	private String emailId;

}
