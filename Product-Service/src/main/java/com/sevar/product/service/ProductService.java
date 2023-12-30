package com.sevar.product.service;

import java.util.List;
import com.sevar.product.model.Product;

public interface ProductService 
{
	Product create(Product product);
	
	List<Product> getAll();
}
