package com.vimcon.weimeihui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.controller.helper.ShipmentReceiptHelper;
import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.dto.ShipmentItemDto;
import com.vimcon.weimeihui.dto.ShipmentReceiptDto;
import com.vimcon.weimeihui.dto.StockItemDto;
import com.vimcon.weimeihui.model.ShipmentReceipt;
import com.vimcon.weimeihui.service.spec.ShipmentService;
import com.vimcon.weimeihui.service.spec.StockService;

@Controller
@RequestMapping(PathConst.SHIPMENT)
public class ShipmentController {

	@Autowired
	public ShipmentService shipmentService;

	@Autowired
	public StockService stockService;

	/**
	 * Show the shipment receipt list in the specified month
	 * 
	 * @param month
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/shipment-receipts/{month}")
	@ResponseBody
	public List<ShipmentReceipt> getMonthlyOrders(@PathVariable int month) {
		return shipmentService.getMonthlyOrders(month);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void createShipmentReceipt(
			@RequestBody ShipmentReceipt shipmentReceipt) {
		// 1. save shipment receipt and items
		ShipmentReceiptDto shipmentReceiptDto = ShipmentReceiptHelper
				.extractShipmentReceiptDto(shipmentReceipt);
		List<ShipmentItemDto> shipmentItemDtoList = ShipmentReceiptHelper
				.extractShipmentItemDtos(shipmentReceipt);
		shipmentService.createShipmentReceipt(shipmentReceiptDto,
				shipmentItemDtoList);
		List<StockItemDto> consumedItems = ShipmentReceiptHelper
				.extractStockItemDtos(shipmentReceipt);
		// 2. update the stock
		stockService.modifyItemsInStock(consumedItems);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void updateShipmentReceipt(
			@RequestBody ShipmentReceipt shipmentReceipt) {
		// 1. save shipment receipt and items
		ShipmentReceiptDto shipmentReceiptDto = ShipmentReceiptHelper
				.extractShipmentReceiptDto(shipmentReceipt);
		List<ShipmentItemDto> shipmentItemDtoList = ShipmentReceiptHelper
				.extractShipmentItemDtos(shipmentReceipt);
		shipmentService.updateShipmentReceipt(shipmentReceiptDto,
				shipmentItemDtoList);
		List<StockItemDto> consumedItems = ShipmentReceiptHelper
				.extractStockItemDtos(shipmentReceipt);
		// 2. update the stock
		stockService.modifyItemsInStock(consumedItems);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{orderId}")
	@ResponseBody
	public ShipmentReceipt deleteOrder(@PathVariable long shipmentId) {
		return shipmentService.deleteShipmentReceipt(shipmentId);
	}

}
