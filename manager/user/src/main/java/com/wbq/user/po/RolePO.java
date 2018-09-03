package com.wbq.user.po;


import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * role表实体类
  * @author biqin.wu
  * @since 02 九月 2018
  */
@Data
@NoArgsConstructor
public class RolePO implements Serializable {
	private static final long serialVersionUID = -8278131497430192833L;

	private Integer id;

	private String name;

	private String description;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;
}
