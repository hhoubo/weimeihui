package com.vimcon.weimeihui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.dto.Item;
import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.service.spec.ItemService;

@Controller
@RequestMapping(PathConst.ITEM)
public class ItemController {

	@Autowired
	public ItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	@ResponseBody
	public List<Item> getAllItems() {

		return itemService.getAllItems();

	}
	
	@RequestMapping(method = RequestMethod.POST, headers = { "Content-Type=application/json" })
	@ResponseBody
	public Item createItem(@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Item updateItem(@RequestBody Item item) {
		return itemService.updateItem(item);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{itemId}")
	@ResponseBody
	public Item deleteItem(@PathVariable String itemId) {
		return itemService.deleteItem(itemId);
	}
}
