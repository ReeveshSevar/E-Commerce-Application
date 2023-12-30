package com.sevar.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sevar.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	
}
