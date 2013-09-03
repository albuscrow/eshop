package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.Category;
import edu.cqun.eshop.domain.Commodity;

public interface ICommodityManagerService {
	
	/**
	 * �����Ʒ
	 * @param commodity
	 * @return
	 */
	boolean addCommodity(Commodity commodity);
	
	/**
	 * ɾ����Ʒ
	 * @param commodity
	 * @return
	 */
	boolean deleteCommodity(long commodityId);
	
	/**
	 * ����ɾ����Ʒ
	 * @param commodity
	 * @return
	 */
	boolean deleteCommoditys(List<Long> commodityIds);
	
	/**
	 * �޸���Ʒ��Ϣ
	 * @param commodity
	 * @return
	 */
	boolean modifyCommodity(Commodity commodity);
	
	/**
	 * �鿴ĳ����Ʒ�Ŀ��
	 * @param commodityId
	 * @return 
	 */
	long getCommodityQuantity(long commodityId);
	
	/**
	 * ���ݱ�ǩ�鿴��Ʒ
	 * @param categorys
	 * @return
	 */
	List<Commodity> searchCommodity(List<Category> categorys);
	
	/**
	 * ȡ�ð��������������Ʒ
	 * @return
	 */
	List<Commodity> getCommodityOrderBysales();
	
	/**
	 * ȡ���Ƽ�����Ʒ
	 * @return
	 */
	List<Commodity> getRecommendCommodity();
	
	/**
	 * ȡ���ؼ۵���Ʒ
	 * @return
	 */
	List<Commodity>getSpecialOffercommodity();

}
