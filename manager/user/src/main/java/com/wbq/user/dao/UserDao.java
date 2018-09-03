package com.wbq.user.dao;

import java.util.List;

import com.wbq.user.dto.UserDto;
import com.wbq.user.po.UserPO;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

/**
  *
  * @author biqin.wu
  * @since 02 九月 2018
  */
@Repository
public interface UserDao {

	/**
	 * 插入新用户
	 * @param userPO 用户信息
	 * @return 0：失败 1：成功
	 */
	int insertUser(UserPO userPO);

	/**
	 * 通过account获得用户信息
	 * @param account 账号
	 * @return 账号信息
	 */
	UserPO getUserByAccount(@Param("account") String account);

	/**
	 * 通过用户id获得用户的权限
	 * @param userId 用户id
	 * @return 用户的权限
	 */
	UserDto getUserPrivilegeById(@Param("userId") Integer userId);

	/**
	 * 通过账号和用户名获得用户
	 * @param account 账号
	 * @param name 用户名
	 * @return 用户信息集合
	 */
	List<UserPO> getUserByAccountAndName(@Param("account") String account, @Param("name") String name);

	/**
	 * 通过账号更新用户信息
	 * @param account 账号
	 * @return 0：失败 1：成功
	 */
	int updateUserByAccount(@Param("account") String account);
}
