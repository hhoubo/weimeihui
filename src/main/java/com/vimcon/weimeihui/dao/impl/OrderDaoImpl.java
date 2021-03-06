package com.vimcon.weimeihui.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.vimcon.weimeihui.dao.spec.OrderDao;
import com.vimcon.weimeihui.model.ShipmentReceipt;
@Component
public class OrderDaoImpl implements OrderDao {
	private static final Logger logger = LoggerFactory
            .getLogger(OrderDaoImpl.class);
	private static final String ORDER_TABLE = "orders";
	private static final String SELECT_SQL = "SELECT * FROM " + ORDER_TABLE + "WHERE MONTH(orderDate) = ? ";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    
	@Override
	public List<ShipmentReceipt> getMonthlyOrders(int month) {
		assert(month >= 1 && month <=12 );
		return jdbcTemplate
                .query(SELECT_SQL,
                        BeanPropertyRowMapper.newInstance(ShipmentReceipt.class)).stream()
                .collect(Collectors.toList());
	}

	@Override
	public ShipmentReceipt insertOrder(ShipmentReceipt orderDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipmentReceipt updateOrder(ShipmentReceipt orderDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipmentReceipt deleteOrder(long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
