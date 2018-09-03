package com.wbq.user.dao;

import javax.annotation.Resource;

import com.wbq.user.po.UserRolePO;
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
public class UserRoleDaoTest {

	@Resource
	private UserRoleDao userRoleDao;

	@Test
	public void insertUserRole() {
		UserRolePO userRolePO=new UserRolePO();
		userRolePO.setUserId(1);
		userRolePO.setRoleId(1);
		userRoleDao.insertUserRole(userRolePO);

	}

	@Test
	public void getUserRoleByUserId() {
		UserRolePO userRolePO=userRoleDao.getUserRoleByUserId(1);
		System.out.println(userRolePO.toString());
	}
}