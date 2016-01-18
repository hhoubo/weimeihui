package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.Item;

public interface ItemService {

	List<Item> getAllItems();

	Item createItem(Item item);

	Item updateItem(Item item);

	Item deleteItem(String itemId);

}
