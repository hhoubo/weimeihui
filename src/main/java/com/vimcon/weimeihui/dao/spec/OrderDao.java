package com.vimcon.weimeihui.dao.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.OrderDto;

public interface OrderDao {

	List<OrderDto> getMonthlyOrders(int month);

	OrderDto insertOrder(OrderDto orderDto);

	OrderDto updateOrder(OrderDto orderDto);

	OrderDto deleteOrder(long orderId);

}
