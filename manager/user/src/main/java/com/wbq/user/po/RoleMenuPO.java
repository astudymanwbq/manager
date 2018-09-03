package com.wbq.user.po;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * role_menu表实体类
  * @author biqin.wu@bianlifeng.com
  * @since 02 九月 2018
  */
@Data
@NoArgsConstructor
public class RoleMenuPO implements Serializable {
	private static final long serialVersionUID = 5791759878587091200L;

	private Integer id;

	private Integer roleId;

	private Integer menuId;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

}
