package com.vimcon.weimeihui.dao.spec;

import java.util.List;

import com.vimcon.weimeihui.model.Order;

public interface OrderDao {

	List<Order> getMonthlyOrders(int month);

	Order insertOrder(Order orderDto);

	Order updateOrder(Order orderDto);

	Order deleteOrder(long orderId);

}
