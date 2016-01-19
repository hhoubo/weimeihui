package com.vimcon.weimeihui.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vimcon.weimeihui.dao.spec.OrderDao;
import com.vimcon.weimeihui.dto.ReturnItemDto;
import com.vimcon.weimeihui.dto.ShipmentItemDto;
import com.vimcon.weimeihui.dto.ShipmentReceiptDto;
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
	public ShipmentReceipt deleteShipmentReceipt(long shipmentId) {
		return orderDao.deleteOrder(shipmentId);
	}


	@Override
	public void createShipmentReceipt(ShipmentReceiptDto shipmentReceiptDto,
			List<ShipmentItemDto> shipmentItemDtoList) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateShipmentReceipt(ShipmentReceiptDto shipmentReceiptDto,
			List<ShipmentItemDto> shipmentItemDtoList) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateReturnMark(List<ReturnItemDto> returnedShipmentReceiptList) {
		// TODO Auto-generated method stub
		
	}

}
