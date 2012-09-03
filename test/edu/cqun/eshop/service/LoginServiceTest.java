package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

<<<<<<< HEAD

import edu.cqun.eshop.Iservice.ILoginService;
import edu.cqun.eshop.domain.Buyer;

=======
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Buyer;


>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LoginServiceTest {
	
	@Autowired
<<<<<<< HEAD
	private ILoginService service;

	@Test
	public void testCheckLogin() {
		service.checkLogin(new Buyer());
=======
	IUserManagerService service;
	
	
	@Test
	public void testCheckLogin() {
		Buyer buyer = new Buyer();
		buyer.setName("lzq");
		buyer.setPassword("123456");
		
		//这个函数表示入参是ture的时候出错也就是测试通不过，这个登陆的结果是false，所以正常情况下测试可以通过
		assertFalse(service.checkLogin(buyer));
		return;
>>>>>>> 8c3b95de00c9d4919d17c095832bc7e702567392
	}

}
