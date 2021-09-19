package com.vinit.billing.softweare.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vinit.billing.softweare.dto.ResultProdutDto;
import com.vinit.billing.softweare.dto.ResultUserDto;
import com.vinit.billing.softweare.entity.Product;
import com.vinit.billing.softweare.entity.User;
import com.vinit.billing.softweare.repositery.ProductRepositery;
import com.vinit.billing.softweare.repositery.UserRepositery;
import com.vinit.billing.softweare.service.ProductService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	
	private final ProductRepositery productRepositery;
	
	
	
	@Override
	public ResultProdutDto addProduct(Product product) {
		
		
		
		Product savedProduct = this.productRepositery.save(product);
	
		ResultProdutDto resultProdutDto = null;

		
		if (savedProduct == null) {

			List<String> errors = new ArrayList<>();

			errors.add("Product not saved.");

			resultProdutDto = ResultProdutDto.builder().success(false).errors(errors).build();

		} else {
			resultProdutDto = ResultProdutDto.builder().success(true).product(new ModelMapper().map(savedProduct, Product.class))
					.build();
		}
		
		return resultProdutDto;

	}

	@Override
	public ResultProdutDto findProductById(Product product) {
		
		

		Optional<Product> findById = this.productRepositery.findById(product.getId());
	
		ResultProdutDto resultProdutDto = null;

		
		if (!findById.isPresent()) {

			List<String> errors = new ArrayList<>();

			errors.add("Product not found.");

			resultProdutDto = ResultProdutDto.builder().success(false).errors(errors).build();

		} else {
			resultProdutDto = ResultProdutDto.builder().success(true).product(new ModelMapper().map(findById, Product.class))
					.build();
		}
		
		return resultProdutDto;

	}

	@Override
	public ResultProdutDto updateProduct(Product product) {
		
		
		Product updateProduct = this.productRepositery.save(product);
		
		ResultProdutDto resultProdutDto = null;

		
		if (updateProduct == null) {

			List<String> errors = new ArrayList<>();

			errors.add("Unable to update product.");

			resultProdutDto = ResultProdutDto.builder().success(false).errors(errors).build();

		} else {
			resultProdutDto = ResultProdutDto.builder().success(true).product(new ModelMapper().map(updateProduct, Product.class))
					.build();
		}
		
		return resultProdutDto;
	}

	@Override
	public ResultProdutDto deleteProduct(Product product) {
		
		
		Optional<Product> findById = this.productRepositery.findById(product.getId());
		
		ResultProdutDto resultProdutDto = null;

		
		if (!findById.isPresent()) {

			List<String> errors = new ArrayList<>();

			errors.add("Product not found.");

			resultProdutDto = ResultProdutDto.builder().success(false).errors(errors).build();

		} else {
			

			try {

				this.productRepositery.delete(findById.get());

			} catch (Exception e) {

				List<String> errors = new ArrayList<>();

				errors.add("Unable to delete Product");

				resultProdutDto = ResultProdutDto.builder().success(false).errors(errors).build();

			}
			
			
			
			resultProdutDto = ResultProdutDto.builder().success(true).product(new ModelMapper().map(findById, Product.class))
					.build();
		}
		
		return resultProdutDto;
	}

}
