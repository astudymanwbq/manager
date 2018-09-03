package com.wbq.user.dao;

import java.util.List;

import com.wbq.user.po.MenuPO;

import org.springframework.stereotype.Repository;

/**
  *
  * @author biqin.wu@bianlifeng.com
  * @since 02 九月 2018
  */
@Repository
public interface MenuDao {
	/**
	 * 插入菜单信息
	 * @param menuPO 菜单信息
	 * @return 0：失败 1：成功
	 */
	int insertMenu(MenuPO menuPO);

	/**
	 * 获得全部的菜单
	 * @return 菜单集合
	 */
	List<MenuPO> getAllMenu();
}
