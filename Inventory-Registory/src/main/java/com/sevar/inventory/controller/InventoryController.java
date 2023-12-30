package com.sevar.inventory.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sevar.inventory.dto.InventoryResponse;
import com.sevar.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService service;
	
	@GetMapping
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode)
	{
		return service.isInStock(skuCode);
	}
	
}
