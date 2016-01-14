package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.model.Order;

public interface OrderService {

	List<Order> getMonthlyOrders(int month);

	Order createOrder(Order order);

	Order updateOrder(Order order);

	Order deleteOrder(long orderId);

}
