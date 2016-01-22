package com.vimcon.weimeihui.service.impl;

import java.util.List;

import org.joda.time.DateTime;

import com.vimcon.weimeihui.dto.PurchaseReceiptDto;
import com.vimcon.weimeihui.model.PurchaseReceipt;
import com.vimcon.weimeihui.service.spec.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService {

	@Override
	public List<PurchaseReceipt> findPurchaseReceipt(DateTime startDate,
			DateTime endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recordPurchaseReceipt(
			List<PurchaseReceiptDto> purchaseReceiptDtoList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePurchaseReceipt(
			List<PurchaseReceiptDto> purchaseReceiptDtoList) {
		// TODO Auto-generated method stub

	}

}
