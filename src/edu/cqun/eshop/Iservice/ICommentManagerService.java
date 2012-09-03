package edu.cqun.eshop.Iservice;

import java.util.Set;

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
	Set<OrderList> checkComment(long commodityId);

}
