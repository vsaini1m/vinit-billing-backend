package com.vinit.billing.softweare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String type;
	private String category;
	
	
	private String unitOfMesaurement;
	
	private String HSN;
	
	private String itemTexability;
	
	private String sgst;
	
	private String igst;
	

	private String cgst;
	
	private String rate;
	

}
