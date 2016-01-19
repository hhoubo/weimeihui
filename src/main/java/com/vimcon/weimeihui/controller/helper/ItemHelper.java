package com.vimcon.weimeihui.controller.helper;

import com.vimcon.weimeihui.dto.ItemDto;
import com.vimcon.weimeihui.model.Item;

public final class ItemHelper {
	private ItemHelper() {

	}

	public static Item convertItemDto2Vo(ItemDto itemDto) {
		return new Item(itemDto.getId(), itemDto.getName(),
				itemDto.getInvoiceName(), itemDto.getDescription());

	}

	public static ItemDto convertVo2ItemDto(Item item) {
		return new ItemDto(item.getId(), item.getName(), item.getInvoiceName(),
				item.getDescription());
	}
}
