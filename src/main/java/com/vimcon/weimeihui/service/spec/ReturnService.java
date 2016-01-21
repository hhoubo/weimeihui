package com.vimcon.weimeihui.service.spec;

import java.util.List;

import com.vimcon.weimeihui.dto.ReturnReceiptDto;
import com.vimcon.weimeihui.model.ReturnReceipt;

public interface ReturnService {

	void saveReturnReceipt(ReturnReceiptDto returnReceiptDto);

	ReturnReceipt getDetailReturnReceipt(String returnReceiptId);

	List<ReturnReceipt> getReturnReceiptListInMonth(int month);

}
