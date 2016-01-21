package com.vimcon.weimeihui.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vimcon.weimeihui.dao.spec.ItemDao;
import com.vimcon.weimeihui.dto.ItemDto;
import com.vimcon.weimeihui.service.spec.ItemService;

@Component
public class ItemServiceImpl implements ItemService {
	private static final Logger logger = LoggerFactory
			.getLogger(ItemServiceImpl.class);

	@Autowired
    private ItemDao itemDao;

	@Override
	public List<ItemDto> getAllItems() {
		
		return itemDao.getAllItems();
	}

	@Override
	public ItemDto createItem(ItemDto item) {
		return itemDao.insert(item);
	}

	@Override
	public boolean updateItem(ItemDto item) {
		return 1== itemDao.update(item);
	}

	@Override
	public boolean deleteItem(String itemId) {
		return 1 == itemDao.delete(itemId);
	}

}
