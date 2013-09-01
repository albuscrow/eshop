package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import edu.cqun.eshop.domain.Buyer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LoginServiceTest {
	
	@Autowired
	private LoginService service;

	@Test
	public void testCheckLogin() {
		service.checkLogin(new Buyer());
	}

}
