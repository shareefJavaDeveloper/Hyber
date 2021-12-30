package com.hyber.vendor.repository.dataentity.compositeId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VendorHistRegCompositeId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private Integer vendorRegId;

	@Column
	private String emailId;
	
	

}
