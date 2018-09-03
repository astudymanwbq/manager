package com.wbq.user.po;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
  * user表实体类
  * @author biqin.wu@bianlifeng.com
  * @since 02 九月 2018
  */
@Data
public class UserPO implements Serializable {
	private static final long serialVersionUID = -6564315688945839408L;

	private Integer id;

	private String name;

	private String account;

	private String password;

	private String imageUrl;

	private String phone;

	private String email;

	private Integer state;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;
}
