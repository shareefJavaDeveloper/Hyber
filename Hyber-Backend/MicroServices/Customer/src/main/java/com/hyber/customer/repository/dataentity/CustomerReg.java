package com.hyber.customer.repository.dataentity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hyber.customer.repository.dataentity.compositeId.CustomerRegCompositeId;
import com.hyber.customer.util.CustomerConstants.TableNames;

import lombok.Data;

@Entity
@Table (name = TableNames.CUSTOMER_REG)
@Data
@IdClass(CustomerRegCompositeId.class)
public class CustomerReg implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer customerRegId;
	private String password;
	private String firstName;
    private String lastName;
    private String Gender;
    private long contactNumber;
    private String city;
    private String countryCode;
    @Id
    private String emailId;

}

