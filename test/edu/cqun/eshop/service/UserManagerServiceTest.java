package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
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
		//Timestamp data = new Timestamp(System.currentTimeMillis());
		Timestamp data = Timestamp.valueOf("2012-09-02 17:12:33");
		Buyer buyer = new Buyer("lc","20105296","20105296",data);
		//这个函数表示入参是true的时候出错也就是测试通不过，这个登陆的结果是false，所以正常情况下测试可以通过
		assertTrue(service.checkLogin(buyer));
		return;
	}

	@Test
	public void testregester() {
		Timestamp data = Timestamp.valueOf("2012-09-02 17:12:34");
		Buyer buyer = new Buyer("lc.new","20105296.new","20105296",data);
		//断定返回"true",否则就报错。
		assertTrue(service.regester(buyer));
		return;
	}

	@Test
	public void testfindUser() {
		Buyer buyer = new Buyer();
		buyer.setSex("女");
		List<Buyer> result= service.findUser(buyer);
		//断定返回结果非空，否则就报错。
		assertNotNull(result);
		return;
	}

	@Test
	public void testmodifypassword() {
		//Buyer buyer = new Buyer() ;
		long id=201309010001l;
		String old_password="20105296";
		String new_password="20105298";
		//断定返回"true",否则就报错。
		assertTrue(service.modifypassword(id,old_password,new_password));
		return;
	}

	@Test
	public void testmodifyUserInfo() {
		//断定返回"true",否则就报错。
		assertTrue(service.modifyUserInfo(201309010001l,"lc.gai","男",null,null,null));
		return;
	}

//	@Test
//	public void testdeleteUser() {
//		long id=3;
//		//断定返回"true",否则就报错。
//		assertTrue(service.deleteUser(id));
//		return;
//	}
//
//	@Test
//	public void testdeleteUsers() {
//		List<Long> buyerIds = new ArrayList<Long>();
//		Long idl=1l;
//		Long idp=2l;
//		buyerIds.add(idl);
//		buyerIds.add(idp);
//		//断定返回"true",否则就报错。
//		assertTrue(service.deleteUsers(buyerIds));
//		return;
//	}

}
