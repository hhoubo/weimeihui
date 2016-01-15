package com.vimcon.weimeihui.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemInStock {
	private String itemId;
	private String invoiceName; //from items table
	private int purchaseReceiptId;
	private String purchaseBatch;
	private int remainAmount;
	private BigDecimal costPrice;
	private String currency;
}
