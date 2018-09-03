package com.wbq.user.po;


import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * menu表实体类
  * @author biqin.wu
  * @since 02 九月 2018
  */
@Data
@NoArgsConstructor
public class MenuPO implements Serializable {
	private static final long serialVersionUID = 340061472794944397L;

	private Integer id;

	private String url;

	private String name;

	private String type;

	private Integer parentId;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;
}
