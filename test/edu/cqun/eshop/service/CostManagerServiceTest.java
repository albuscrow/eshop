package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.ICostManagerService;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class CostManagerServiceTest {
	@Autowired
	private ICostManagerService costServiceTest;
	
	@Test
	public void test() {
//		ImportList importList=new ImportList();
//		Date now = new Date(); 
//		Timestamp importDate=new Timestamp(now.getTime());		
//		System.out.println(importDate);
//		
//		importList.setImportDate(importDate);
//		importList.setPrice(9d);
//		importList.setQuantity((short) 99);
//		
//		costServiceTest.addImportList(importList);//addImportList Test
		
		OtherPay otherPay = new OtherPay();
		otherPay.setNote("kick ass");
		Date now = new Date(); 
		Timestamp otherpayDate=new Timestamp(now.getTime());	
		otherPay.setOpayDate(otherpayDate);
		
		costServiceTest.addOtherCost(otherPay);
	}

}
