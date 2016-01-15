package com.vimcon.weimeihui.service.spec;

import com.vimcon.weimeihui.model.ReturnReceipt;
import com.vimcon.weimeihui.model.ShipmentReceipt;

public interface ReturnService {

	ShipmentReceipt returnMoney(ReturnReceipt returnReceipt);

}
