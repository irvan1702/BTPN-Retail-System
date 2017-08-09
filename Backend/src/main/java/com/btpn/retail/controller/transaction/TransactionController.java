//package com.btpn.retail.controller.transaction;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.btpn.persistence.item.Item;
//import com.btpn.persistence.item.ItemService;
//
//@RestController
//public class  TransactionController{
//	
//	@Autowired 
//	ItemService itemServiceDAO;
//	
//	@RequestMapping(method = RequestMethod.GET, value = "itemList")
//	@CrossOrigin
//	public @ResponseBody List<Item> getAllItemList() {
//		return itemServiceDAO.getAllItem();
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value = "itemById")
//	@CrossOrigin
//	public @ResponseBody Item getItemById(@RequestParam(value="itemId",defaultValue=" ")Integer itemId) {
//		return itemServiceDAO.findItemById(itemId);
//	}
//	
//	@RequestMapping(value = "itemAdd", method = RequestMethod.POST)
//	@CrossOrigin
//	public void addItem(@RequestBody(required=false) Item item) {
//		itemServiceDAO.insertItem(item);
//	}
//	
//	@RequestMapping(value = "itemModify", method = RequestMethod.PUT)
//	@CrossOrigin
//	public void modifyItem(@RequestBody(required=false) Item item) {
//		itemServiceDAO.updateItem(item);
//	}
//	
//	@RequestMapping(value = "itemDelete", method = RequestMethod.DELETE)
//	@CrossOrigin
//	public void deleteItem(@RequestParam(value="itemId",defaultValue=" ")Integer itemId) {
//		itemServiceDAO.deleteItem(itemId);
//	}
//}
