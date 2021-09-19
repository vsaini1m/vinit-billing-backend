package com.vinit.billing.softweare.dto;

import java.util.List;

import com.vinit.billing.softweare.entity.Product;
import com.vinit.billing.softweare.entity.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class ResultProdutDto {
	private boolean success;

	private List<String> errors;

	private Product product;
}
