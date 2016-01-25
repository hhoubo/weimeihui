package com.vimcon.weimeihui.utils;

import org.joda.time.DateTime;

import com.eaio.uuid.UUID;

public class UniqueKeyUtil {

	public static String getPurchaseBatch() {
		return DateTime.now().toString("yyyyMMddHHmmssfffffff");
	}

	public static String getItemId() {
		return "ITEM-" + new UUID().toString();
	}
	public static String getCustomerId() {
		return	"CUSTOMER-" +  new UUID().toString();
	}
	public static String getPurchaseReceiptId(){
		return "PURCHASE-" + new UUID().toString();
	}
	public static String getReturnID(){
		return "RETURN-" + new UUID().toString();
	}
	public static String getShipmentID(){
		return "SHIPMENT-" + new UUID().toString();
	}
	public static String getVendorID(){
		return "VENDOR-" + new UUID().toString();
	}
}
