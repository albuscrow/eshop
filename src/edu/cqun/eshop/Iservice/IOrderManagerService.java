package edu.cqun.eshop.Iservice;

import edu.cqun.eshop.domain.OrderList;

public interface IOrderManagerService {
	
	/**
	 * ���ɶ���
	 * @param orderList
	 * @return
	 */
	boolean generateOrderList(OrderList orderList);
	
	/**
	 * �����û�id��ѯ���û��Ķ���
	 * @param buyerId
	 * @return
	 */
	boolean findOrderListByUser(long buyerId);
	
	/**
	 * �޸Ķ���״̬
	 * @param orderId
	 * @param OrderStatus
	 * @return
	 */
	boolean OrderListStatus(long orderId, short OrderStatus);

}
