package com.vinit.billing.softweare.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinit.billing.softweare.entity.Product;
import com.vinit.billing.softweare.entity.User;


@Repository
public interface ProductRepositery extends JpaRepository<Product, Long>{

	
}
