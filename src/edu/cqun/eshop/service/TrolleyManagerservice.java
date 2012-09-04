package edu.cqun.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ITrolleyManagerService;
import edu.cqun.eshop.dao.CarriageDAO;
import edu.cqun.eshop.domain.Carriage;
import edu.cqun.eshop.domain.Commodity;

@Transactional
@Service("TrolleyManagerservice")
public class TrolleyManagerservice implements ITrolleyManagerService {

	@Override
	public boolean addCommodity(Long userId, Commodity commodity) {
		// TODO Auto-generated method stub
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
