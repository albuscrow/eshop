package edu.cqun.eshop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.domain.Commodity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CommodityManagerServiceTest {
	@Autowired
	private ICommodityManagerService testService;
	
	@Test
	public void test() {
		Commodity testCommodity =new Commodity();
		testService.addCommodity(testCommodity);
		testService.deleteCommodity(testCommodity.getCommodityId());
	}

}
