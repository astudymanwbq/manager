package com.wbq.user.dao;

import com.wbq.user.po.UserRolePO;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

/**
  *
  * @author biqin.wu@bianlifeng.com
  * @since 02 九月 2018
  */
@Repository
public interface UserRoleDao {
	/**
	 * 关联用户角色
	 * @param userRolePO 用户角色信息
	 * @return 0：失败 1：成功
	 */
	int insertUserRole(UserRolePO userRolePO);

	/**
	 * 通过用户id获得用户角色信息  目前一个用户只有一个角色
	 * @param userId 用户id
	 * @return 用户角色信息
	 */
	UserRolePO getUserRoleByUserId(@Param("userId") Integer userId);

}
