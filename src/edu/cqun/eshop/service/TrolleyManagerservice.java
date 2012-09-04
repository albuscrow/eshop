package edu.cqun.eshop.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ITrolleyManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.dao.OrderListDAO;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.OrderList;

@Transactional
@Service("TrolleyManagerservice")
public class TrolleyManagerservice implements ITrolleyManagerService {
	
	@Autowired
	private OrderListDAO orderDAO;
	@Autowired
	private BuyerDAO buyerDAO;
	
	@Override
	public boolean addCommodity(Long userId, Commodity commodity) {
		try {
			OrderList trolley = new OrderList();
			trolley.setBuyer(buyerDAO.findById(userId));
			trolley.setCommodity(commodity);
			Date now = new Date();
			Timestamp registerDate = new Timestamp(now.getTime());
			trolley.setRegisterDate(registerDate);
			orderDAO.attachDirty(trolley);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeCommodity(Long userId, long commodityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCommodities(Long userId, List<Long> commodityIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkTrolley(Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pay(Long userId, List<Long> commodityIds) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
