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
		String start = "�Ϻ�";
		String destination = "����";
		String company = "�Ͷ���";
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
		(20130903002l, "������", "�۹���", "�۹���", cost);
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
				queryCarriageRouteByMessage(null, "����", null, null);
		for(Carriage carriage:list){
			System.out.println(carriage);
		}
	}

}
