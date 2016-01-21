package com.vimcon.weimeihui.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.controller.helper.ItemHelper;
import com.vimcon.weimeihui.dto.ItemDto;
import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.model.Item;
import com.vimcon.weimeihui.service.spec.ItemService;

/**
 * Maintain the item list
 * @author hou-b 
 */
@Controller
@RequestMapping(PathConst.ITEM)
public class ItemController {

	@Autowired
	public ItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	@ResponseBody
	public List<Item> getAllItems() {
		return itemService.getAllItems().stream()
				.map(ItemHelper::convertItemDto2Vo)
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.POST, headers = { "Content-Type=application/json" })
	@ResponseBody
	public ItemDto createItem(@RequestBody Item item) {
		return itemService.createItem(ItemHelper.convertVo2ItemDto(item));
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public boolean updateItem(@RequestBody Item item) {
		return itemService.updateItem(ItemHelper.convertVo2ItemDto(item));
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{itemId}")
	@ResponseBody
	public boolean deleteItem(@PathVariable String itemId) {
		return itemService.deleteItem(itemId);
	}
}
