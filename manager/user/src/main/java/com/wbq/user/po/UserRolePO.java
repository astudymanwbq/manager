package com.wbq.user.po;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
  * user_role表实体类
  * @author biqin.wu
  * @since 02 九月 2018
  */
@Data
public class UserRolePO implements Serializable {
	private static final long serialVersionUID = -4854727690677975437L;

	private Integer id;

	private Integer userId;

	private Integer roleId;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;
}
