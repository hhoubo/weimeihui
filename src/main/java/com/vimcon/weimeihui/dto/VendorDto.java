package com.vimcon.weimeihui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDto {
	private String vendorId;
	private String address;
	private String tel;
}
