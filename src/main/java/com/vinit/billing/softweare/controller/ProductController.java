package com.vinit.billing.softweare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinit.billing.softweare.dto.ResultProdutDto;
import com.vinit.billing.softweare.dto.ResultUserDto;
import com.vinit.billing.softweare.entity.Product;
import com.vinit.billing.softweare.entity.User;
import com.vinit.billing.softweare.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/vinit/billing/soft/api/product")
@CrossOrigin("*")
public class ProductController {

	private final ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<?> createProduct(@RequestBody Product product) throws Exception {
		
		
		
		 ResultProdutDto addProduct = this.productService.addProduct(product);
		
		
		
		 return addProduct.isSuccess()?
					ResponseEntity.ok(addProduct.getProduct()):
						ResponseEntity.badRequest().body(addProduct.getErrors());
					
	}
	
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> getUser(@PathVariable("userid") Long userid) {
		
		Product product=new Product();
		product.setId(userid);
		
		 ResultProdutDto findProductById = this.productService.findProductById(product);
		
		return findProductById.isSuccess()?
				ResponseEntity.ok(findProductById.getProduct()):
					ResponseEntity.badRequest().body(findProductById.getErrors());
		
		
		
	}
	

	@PutMapping("/")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) throws Exception {
		
		
		
		 ResultProdutDto updateProduct = this.productService.addProduct(product);
		
		
		
		 return updateProduct.isSuccess()?
					ResponseEntity.ok(updateProduct.getProduct()):
						ResponseEntity.badRequest().body(updateProduct.getErrors());
					
	}
	
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable("userid") Long userid) {
		
		Product product=new Product();
		product.setId(userid);
		
		 ResultProdutDto findProductById = this.productService.deleteProduct(product);
		
		return findProductById.isSuccess()?
				ResponseEntity.ok(findProductById.getProduct()):
					ResponseEntity.badRequest().body(findProductById.getErrors());
		
		
		
	}
	
}
