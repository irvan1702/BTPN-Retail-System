package com.btpn.persistence.item;

import java.util.List;

import org.springframework.stereotype.Component;

import com.btpn.persistence.item.*;

@Component
public interface ItemService {
	
	List<Item> getAllItem();
	
	Item findItemById(Integer itemId);
	
	public void insertItem(Item item);

	public void updateItem(Item item);

	public void deleteItem(Integer itemId);
	
}
