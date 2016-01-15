package com.vimcon.weimeihui.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vimcon.weimeihui.dao.spec.OrderDao;
import com.vimcon.weimeihui.model.ShipmentReceipt;
import com.vimcon.weimeihui.service.spec.ShipmentService;

@Component
public class ShipmentServiceImpl implements ShipmentService {

	private static final Logger logger = LoggerFactory
			.getLogger(ShipmentServiceImpl.class);

	@Autowired
    private OrderDao orderDao;
	
	@Override
	public List<ShipmentReceipt> getMonthlyOrders(int month) {
		return orderDao.getMonthlyOrders(month);
	}

	@Override
	public ShipmentReceipt createOrder(ShipmentReceipt order) {
		logger.debug("created order object : ", order);
		return orderDao.insertOrder(order);
	}

	@Override
	public ShipmentReceipt updateOrder(ShipmentReceipt order) {
		return orderDao.updateOrder(order);
	}

	@Override
	public ShipmentReceipt deleteOrder(long orderId) {
		return orderDao.deleteOrder(orderId);
	}

}
