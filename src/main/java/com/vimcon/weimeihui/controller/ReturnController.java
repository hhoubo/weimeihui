package com.vimcon.weimeihui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.controller.helper.ReturnReceiptHelper;
import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.dto.ReturnItemDto;
import com.vimcon.weimeihui.dto.ReturnReceiptDto;
import com.vimcon.weimeihui.model.ReturnReceipt;
import com.vimcon.weimeihui.service.spec.ReturnService;
import com.vimcon.weimeihui.service.spec.ShipmentService;

@Controller
@RequestMapping(PathConst.RETURN)
public class ReturnController {

	@Autowired
	private ReturnService returnService;
	@Autowired
	private ShipmentService shipmentService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void returnMoney(@RequestBody ReturnReceipt returnReceipt) {
		//save return info
		ReturnReceiptDto returnReceiptDto= ReturnReceiptHelper.extractReturnReceiptDto(returnReceipt);
		returnService.saveReturnReceipt(returnReceiptDto);
		List<ReturnItemDto> returnedShipmentReceiptList =  ReturnReceiptHelper.extractReturnedShipmentReceipt(returnReceipt);
		//shipmentReceiptService update return status
		shipmentService.updateReturnMark(returnedShipmentReceiptList);
	}
	
	@RequestMapping(method= RequestMethod.PUT)
	@ResponseBody
	public void updateReturnReceipt(@RequestBody ReturnReceipt returnReceipt){
		//TODO implement it
		
		//get original return receipt to confirm if the receipt exist
		
		//delete original returnreceiptDto
		
		//revert the return mark
		
		//insert the new return receipt
		
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/{returnReceiptId}")
	@ResponseBody
	public ReturnReceipt getDetailReturnReceipt(@PathVariable String returnReceiptId){
		return returnService.getDetailReturnReceipt(returnReceiptId);
	}
	
	/**
	 * 
	 * @param month 1~12
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET, value="/{month}")
	@ResponseBody
	public List<ReturnReceipt> getReturnReceiptList(@PathVariable int month){
		return returnService.getReturnReceiptListInMonth(month);
	}

}
