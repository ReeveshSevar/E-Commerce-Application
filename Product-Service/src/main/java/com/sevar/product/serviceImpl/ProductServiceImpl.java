package com.sevar.product.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sevar.product.model.Product;
import com.sevar.product.repository.ProductRepository;
import com.sevar.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService 
{

	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product create(Product product) 
	{
		return repo.save(product);
	}
	@Override
	public List<Product> getAll()
	{
		return repo.findAll();
	}
}
