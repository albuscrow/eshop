package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;
import java.util.Set;

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
	Set<OrderList> findOrderListByUser(long buyerId);
	
	/**
	 * �޸Ķ���״̬
	 * @param orderId
	 * @param OrderStatus
	 * @return
	 */
	boolean OrderListStatus(long orderId, short status);
	
	boolean OrderListHasPaid(long orderId, Short quantity,Short payType,Short state,String logisticsState,
	Timestamp registerDate,Integer postType,Integer postcode,String address,String phone,
	Short carriageFee);

}
