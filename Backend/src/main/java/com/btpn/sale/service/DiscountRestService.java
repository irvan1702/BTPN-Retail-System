package com.btpn.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/discount")
public class DiscountRestService {
	
	@Autowired
	Discount disc;

	@RequestMapping(method = RequestMethod.POST, path = "/{userId}/netAmount/{isGroceries}")
	public Double getNetAmount(@PathVariable(value="userId") Integer userId, @RequestBody @Validated@PathVariable(value="isGroceries") boolean isGroceries) {
		return disc.netPayableAmount(userId, isGroceries);
	}
	
	
}
