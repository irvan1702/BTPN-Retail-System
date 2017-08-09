package com.btpn.persistence.item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.btpn.persistence.item.Item;

@Service
@Repository
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDAO itemRepository;

	@Override
	public List<Item> getAllItem() {
		List<Item> listItem = new ArrayList<Item>();
		itemRepository.findAll().forEach(listItem::add);
		return listItem;
	}

	@Override
	public Item findItemById(Integer itemId) {
		return itemRepository.findOne(itemId);
	}

	@Override
	public void insertItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void updateItem(Item item) {
		itemRepository.save(item);
		
	}

	@Override
	public void deleteItem(Integer itemId) {
		itemRepository.delete(itemId);
		
	}
	
	
}
