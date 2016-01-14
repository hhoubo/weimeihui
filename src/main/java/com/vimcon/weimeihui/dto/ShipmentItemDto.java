package com.vimcon.weimeihui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentItemDto {
	private String shipmentId;
	private String itemId;
	private String batchId;
	private int amount;
}
