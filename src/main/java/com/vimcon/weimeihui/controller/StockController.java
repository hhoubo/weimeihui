package com.vimcon.weimeihui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.model.ItemInStock;
import com.vimcon.weimeihui.service.spec.StockService;

@Controller
@RequestMapping(PathConst.STOCK)
public class StockController {

	@Autowired
	private StockService stockService; 
	
	@RequestMapping(method = RequestMethod.GET, value="/{itemId}")
	@ResponseBody
	public List<ItemInStock> findByItemId(@PathVariable String itemId) {
		return null;
	}
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ItemInStock consumeItem(@RequestBody List<ItemInStock> consumedItem){
		//reuturn remained items
		return null;
	}
}
