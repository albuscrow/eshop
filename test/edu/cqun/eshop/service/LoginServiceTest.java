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
		
		//���������ʾ�����ture��ʱ�����Ҳ���ǲ���ͨ�����������½�Ľ����false��������������²��Կ���ͨ��
		assertFalse(service.checkLogin(buyer));
		return;
	}

}
