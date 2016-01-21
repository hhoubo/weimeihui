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
import com.vimcon.weimeihui.dto.ItemDto;
import com.vimcon.weimeihui.utils.UniqueKeyUtil;

@Component
public class ItemDaoImpl implements ItemDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ItemDaoImpl.class);
	private static final String ITEM_TABLE = "items";
	private static final String SELECT_SQL = "SELECT * FROM " + ITEM_TABLE;
	private static final String INSERT_SQL = "INSERT INTO " + ITEM_TABLE
			+ " (id, name, invoiceName, description) values(?, ?, ?, ?)";
	private static final String UPDATE_SQL = "update " + ITEM_TABLE
			+ " SET name = ?, invoiceName = ?, description = ? "
			+ "where id = ?";
	private static final String DELETE_SQL = "DELETE FROM " + ITEM_TABLE
			+ "WHERE id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

	@Override
	public List<ItemDto> getAllItems() {
		return jdbcTemplate
				.query(SELECT_SQL,
						BeanPropertyRowMapper.newInstance(ItemDto.class))
				.stream().collect(Collectors.toList());
	}

	@Override
	public ItemDto insert(ItemDto item) {
		item.setId(UniqueKeyUtil.getItemId());
		jdbcTemplate.update(INSERT_SQL, item.getId(), item.getName(),
				item.getInvoiceName(), item.getDescription());
		return item;
	}

	@Override
	public int update(ItemDto item) {
		return jdbcTemplate.update(UPDATE_SQL, item.getName(), item.getInvoiceName(),
				item.getDescription(), item.getId());
	}

	@Override
	public int delete(String itemId) {
		return jdbcTemplate.update(DELETE_SQL, itemId);
	}

}
