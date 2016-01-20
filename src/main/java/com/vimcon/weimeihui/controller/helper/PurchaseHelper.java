package com.vimcon.weimeihui.controller.helper;

import java.util.ArrayList;
import java.util.List;

import com.vimcon.weimeihui.dto.PurchaseReceiptDto;
import com.vimcon.weimeihui.dto.StockItemDto;
import com.vimcon.weimeihui.model.PurchaseItem;
import com.vimcon.weimeihui.model.PurchaseReceipt;
import com.vimcon.weimeihui.utils.UniqueKeyUtil;

public final class PurchaseHelper {
	private PurchaseHelper() {

	}

	public static List<PurchaseReceiptDto> extractPurchaseReceiptDto(
			PurchaseReceipt purchaseReceipt) {
		List<PurchaseReceiptDto> result = new ArrayList<PurchaseReceiptDto>();
		for (PurchaseItem item : purchaseReceipt.getPurchaseItems()) {
			result.add(new PurchaseReceiptDto(purchaseReceipt.getReceiptId(),
					item.getItemId(), item.getAmount(), item.getPrice(), item
							.getCurrency(), item.getTotal(), purchaseReceipt
							.getPurchaseDate(), purchaseReceipt.getPurchaser(),
					purchaseReceipt.getVendorId()));
		}
		return result;
	}

	public static List<StockItemDto> extractStockItemDto(
			PurchaseReceipt purchaseReceipt) {
		List<StockItemDto> result = new ArrayList<StockItemDto>();
		for (PurchaseItem item : purchaseReceipt.getPurchaseItems()) {
			result.add(new StockItemDto(item.getItemId(), UniqueKeyUtil
					.getPurchaseBatch(), item.getAmount(), item.getPrice(), item.getCurrency()));
		}

		return result;
	}
}
