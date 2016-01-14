package com.vimcon.weimeihui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.money.Money;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	private String itemName;
	private Money costJPY;
	private int quantity;
	private Money expressFeeJPY;
	private Money giftCostJPY;
	
	private Money costRMB;
	private Money expressFeeRMB;
	private Money giftCostRMB;
	private Money costSumJPY;
	private Money costSumRMB;
	
	private long exchangeRage;
}
