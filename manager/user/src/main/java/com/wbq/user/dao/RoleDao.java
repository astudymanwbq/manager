package com.wbq.user.dao;

import java.util.List;

import com.wbq.user.po.RolePO;

import org.springframework.stereotype.Repository;

/**
  *
  * @author biqin.wu
  * @since 02 九月 2018
  */
@Repository
public interface RoleDao {

	/**
	 * 创建角色
	 * @param rolePO 角色信息
	 * @return 0：失败 1：成功
	 */
	int insertRole(RolePO rolePO);

	/**
	 * 获得所有的角色
	 * @return 角色集合
	 */
	List<RolePO> getAllRoles();

}
