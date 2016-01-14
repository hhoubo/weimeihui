package com.vimcon.weimeihui.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vimcon.weimeihui.dao.spec.OrderDao;
import com.vimcon.weimeihui.dto.OrderDto;
import com.vimcon.weimeihui.service.spec.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory
			.getLogger(OrderServiceImpl.class);

	@Autowired
    private OrderDao orderDao;
	
	@Override
	public List<OrderDto> getMonthlyOrders(int month) {
		return orderDao.getMonthlyOrders(month);
	}

	@Override
	public OrderDto createOrder(OrderDto orderDto) {
		logger.debug("created order dto : ", orderDto);
		return orderDao.insertOrder(orderDto);
	}

	@Override
	public OrderDto updateOrder(OrderDto orderDto) {
		return orderDao.updateOrder(orderDto);
	}

	@Override
	public OrderDto deleteOrder(long orderId) {
		return orderDao.deleteOrder(orderId);
	}

}
