package edu.cqun.eshop.Iservice;

import java.util.List;
import java.util.Set;

import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.OrderList;

public interface ITrolleyManagerService {
	
	/**
	 * 添加商品到购物车
	 * @param commodity
	 * @return
	 */
	boolean addCommodity(Long userId, Commodity commodity);
	
	/**
	 * 从购物车删除商品
	 * @param commodity
	 * @return
	 */
	boolean removeCommodity(Long userId, long commodityId);
	
	/**
	 * 从购物车批量删除商品
	 * @param commodityIds
	 * @return
	 */
	boolean removeCommodities(Long userId, List<Long> commodityIds);
	
	/**
	 * 根据用户Id查看该用户的购物车
	 * @param userId
	 * @return
	 */
	Set<OrderList> checkTrolley(Long userId);
	
	/**
	 * 付款
	 * @param commodityIds
	 * @return
	 */
	boolean pay(Long userId, List<Long> commodityIds);
	
	 Commodity getOneInstance(long commID) ;		

	
}
