package com.vimcon.weimeihui.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseReceipt {
	private int receiptId;
	private DateTime purchaseDate;
	private String purchaser;
	private String vendorId;
	private List<PurchaseItem> purchaseItems;
}
