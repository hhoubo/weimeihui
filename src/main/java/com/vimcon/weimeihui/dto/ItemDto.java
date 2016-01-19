package com.vimcon.weimeihui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	private String id;
	private String name;
	private String invoiceName;
	private String description;
}
