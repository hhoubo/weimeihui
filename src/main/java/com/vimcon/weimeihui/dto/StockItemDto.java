package com.vimcon.weimeihui.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockItemDto {
	private String itemId;
	private String purchase_batch;
	private int remainAmount;
	private BigDecimal costPrice;
	private String currency;
}
