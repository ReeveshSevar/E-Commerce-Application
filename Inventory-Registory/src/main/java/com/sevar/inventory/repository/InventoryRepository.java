package com.sevar.inventory.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sevar.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> 
{
	List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
