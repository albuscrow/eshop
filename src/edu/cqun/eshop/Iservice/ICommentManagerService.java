package edu.cqun.eshop.Iservice;

import edu.cqun.eshop.domain.OrderList;

public interface ICommentManagerService {
	
	/**
	 * �������
	 * @param order
	 * @return
	 */
	boolean addComment(OrderList order);
	
	/**
	 * ������Ʒid�鿴����
	 * @param commodityId
	 * @return
	 */
	boolean checkoutComment(long commodityId);

}
