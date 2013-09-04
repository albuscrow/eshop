package edu.cqun.eshop.service;

import java.util.List;

import edu.cqun.eshop.Iservice.ICarriageManagerService;
import edu.cqun.eshop.domain.Commodity;

public class CarriageManagerservice implements ICarriageManagerService {

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
	public boolean checkCarriage(Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pay(Long userId, List<Long> commodityIds) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
