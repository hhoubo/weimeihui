package com.vimcon.weimeihui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private int id;
	private String accountId;
	private String name;
	private String addressCountry;
	private String addressSheng;
	private String addressShi;
	private String addressQv;
	private String addressDetail;
	private String postcode;
	private String mobile;
	private String tel;
}
