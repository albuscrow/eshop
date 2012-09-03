package edu.cqun.eshop.service;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.dao.CommodityDAO;
import edu.cqun.eshop.domain.Commodity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CommodityManagerServiceTest {
	@Autowired
	private ICommodityManagerService testService;
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Commodity testCommodity =new Commodity();
	//	testCommodity.setCommodityId((long) 3);
		testCommodity.setPrice((double) 10);
		testCommodity.setName("aaa");
		testCommodity.setIsRecommend(false);
		testCommodity.setPicture("11424115");
		Timestamp timestamp=new Timestamp(2013,9,13,4,5,5, 0);
		testCommodity.setRegisterDate(timestamp);
		testCommodity.setBrand("aaf");
		testService.addCommodity(testCommodity);
		//testService.deleteCommodity(testCommodity.getCommodityId());
	}

}