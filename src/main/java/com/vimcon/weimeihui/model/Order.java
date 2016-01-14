package com.vimcon.weimeihui.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private long orderId;
	private DateTime orderDate;
	private DateTime returnDate;
	private String customerId;
	private String customerName;
	private List<Item> items;
	private boolean isDone;
	
}
