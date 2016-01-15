package com.vimcon.weimeihui.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentReceipt {
	private String shipmentId;
	private int customerId;
	private String customerName; //from customer table
	private String gift;
	private BigDecimal giftCost;
	private String giftCurrency;
	private BigDecimal expressFee;
	private String expressCurrency;
	private BigDecimal packageFee;
	private String packageCurrency;
	private BigDecimal exchangeRate;
	private DateTime saleDate;
	private Optional<DateTime> returnDate;
	private List<ShipmentItem> items;
	private boolean isReturn;
	
}
