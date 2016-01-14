package com.vimcon.weimeihui.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vimcon.weimeihui.dao.spec.OrderDao;
import com.vimcon.weimeihui.model.Order;
import com.vimcon.weimeihui.service.spec.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory
			.getLogger(OrderServiceImpl.class);

	@Autowired
    private OrderDao orderDao;
	
	@Override
	public List<Order> getMonthlyOrders(int month) {
		return orderDao.getMonthlyOrders(month);
	}

	@Override
	public Order createOrder(Order order) {
		logger.debug("created order object : ", order);
		return orderDao.insertOrder(order);
	}

	@Override
	public Order updateOrder(Order order) {
		return orderDao.updateOrder(order);
	}

	@Override
	public Order deleteOrder(long orderId) {
		return orderDao.deleteOrder(orderId);
	}

}
