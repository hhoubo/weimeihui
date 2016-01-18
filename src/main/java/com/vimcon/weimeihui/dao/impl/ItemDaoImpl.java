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

import com.vimcon.weimeihui.dao.spec.ItemDao;
import com.vimcon.weimeihui.dto.Item;
@Component
public class ItemDaoImpl implements ItemDao {
	private static final Logger logger = LoggerFactory
            .getLogger(ItemDaoImpl.class);
	private static final String ITEM_TABLE = "items";
	private static final String SELECT_SQL = "SELECT * FROM " + ITEM_TABLE;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
	@Override
	public List<Item> getAllItems() {
		return jdbcTemplate
                .query(SELECT_SQL,
                        BeanPropertyRowMapper.newInstance(Item.class)).stream()
                .collect(Collectors.toList());
	}
    
    

}
