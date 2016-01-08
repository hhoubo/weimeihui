package com.vimcon.weimeihui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.dto.ItemDto;
import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.service.spec.ItemService;

@Controller
@RequestMapping(PathConst.ITEM)
public class ItemController {

	@Autowired
	public ItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	@ResponseBody
	public List<ItemDto> getAllItems() {

		return itemService.getAllItems();

	}
}
