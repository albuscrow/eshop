package edu.cqun.eshop.service.UserManagerServicetest;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.domain.Buyer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class regesterTest {
	
	@Autowired
	IUserManagerService service;
	
	@Test
	public void testregester() {
		Buyer buyer = new Buyer() ;
		buyer.setBuyerId((long) 4);
		buyer.setName("d");
		buyer.setSex("ÄÐ");
		buyer.setPassword("123");
		buyer.setUser("d");
		buyer.setEmail("245454@qq.com");
		Timestamp data = new Timestamp(System.currentTimeMillis());
		buyer.setRegisterDate(data);
		assertFalse(service.regester(buyer));
		return;
	}
}
