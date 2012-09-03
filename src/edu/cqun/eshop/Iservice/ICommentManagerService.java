package edu.cqun.eshop.Iservice;

import edu.cqun.eshop.domain.OrderList;

public interface ICommentManagerService {
	
	/**
	 * 添加评论
	 * @param order
	 * @return
	 */
	boolean addComment(OrderList order);
	
	/**
	 * 根据商品id查看评论
	 * @param commodityId
	 * @return
	 */
	boolean checkoutComment(long commodityId);

}
