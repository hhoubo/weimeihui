package com.vimcon.weimeihui.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnReceiptDto {
	private String returnId;
	private DateTime returnDate;
	private BigDecimal returnTotal;
}
