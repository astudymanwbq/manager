package com.wbq.user.dao;

import java.util.List;

import javax.annotation.Resource;

import com.wbq.user.po.RolePO;
import org.junit.Assert;
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
public class RoleDaoTest {

	@Resource
	private RoleDao roleDao;

	@Test
	public void insertRole() {
		RolePO rolePO = new RolePO();
		rolePO.setName("管理员");
		rolePO.setDescription("管理员角色");
		int count = roleDao.insertRole(rolePO);
		Assert.assertEquals(1, count);
	}

	@Test
	public void getAllRoles() {
		List<RolePO> rolePOList=roleDao.getAllRoles();
		Assert.assertEquals(2,rolePOList.size());
	}
}