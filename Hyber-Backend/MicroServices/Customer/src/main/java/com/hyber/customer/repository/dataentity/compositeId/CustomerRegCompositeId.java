package com.hyber.customer.repository.dataentity.compositeId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class CustomerRegCompositeId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private Integer customerRegId;
	@Column
    private String emailId;
}
