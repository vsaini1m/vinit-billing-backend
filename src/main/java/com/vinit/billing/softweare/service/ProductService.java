package com.vinit.billing.softweare.service;

import com.vinit.billing.softweare.dto.ResultProdutDto;
import com.vinit.billing.softweare.dto.ResultUserDto;
import com.vinit.billing.softweare.entity.Product;
import com.vinit.billing.softweare.entity.User;

public interface ProductService {

	public ResultProdutDto addProduct(Product product);

	public ResultProdutDto findProductById(Product product);

	public ResultProdutDto updateProduct(Product product);

	public ResultProdutDto deleteProduct(Product product);

}
