package com.vimcon.weimeihui.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseItem {
	private String itemId;
	private int amount;
	private BigDecimal price;
	private String currency;
	private BigDecimal total;
}
