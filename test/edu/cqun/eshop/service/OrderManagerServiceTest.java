package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Set;

import javax.ws.rs.GET;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.dao.CommodityDAO;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.OrderList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OrderManagerServiceTest {
	
	@Autowired
	IOrderManagerService service;
	private CommodityDAO commodityDAO;
	private BuyerDAO buyerDAO;
	private OrderList oList;
	
	
	
	public void generateOrderList(){
		Commodity commodity = commodityDAO.findById(10401001l);
		Buyer buyer = buyerDAO.findById(201309020001l);
		Short quantity = 4;
		Short payType = 1;
		Short state = 3;
		String logisticsState = "奔走相告中";
		Timestamp registerDate = new Timestamp(System.currentTimeMillis());
		Integer postType = 1;
		Integer postcode = 2;
		String address = "就不告诉你";
		String phone = "122334452";
		Short carriageFee = 998;
		String comment = "挺好";
	 	Short isMatched = 75;
	 	Short logisticsSpeed = 45;
	 	Short attitude = 87;
	 	Timestamp commentDate = new Timestamp(System.currentTimeMillis());
	 	Double total = 59.7;
		oList = new OrderList(commodity, buyer, quantity,
				payType, state, logisticsState,
				registerDate, postType, postcode,
				address, phone, carriageFee, comment,
				isMatched, logisticsSpeed, attitude,
				commentDate, total);
	}
	
	@Test
	public void test() {
		generateOrderList();
		assertTrue(service.generateOrderList(oList));
//		fail("Not yet implemented");
	}

	@Test
	public void test1() {
		
		OrderList ol = new OrderList();
		Set<OrderList> set = service.findOrderListByUser(201309020001l);
		for(OrderList ol1:set){
			System.out.println(ol1);
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
