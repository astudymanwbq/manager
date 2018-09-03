package com.wbq.user.dao;

import javax.annotation.Resource;

import com.wbq.user.po.UserPO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
  *
  * @author biqin.wu
  * @since 02 九月 2018
  */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Resource
	private UserDao userDao;

	@Test
	public void insertUser() {
		//UserPO userPO =UserPO.builder().name("吴璧钦").account("120525").password("123456").phone("13123423432").email("1282656881@qq.com").build();
		//int count = userDao.insertUser(userPO);
		//Assert.assertEquals(1, count);
	}

	@Test
	public void getUserByAccount() {
		String account="120525";
		UserPO userPO=userDao.getUserByAccount(account);
		Assert.assertEquals("吴璧钦",userPO.getName());
	}

	@Test
	public void getUserByAccountAndName() {
	}

	@Test
	public void updateUserByAccount() {
	}
}