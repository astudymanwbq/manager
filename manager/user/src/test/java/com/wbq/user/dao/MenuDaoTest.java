package com.wbq.user.dao;

import java.util.List;

import javax.annotation.Resource;

import com.wbq.user.po.MenuPO;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
  *
  * @author biqin.wu
  * @since 02 九月 2018
  */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuDaoTest {

	@Resource
	private MenuDao menuDao;

	@Test
	public void insertMenu() {
		MenuPO menuPO = new MenuPO();
		menuPO.setName("一级菜单");
		menuPO.setUrl("/manage");
		menuPO.setParentId(0);
		menuPO.setType("用户管理");

		menuDao.insertMenu(menuPO);
	}

	@Test
	public void getAllMenu() {
		List<MenuPO> menuPOList=menuDao.getAllMenu();
		System.out.println(menuPOList.toString());
	}
}