package com.gyojincompany.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.gyojincompany.entity.Item;

@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest2 {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	@DisplayName("상품 저장 코드 테스트")
	public void createItemTest() {
		
		for(int i=1;i<=10;i++) {
			
			Item item = new Item();
			item.setItemName("모나미볼펜"+i);
			item.setPrice(1000);
			item.setRegTime(LocalDateTime.now());
			item.setStockNumber(100);
			
			Item savedItem = itemRepository.save(item);
					
		}
	}
	
	@Test
	@DisplayName("상품 조회 테스트")
	public void findByItemNameTest() {
		this.createItemTest();
		List<Item> itemList = itemRepository.findByItemName("모나미볼펜1");
		
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("모든 상품 조회 리스트 출력 테스트")
	public void findByItemListTest() {
		this.createItemTest();
		List<Item> itemList = itemRepository.findAll();
		
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}

}
