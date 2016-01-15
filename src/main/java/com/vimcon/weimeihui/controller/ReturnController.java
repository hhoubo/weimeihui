package com.vimcon.weimeihui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.model.ReturnReceipt;
import com.vimcon.weimeihui.model.ShipmentReceipt;
import com.vimcon.weimeihui.service.spec.ReturnService;

@Controller
@RequestMapping(PathConst.RETURN)
public class ReturnController {

	@Autowired
	public ReturnService returnService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ShipmentReceipt returnMoney(@RequestBody ReturnReceipt returnReceipt) {
		//stockService
		return returnService.returnMoney(returnReceipt);
	}

}
