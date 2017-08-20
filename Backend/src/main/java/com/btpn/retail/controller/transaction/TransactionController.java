package com.btpn.retail.controller.transaction;

import com.btpn.persistence.transaction.Transaction;
import com.btpn.persistence.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  TransactionController{

	@Autowired
    TransactionService trasactionServiceDAO;

	@RequestMapping(method = RequestMethod.GET, value = "transactionList")
	@CrossOrigin
	public @ResponseBody List<Transaction> getAllTransactionList() {
		return trasactionServiceDAO.getAllTransaction();
	}

	@RequestMapping(method = RequestMethod.GET, value = "transactionById")
	@CrossOrigin
	public @ResponseBody Transaction getTransactionById(@RequestParam Integer transactionId) {
		return trasactionServiceDAO.findTransactionById(transactionId);
	}

	@RequestMapping(value = "transactionAdd", method = RequestMethod.POST)
	@CrossOrigin
	public void addTransaction(@RequestBody(required=false) Transaction transaction) {
		trasactionServiceDAO.insertTransaction(transaction);
	}

	@RequestMapping(value = "transactionModify", method = RequestMethod.PUT)
	@CrossOrigin
	public void modifyTransaction(@RequestBody(required=false) Transaction transaction) {
		trasactionServiceDAO.updateTransaction(transaction);
	}

	@RequestMapping(value = "transactionDelete", method = RequestMethod.DELETE)
	@CrossOrigin
	public void deleteTransaction(@RequestParam Integer transactionId) {
		trasactionServiceDAO.deleteTransaction(transactionId);
	}

    @RequestMapping(value = "calculateNet/{userId}/{itemId}/{quantity}", method = RequestMethod.GET)
    @CrossOrigin
	public Double getNetAmount(@PathVariable Integer userId, @PathVariable Integer itemId, @PathVariable Double quantity) {
		return trasactionServiceDAO.netPayableAmount(userId, itemId, quantity);
	}

    @RequestMapping(value = "totalDiscount", method = RequestMethod.GET)
    @CrossOrigin
    public Double getTotalDiscount() {
        return trasactionServiceDAO.getTotalDiscount();
    }
}
