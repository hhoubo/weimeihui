package com.vimcon.weimeihui.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReturnReceipt {
	private String returnId;
	private DateTime returnDate;
	private BigDecimal returnTotal; 
	private List<String> returnedShipmentId;
}
