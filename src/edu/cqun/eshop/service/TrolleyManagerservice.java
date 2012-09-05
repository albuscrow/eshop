package edu.cqun.eshop.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ITrolleyManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.dao.CommodityDAO;
import edu.cqun.eshop.dao.OrderListDAO;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.OrderList;
import edu.cqun.eshop.constant.OrderStatus;

@Transactional
@Service("TrolleyManagerservice")
public class TrolleyManagerservice implements ITrolleyManagerService {
	
	@Autowired
	private OrderListDAO orderDAO;
	@Autowired
	private BuyerDAO buyerDAO;
	@Autowired
	private CommodityDAO commodityDAO;

	@Override
	public boolean addCommodity(Long userId, Commodity commodity) {
		try {
			OrderList trolleyItem = new OrderList();
			trolleyItem.setBuyer(buyerDAO.findById(userId));
			trolleyItem.setCommodity(commodity);
			trolleyItem.setState(OrderStatus.TROLLEY);
			Date now = new Date();
			Timestamp registerDate = new Timestamp(now.getTime());
			trolleyItem.setRegisterDate(registerDate);
			orderDAO.attachDirty(trolleyItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeCommodity(Long userId, long commodityId) {
		try {
			Set<OrderList> resultSet=checkTrolley(userId);
			for (OrderList orderList : resultSet) {
				if (orderList.getCommodity().getCommodityId().equals(commodityId)) {
					orderDAO.delete(orderList);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeCommodities(Long userId, List<Long> commodityIds) {
		try {
			for (Long commodityId : commodityIds) {
				removeCommodity(userId, commodityId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<OrderList> checkTrolley(Long userId) {
		Set<OrderList> ordersLists = buyerDAO.findById(userId).getOrderLists();
		Set<OrderList> resultSet = new HashSet<OrderList>();
		for (OrderList orderList : ordersLists) {
			if (orderList.getState() == OrderStatus.TROLLEY) {
				resultSet.add(orderList);
			}
		}
		//Hibernate.initialize(resultSet);
		return resultSet;
	}

	@Override
	public boolean pay(Long userId, List<Long> commodityIds) {
		try {
			Set<OrderList> trolleyList=checkTrolley(userId);
			for (OrderList orderList : trolleyList) {
				for (long commodityID : commodityIds) {
					if (orderList.getCommodity().getCommodityId().equals(commodityID)) {
						orderList.setState(OrderStatus.NON_PAY);
						orderDAO.attachDirty(orderList);
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Commodity getOneInstance(long commID) {	
		Commodity result;
		result=commodityDAO.findById(commID);
		Hibernate.initialize(result);
		return 	result;
	}
	
}
