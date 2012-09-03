package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.domain.OrderList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OrderManagerServiceTest {
	
	@Autowired
	IOrderManagerService service;
	
	@Test
	public void test() {
		
		OrderList ol = new OrderList();
		assertTrue(service.generateOrderList(ol));
//		fail("Not yet implemented");
	}

	@Test
	public void test1() {
		
		OrderList ol = new OrderList();
		Set<OrderList> set = service.findOrderListByUser(201309020001l);
		for(OrderList ol1:set){
			System.out.println(ol1);;
		}
//		fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		Short short1 = 4;
		assertTrue(service.OrderListStatus(20100902000102l, short1));
//		fail("Not yet implemented");
	}
}
