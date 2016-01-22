package com.vimcon.weimeihui.utils;

import com.eaio.uuid.UUIDGen;

public class UniqueKeyUtil {

	public static String getPurchaseBatch(String itemId) {
		//timestamp order
		return itemId + UUIDGen.newTime();
	}

	public static String getItemId() {
		//numberical 
		return String.valueOf(UUIDGen.getClockSeqAndNode());
	}

}
