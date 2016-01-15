package com.vimcon.weimeihui.dao.spec;

import java.util.List;

import com.vimcon.weimeihui.model.ShipmentReceipt;

public interface OrderDao {

	List<ShipmentReceipt> getMonthlyOrders(int month);

	ShipmentReceipt insertOrder(ShipmentReceipt orderDto);

	ShipmentReceipt updateOrder(ShipmentReceipt orderDto);

	ShipmentReceipt deleteOrder(long orderId);

}
