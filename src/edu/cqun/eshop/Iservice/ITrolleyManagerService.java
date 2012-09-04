package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.Commodity;

public interface ITrolleyManagerService {
	
	/**
	 * �����Ʒ�����ﳵ
	 * @param commodity
	 * @return
	 */
	boolean addCommodity(Long userId, Commodity commodity);
	
	/**
	 * �ӹ��ﳵɾ����Ʒ
	 * @param commodity
	 * @return
	 */
	boolean removeCommodity(Long userId, long commodityId);
	
	/**
	 * �ӹ��ﳵ����ɾ����Ʒ
	 * @param commodityIds
	 * @return
	 */
	boolean removeCommodities(Long userId, List<Long> commodityIds);
	
	/**
	 * �����û�Id�鿴���û��Ĺ��ﳵ
	 * @param userId
	 * @return
	 */
	boolean checkTrolley(Long userId);
	
	/**
	 * ����
	 * @param commodityIds
	 * @return
	 */
	boolean pay(Long userId, List<Long> commodityIds);
	
}
