package com.vimcon.weimeihui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.dto.OrderDto;
import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.service.spec.OrderService;

@Controller
@RequestMapping(PathConst.ORDER)
public class OrderController {

	@Autowired
	public OrderService orderService;

	@RequestMapping(method = RequestMethod.GET, value = "/orders/{month}")
	@ResponseBody
	public List<OrderDto> getMonthlyOrders(@PathVariable int month) {

		return orderService.getMonthlyOrders(month);

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/orders/{order}")
	@ResponseBody
	public OrderDto createOrder(@PathVariable OrderDto orderDto) {
		return orderService.createOrder(orderDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/orders/{order}")
	@ResponseBody
	public OrderDto updateOrder(@PathVariable OrderDto orderDto) {
		return orderService.updateOrder(orderDto);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "orders/{orderId}")
	@ResponseBody
	public OrderDto deleteOrder(@PathVariable long orderId) {
		return orderService.deleteOrder(orderId);
	}
	
	
	

}
