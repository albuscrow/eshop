package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.ITrolleyManagerService;
import edu.cqun.eshop.domain.Commodity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class TrolleyManagerserviceTest {
	@Autowired
	private ITrolleyManagerService trolleyTest;
	
	@Test
	public void test() {
		
		Long testid=201309010001l;
//		Commodity commodity;
//		commodity=trolleyTest.getOneInstance(10402001l);
//		trolleyTest.addCommodity(testid, commodity);
		
//		trolleyTest.removeCommodity(testid, 10402001l);

		List<Long> commodityIds=new ArrayList<Long>();
		commodityIds.add(10402001l);
		commodityIds.add(10401001l);
		trolleyTest.pay(testid, commodityIds);
	}

}
