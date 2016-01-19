package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.StockItemDto;
import com.vimcon.weimeihui.model.ItemInStock;

public interface StockService {

	void pushItemsInStock(List<StockItemDto> stockItemDtoList);

	void modifyItemsInStock(List<StockItemDto> stockItemDtoList);

	ItemInStock findItemInStock(String itemId);

	/**
	 * 
	 * @param consumedItems
	 * @return the remained items
	 */
	List<ItemInStock> consumeItems(List<ItemInStock> consumedItems);

}
