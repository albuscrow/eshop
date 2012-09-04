package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.ICarriageManagerService;
import edu.cqun.eshop.domain.Carriage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CarriageManagerServiceTest {

	@Autowired
	ICarriageManagerService carriageManagerService;
	
	public Carriage generateCarriage(){
		String start = "上海";
		String destination = "北京";
		String company = "劳动力";
		Short cost = 100;
		return new Carriage(start, destination, company, cost);
	}
	
	@Test
	public void test() {
		Carriage carriage = generateCarriage();
		carriageManagerService.addCarriageRoute(carriage);
	}
	
	@Test
	//Only once
	public void test1() {
		carriageManagerService.deleteCarriageRoute(20130901001l);
	}
	
	@Test
	public void test2() {
		Short cost = 15;
		carriageManagerService.modifyCarriageRoute
		(20130903002l, "啊哈哈", "哇哈哈", "噗哈哈", cost);
	}
	
	@Test
	public void test3() {
		Carriage carriage = 
		carriageManagerService.queryCarriageRouteById(20130903001l);
		System.out.println(carriage);
	}
	
	@Test
	public void test4() {
		List<Carriage> list = carriageManagerService.
				queryCarriageRouteByMessage(null, "广州", null, null);
		for(Carriage carriage:list){
			System.out.println(carriage);
		}
	}

}
