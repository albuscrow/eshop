package edu.cqun.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ICommodityService;
import edu.cqun.eshop.dao.CommodityDAO;
import edu.cqun.eshop.domain.Commodity;

@Transactional
@Service("commodityService")
public class CommodityServiceImpl implements ICommodityService {
	@Autowired
	private CommodityDAO commodityDAO;
	
	@Override
	public boolean addCommodity(Commodity c) {
		// TODO Auto-generated method stub
		commodityDAO.save(c);
		return true;
	}

	@Override
	public boolean deleteCommodity(Commodity c) {
		// TODO Auto-generated method stub
		commodityDAO.delete(c);
		return true;
	}

	@Override
	public boolean modifyCommodity(Commodity origin, Commodity update) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean queryCommodityByExample(Commodity c) {
		// TODO Auto-generated method stub
		commodityDAO.findByExample(c);
		return false;
	}



}
