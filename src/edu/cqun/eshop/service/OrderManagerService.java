package edu.cqun.eshop.service;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.dao.OrderListDAO;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.OrderList;

@Transactional
@Service("orderManagerService")
public class OrderManagerService implements IOrderManagerService {

	@Autowired
	private OrderListDAO orderListDAO;
	private BuyerDAO buyerDAO;
	
	@Override
	public boolean generateOrderList(OrderList orderList) {
		// TODO Auto-generated method stub
		orderListDAO.save(orderList);
		return true;
	}

	@Override
	public Set<OrderList> findOrderListByUser(long buyerId) {
		// TODO Auto-generated method stub
		Buyer buyer = buyerDAO.findById(buyerId);
		return buyer.getOrderLists();
	}

	@Override
	public boolean OrderListStatus(long orderId, short OrderStatus) {
		// TODO Auto-generated method stub
		OrderList ol = orderListDAO.findById(orderId);
		ol.setState(OrderStatus);
		orderListDAO.attachDirty(ol);
		return true;
	}

}
