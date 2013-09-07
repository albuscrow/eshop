package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.dao.CommodityDAO;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OrderList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ImportListManagerServiceTest {
	
	@Autowired
	IImportListManagerService iImportListManagerService;
	
	@Test
	public void test2() {
		Timestamp start = Timestamp.valueOf("2012-09-17 16:21:26");
		Timestamp end = Timestamp.valueOf("2013-09-07 16:50:26");
		List<ImportList> list = iImportListManagerService.getImportListByMessage(null, null, start, end);
		for (ImportList importList : list) {
			System.out.println(importList);
		}
//		fail("Not yet implemented");
	}
}
