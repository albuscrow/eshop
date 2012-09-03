package edu.cqun.eshop.service;

import java.util.List;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.domain.Category;
import edu.cqun.eshop.domain.Commodity;

public class CommodityManagerService implements ICommodityManagerService {

	@Override
	public boolean addCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCommodity(long commodityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCommoditys(List<Long> commodityIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getCommodityQuantity(long commodityId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Commodity> searchCommodity(List<Category> categorys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commodity> getCommodityOrderBysales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commodity> getRecommendCommodity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commodity> getSpecialOffercommodity() {
		// TODO Auto-generated method stub
		return null;
	}

}
