package com.vimcon.weimeihui.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;


/**
 * @author hou-b
 * Mapping to the table purchase_receipts
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseReceiptDto {
	private int receiptId;
	private String itemId;
	private int amount;
	private BigDecimal price;
	private String currency;
	private BigDecimal total;
	private DateTime purchaseDate;
	private String purchaser;
	private String vendorId;
}
