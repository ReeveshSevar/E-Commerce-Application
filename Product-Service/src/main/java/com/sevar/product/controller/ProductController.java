package com.sevar.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sevar.product.model.Product;
import com.sevar.product.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	public ProductServiceImpl service;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Product product)
	{
		service.create(product);
		return ResponseEntity.status(HttpStatus.CREATED).body("Product "+product.getName()+" Saved Succesfully");
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProd()
	{
		List<Product> list = service.getAll();
		System.err.println(list);
		return ResponseEntity.ok(list);
	}
}
