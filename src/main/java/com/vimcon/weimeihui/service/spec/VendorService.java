package com.vimcon.weimeihui.service.spec;

import com.vimcon.weimeihui.dto.VendorDto;

public interface VendorService {

	public VendorDto findVendorById(String vendorId);

	public VendorDto addVendor(VendorDto vendor);

	public VendorDto deleteVendor(String vendorId); 

}
