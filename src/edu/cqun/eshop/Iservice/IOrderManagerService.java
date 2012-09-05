package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;
import java.util.Set;

import edu.cqun.eshop.domain.OrderList;

public interface IOrderManagerService {
	
	/**
	 * 生成订单
	 * @param orderList
	 * @return
	 */
	boolean generateOrderList(OrderList orderList);
	
	/**
	 * 根据用户id查询该用户的订单
	 * @param buyerId
	 * @return
	 */
	Set<OrderList> findOrderListByUser(long buyerId);
	
	/**
	 * 修改订单状态
	 * @param orderId
	 * @param OrderStatus
	 * @return
	 */
	boolean OrderListStatus(long orderId, short status);
	
	boolean OrderListHasPaid(long orderId, Short quantity,Short payType,Short state,String logisticsState,
	Timestamp registerDate,Integer postType,Integer postcode,String address,String phone,
	Short carriageFee);

}
