package edu.cqun.eshop.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.domain.Category;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.dao.*;

public class CommodityManagerService implements ICommodityManagerService {
	@Autowired
	private CommodityDAO commdityDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public boolean addCommodity(Commodity commodity) {
		commdityDAO.save(commodity);
		return true;
	}

	@Override
	public boolean deleteCommodity(long commodityId) {
		commdityDAO.delete(commdityDAO.findById(commodityId));
		return true;
	}

	@Override
	public boolean deleteCommoditys(Set<Long> commodityIds) {
		
		for (Long commoithyid : commodityIds) {
			commdityDAO.delete(commdityDAO.findById(commoithyid));
		};
		return true;
	}

	@Override
	public boolean modifyCommodity(Commodity commodity) {
		commdityDAO.attachDirty(commodity);
		return true;
	}

	@Override
	public long getCommodityQuantity(long commodityId) {
		long rest=commdityDAO.findById(commodityId).getRest();
		return rest;
	}

	@Override
	public Set<Commodity> searchCommodity(Category category) {
		Set<Commodity> result;
		result=categoryDAO.findById(category.getCategoryId()).getCommodities();
		return result;
	}

	@Override
	public List<Commodity> getCommodityOrderBysales() {
		List<Commodity> result=(List<Commodity>)commdityDAO.findAll();
		Collections.sort(result, new Comparator<Commodity>() {
			@Override
			public int compare(Commodity o1, Commodity o2) {
				return 	o1.getSales().compareTo(o2.getSales());
			}
		});
		return result;
	}

	@Override
	public List<Commodity> getRecommendCommodity() {
		List<Commodity> result;
		result=commdityDAO.findByIsRecommend(true);
		return result;
	}

	@Override
	public List<Commodity> getSpecialOffercommodity() {
		List<Commodity> result;
		result=commdityDAO.findByIsSale(true);
		return result;
	}

}
