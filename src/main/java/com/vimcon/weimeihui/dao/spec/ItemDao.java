package com.vimcon.weimeihui.dao.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.ItemDto;

public interface ItemDao {
	List<ItemDto> getAllItems();

	ItemDto insert(ItemDto item);

	int update(ItemDto item);

	int delete(String itemId);
}
