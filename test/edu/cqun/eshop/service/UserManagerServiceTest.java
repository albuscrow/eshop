package edu.cqun.eshop.service;

import static org.junit.Assert.*;

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
public class UserManagerServiceTest {
	
	@Autowired
	IUserManagerService service;
	
	
	@Test
	public void testCheckLogin() {
		Buyer buyer = new Buyer();
		buyer.setUser("a");
		buyer.setPassword("123");
		//这个函数表示入参是ture的时候出错也就是测试通不过，这个登陆的结果是false，所以正常情况下测试可以通过
		assertFalse(service.checkLogin(buyer));
		return;
	}
	
	@Test
	public void testregester() {
		Buyer buyer = new Buyer() ;
		buyer.setBuyerId((long) 4);
		buyer.setName("d");
		buyer.setPassword("123");
		buyer.setUser("d");
		assertFalse(service.regester(buyer));
		return;
	}
	
	@Test
	public void testfindUser() {
		Buyer buyer = new Buyer() ;
		buyer.setName("b");
		buyer.setUser("b");
		buyer.setPassword("123");
		//assertFalse(service.findUser(buyer));
		assertEquals(buyer, service.findUser(buyer));
		return;
	}
	
	@Test
	public void testmodifypassword() {
		Buyer buyer = new Buyer() ;
		long id= 1;
		String old_password="123";
		String new_password="234";
		service.modifypassword(id, old_password, new_password);
		BuyerDAO buyerDAO = null;
		buyer = buyerDAO.findById(id);
		assertEquals(new_password, buyer.getPassword());
		//assertFalse(service.regester(buyer));
		return;
	}
	
	@Test
	public void testmodifyUserInfo() {
		Buyer buyer = new Buyer() ;
		buyer.setBuyerId((long) 1);
		buyer.setName("a.xiugai");
		assertFalse(service.modifyUserInfo(buyer));
		return;
	}
	
	@Test
	public void testdeleteUser() {
		long id=2;
		assertFalse(service.deleteUser(id));
		return;
	}
	
	@Test
	public void testdeleteUsers() {
		List<Long> buyerIds = null;
		long id1=3;
		long id2=5;
		buyerIds.add(id1);
		buyerIds.add(id2);
		assertFalse(service.deleteUsers(buyerIds));
		return;
	}
	
	
	
}
