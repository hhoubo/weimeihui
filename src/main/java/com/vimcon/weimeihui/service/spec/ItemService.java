package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.ItemDto;

public interface ItemService {

	List<ItemDto> getAllItems();

	ItemDto createItem(ItemDto item);

	ItemDto updateItem(ItemDto item);

	ItemDto deleteItem(String itemId);

}
