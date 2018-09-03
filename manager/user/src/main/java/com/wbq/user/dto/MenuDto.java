package com.wbq.user.dto;

import lombok.Data;

/**
  *
  * @author biqin.wu
  * @since 04 September 2018
  */
@Data
public class MenuDto {
	private Integer menuId;

	private String url;

	private String menuName;

	private String menuType;

	private Integer menuParentId;
}
