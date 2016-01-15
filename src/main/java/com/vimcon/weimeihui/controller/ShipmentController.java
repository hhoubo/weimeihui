package com.vimcon.weimeihui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.model.ShipmentReceipt;
import com.vimcon.weimeihui.service.spec.ShipmentService;

@Controller
@RequestMapping(PathConst.SHIPMENT)
public class ShipmentController {

	@Autowired
	public ShipmentService shipmentService;

	@RequestMapping(method = RequestMethod.GET, value = "/shipment-receipts/{month}")
	@ResponseBody
	public List<ShipmentReceipt> getMonthlyOrders(@PathVariable int month) {

		return shipmentService.getMonthlyOrders(month);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ShipmentReceipt createOrder(@RequestBody ShipmentReceipt order) {
		//stockService
		return shipmentService.createOrder(order);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ShipmentReceipt updateOrder(@RequestBody ShipmentReceipt order) {
		return shipmentService.updateOrder(order);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/{orderId}")
	@ResponseBody
	public ShipmentReceipt deleteOrder(@PathVariable long orderId) {
		return shipmentService.deleteOrder(orderId);
	}
	
	
	

}
