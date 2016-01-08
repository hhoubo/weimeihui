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

	@RequestMapping(method = RequestMethod.GET, value = "/list/{month}")
	@ResponseBody
	public List<OrderDto> getAllEvents(@PathVariable int month) {

		return orderService.getMonthlyOrders(month);

	}
}
