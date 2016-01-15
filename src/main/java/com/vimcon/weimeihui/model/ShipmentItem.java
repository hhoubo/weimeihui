package com.vimcon.weimeihui.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShipmentItem {
	private String itemId;
	private String itemInvoiceName;
	private String batchId;
	private int amount;
	private BigDecimal costPrice;
	private String currency;
	
}
