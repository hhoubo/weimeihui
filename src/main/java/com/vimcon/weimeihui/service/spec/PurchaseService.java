package com.vimcon.weimeihui.service.spec;

import java.util.List;

import org.joda.time.DateTime;

import com.vimcon.weimeihui.dto.PurchaseReceiptDto;
import com.vimcon.weimeihui.model.PurchaseReceipt;

public interface PurchaseService {

	List<PurchaseReceipt> findPurchaseReceipt(DateTime startDate, DateTime endDate);

	void recordPurchaseReceipt(List<PurchaseReceiptDto> purchaseReceiptDtoList);

	void updatePurchaseReceipt(List<PurchaseReceiptDto> purchaseReceiptDtoList);


}
