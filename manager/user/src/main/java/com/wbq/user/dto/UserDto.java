package com.wbq.user.dto;

import java.util.List;

import lombok.Data;

/**
  *
  * @author biqin.wu
  * @since 04 September 2018
  */
@Data
public class UserDto {
	private Integer userId;

	private String account;

	private String roleName;

	private List<MenuDto> menuList;
}
