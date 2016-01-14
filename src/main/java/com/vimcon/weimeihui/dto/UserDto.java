package com.vimcon.weimeihui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String userAccount;
	private String password;
	private String name;
	private DateTime createdDate;
}
