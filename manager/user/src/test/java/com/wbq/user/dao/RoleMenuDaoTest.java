package com.wbq.user.dao;

import java.util.List;

import javax.annotation.Resource;

import com.wbq.user.po.RoleMenuPO;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
  *
  * @author biqin.wu@bianlifeng.com
  * @since 03 九月 2018
  */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder
public class RoleMenuDaoTest {

	@Resource
	private RoleMenuDao roleMenuDao;

	@Test
	public void insertRoleMenu() {
		RoleMenuPO roleMenuPO = new RoleMenuPO();
		roleMenuPO.setRoleId(1);
		roleMenuPO.setMenuId(1);

		roleMenuDao.insertRoleMenu(roleMenuPO);
	}

	@Test
	public void getRoleMenuByRoleId() {
		List<RoleMenuPO> roleMenuPOList = roleMenuDao.getRoleMenuByRoleId(1);
		System.out.println(roleMenuPOList.toString());
	}
}