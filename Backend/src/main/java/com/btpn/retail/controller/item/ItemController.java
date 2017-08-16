package com.btpn.retail.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.persistence.item.Item;
import com.btpn.persistence.item.ItemService;

@RestController
public class  ItemController{
	
	@Autowired 
	ItemService itemServiceDAO;
	
	@RequestMapping(method = RequestMethod.GET, value = "itemList")
	@CrossOrigin
	public @ResponseBody List<Item> getAllItemList() {
		return itemServiceDAO.getAllItem();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "itemById/{itemId}")
	@CrossOrigin
	public @ResponseBody Item getItemById(@PathVariable Integer itemId) {
//		@RequestParam(value="itemId",defaultValue=" "
		return itemServiceDAO.findItemById(itemId);
	}
	
	@RequestMapping(value = "itemAdd", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public void addItem(@RequestBody Item item) {
		itemServiceDAO.insertItem(item);
	}
	
	@RequestMapping(value = "itemModify", method = RequestMethod.PUT)
	@CrossOrigin
	@ResponseBody
	public void modifyItem(@RequestBody Item item) {
		itemServiceDAO.updateItem(item);

	}
	
	@RequestMapping(value = "itemDelete", method = RequestMethod.DELETE)
	@CrossOrigin
	public void deleteItem(@RequestParam(value="itemId",defaultValue=" ")Integer itemId) {
		itemServiceDAO.deleteItem(itemId);
	}
}
