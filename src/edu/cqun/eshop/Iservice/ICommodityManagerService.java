package edu.cqun.eshop.Iservice;

import java.util.List;
import java.util.Set;

import edu.cqun.eshop.domain.Category;
import edu.cqun.eshop.domain.Commodity;

public interface ICommodityManagerService {
	
	/**
	 * 锟斤拷锟斤拷锟狡�
	 * @param commodity
	 * @return
	 */
	boolean addCommodity(Commodity commodity);
	
	/**
	 * 删锟斤拷锟斤拷品
	 * @param commodity
	 * @return
	 */
	boolean deleteCommodity(long commodityId);
	
	/**
	 * 锟斤拷锟斤拷删锟斤拷锟斤拷品
	 * @param commodity
	 * @return
	 */
	boolean deleteCommoditys(Set<Long> commodityIds);
	
	/**
	 * 锟睫革拷锟斤拷品锟斤拷息
	 * @param commodity
	 * @return
	 */
	boolean modifyCommodity(Commodity commodity);
	
	/**
	 * 锟介看某锟斤拷锟斤拷品锟侥匡拷锟�
	 * @param commodityId
	 * @return 
	 */
	long getCommodityQuantity(long commodityId);
	
	/**
	 * 锟斤拷荼锟角╋拷榭达拷锟狡�
	 * @param categorys
	 * @return
	 */
	Set<Commodity> searchCommodity(Category category);
	
	/**
	 * 取锟矫帮拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟狡�
	 * @return
	 */
	List<Commodity> getCommodityOrderBysales();
	
	/**
	 * 取锟斤拷锟狡硷拷锟斤拷锟斤拷品
	 * @return
	 */
	List<Commodity> getRecommendCommodity();
	
	/**
	 * 取锟斤拷锟截价碉拷锟斤拷品
	 * @return
	 */
	List<Commodity>getSpecialOffercommodity();

	/*
	 * 取锟斤拷锟斤拷锟斤拷锟斤拷品
	 * @return
	 */
	List<Commodity>getAllCommodities();
	List<Category> getCategories();
	List<Commodity> getCommodities(Commodity example) ;

	Commodity getCommodityById(long id);
	
	List<Commodity> getCommoditiesByCommodityName(String name);
}

