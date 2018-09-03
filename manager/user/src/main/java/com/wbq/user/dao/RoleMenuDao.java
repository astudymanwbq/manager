package com.wbq.user.dao;

import java.util.List;

import com.wbq.user.po.RoleMenuPO;

import org.springframework.stereotype.Repository;

/**
  *
  * @author biqin.wu
  * @since 03 九月 2018
  */
@Repository
public interface RoleMenuDao {
	/**
	 * 插入角色菜单表
	 * @param roleMenuPO 角色菜单关联
	 * @return 0：失败 1：成功
	 */
	int insertRoleMenu(RoleMenuPO roleMenuPO);

	/**
	 * 通过角色id获得menu
	 * @param roleId 角色id
	 * @return 角色菜单集合
	 */
	List<RoleMenuPO> getRoleMenuByRoleId(Integer roleId);
}
