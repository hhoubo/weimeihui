package com.vimcon.weimeihui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vimcon.weimeihui.dto.PathConst;
import com.vimcon.weimeihui.dto.VendorDto;
import com.vimcon.weimeihui.service.spec.VendorService;

/**
 * @author hou-b
 *
 */

@Controller
@RequestMapping(PathConst.VENDOR)
public class VendorController {

	@Autowired
	private VendorService vendorService; 
	
	
	@RequestMapping(method = RequestMethod.GET, value="/{vendorId}")
	@ResponseBody
	public VendorDto findByVendorId(@PathVariable String vendorId) {
		return vendorService.findVendorById(vendorId);
	}
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public VendorDto addVendor(@RequestBody VendorDto vendor){
		//return remained items
		return vendorService.addVendor(vendor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{vendorId}")
	@ResponseBody
	public VendorDto deleteVendor(@PathVariable String vendorId){
		//return remained items
		return vendorService.deleteVendor(vendorId);
	}
}
