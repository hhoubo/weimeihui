package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.OrderDto;

public interface OrderService {

	List<OrderDto> getMonthlyOrders(int month);

	OrderDto createOrder(OrderDto orderDto);

	OrderDto updateOrder(OrderDto orderDto);

	OrderDto deleteOrder(long orderId);

}
