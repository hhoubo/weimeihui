package com.vimcon.weimeihui.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentReceiptDto {
	private String shipmentId;
	private String customerId;
	private String gift;
	private BigDecimal giftCost;
	private String giftCurrency;
	private BigDecimal expressFee;
	private String expressCurrency;
	private BigDecimal packageFee;
	private String packageCurrency;
	private BigDecimal exchangeRate;
	private DateTime saleDate;
	private boolean isReturn;
}
