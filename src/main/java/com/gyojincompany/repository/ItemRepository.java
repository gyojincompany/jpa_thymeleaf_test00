package com.gyojincompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	List<Item> findByItemName(String ItemName);
	
}
