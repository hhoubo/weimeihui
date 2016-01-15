package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.model.ShipmentReceipt;

public interface ShipmentService {

	List<ShipmentReceipt> getMonthlyOrders(int month);

	ShipmentReceipt createOrder(ShipmentReceipt order);

	ShipmentReceipt updateOrder(ShipmentReceipt order);

	ShipmentReceipt deleteOrder(long orderId);

}
