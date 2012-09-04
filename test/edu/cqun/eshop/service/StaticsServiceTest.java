package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.IStatisticsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StaticsServiceTest {

	@Autowired
	IStatisticsService statisticsService;
	
//	@Test
//	public void test() {
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		int mouthnum = timestamp.getMonth()+1;
//		int daynum = timestamp.getDate();
//		String mouthString = mouthnum + "";
//		String mouthString1 = "0" + mouthString;
//		System.out.println(mouthString);
//		System.out.println(mouthString1);
//		System.out.println(timestamp);
//		System.out.println(timestamp.getYear()+1900);
//		System.out.println(timestamp.getDate());
//		System.out.println(timestamp.getMonth()+1);
//		System.out.println(timestamp.getDay());
//	}
	
	@Test
	public void test1() {
		double d = statisticsService.getDailyProfit(Timestamp.valueOf("2012-09-03 17:11:25"));
		System.out.println(d);
	}
	
	@Test
	public void test2() {
//		statisticsService.get
	}
}
