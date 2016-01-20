package com.vimcon.weimeihui.controller;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.controller.helper.PurchaseHelper;
import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.dto.PurchaseReceiptDto;
import com.vimcon.weimeihui.dto.StockItemDto;
import com.vimcon.weimeihui.model.PurchaseReceipt;
import com.vimcon.weimeihui.service.spec.PurchaseService;
import com.vimcon.weimeihui.service.spec.StockService;

@Controller
@RequestMapping(PathConst.PURCHASE)
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private StockService stockService; 
	
	@RequestMapping(method = RequestMethod.POST, headers = { "Content-Type=application/json" })
	@ResponseBody
	public void addPurchaseReceipt(@RequestBody PurchaseReceipt purchaseReceipt) {
		List<PurchaseReceiptDto>  purchaseReceiptDtoList = PurchaseHelper.extractPurchaseReceiptDto(purchaseReceipt);
		List<StockItemDto> stockItemDtoList = PurchaseHelper.extractStockItemDto(purchaseReceipt);
		purchaseService.recordPurchaseReceipt(purchaseReceiptDtoList);
		stockService.pushItemsInStock(stockItemDtoList);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void updatePurchaseReceipt(@RequestBody PurchaseReceipt purchaseReceipt) {
		List<PurchaseReceiptDto>  purchaseReceiptDtoList = PurchaseHelper.extractPurchaseReceiptDto(purchaseReceipt);
		List<StockItemDto> stockItemDtoList = PurchaseHelper.extractStockItemDto(purchaseReceipt);
		purchaseService.updatePurchaseReceipt(purchaseReceiptDtoList);
		stockService.modifyItemsInStock(stockItemDtoList);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<PurchaseReceipt> findPurchaseReceipt(@RequestParam DateTime startDate, @RequestParam DateTime endDate) {
		return purchaseService.findPurchaseReceipt(startDate, endDate);
	}
}
