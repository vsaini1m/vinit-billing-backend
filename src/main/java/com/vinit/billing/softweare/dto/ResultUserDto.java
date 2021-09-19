package com.vinit.billing.softweare.dto;

import java.util.List;

import com.vinit.billing.softweare.entity.User;

import lombok.Builder;
import lombok.Data;


import java.util.List;




@Builder
@Data
public class ResultUserDto {
	
	private boolean success;
	
	private List<String> errors;
	
	private User user;
	

}




