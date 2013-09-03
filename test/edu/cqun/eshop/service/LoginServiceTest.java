package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Buyer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LoginServiceTest {
	
	@Autowired
	IUserManagerService service;
	
	
	@Test
	public void testCheckLogin() {
		Buyer buyer = new Buyer();
		buyer.setName("lzq");
		buyer.setPassword("123456");
		
		//这个函数表示入参是ture的时候出错也就是测试通不过，这个登陆的结果是false，所以正常情况下测试可以通过
		assertFalse(service.checkLogin(buyer));
		return;
	}

}
