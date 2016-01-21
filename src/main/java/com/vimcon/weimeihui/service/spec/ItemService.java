package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.ItemDto;

public interface ItemService {

	List<ItemDto> getAllItems();

	ItemDto createItem(ItemDto item);

	boolean updateItem(ItemDto item);

	boolean deleteItem(String itemId);

}
