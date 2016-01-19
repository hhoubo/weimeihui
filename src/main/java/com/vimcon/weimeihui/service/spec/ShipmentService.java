package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.ReturnItemDto;
import com.vimcon.weimeihui.dto.ShipmentItemDto;
import com.vimcon.weimeihui.dto.ShipmentReceiptDto;
import com.vimcon.weimeihui.model.ShipmentReceipt;

public interface ShipmentService {

	List<ShipmentReceipt> getMonthlyOrders(int month);

	void createShipmentReceipt(ShipmentReceiptDto shipmentReceiptDto,
			List<ShipmentItemDto> shipmentItemDtoList);


	void updateShipmentReceipt(ShipmentReceiptDto shipmentReceiptDto,
			List<ShipmentItemDto> shipmentItemDtoList);

	ShipmentReceipt deleteShipmentReceipt(long shipmentId);

	void updateReturnMark(List<ReturnItemDto> returnedShipmentReceiptList);
}
