package edu.cqun.eshop.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cqun.eshop.Iservice.ICommentManagerService;
import edu.cqun.eshop.domain.OrderList;
import edu.cqun.eshop.dao.*;

public class CommentManagerService implements ICommentManagerService {

	@Autowired
	private OrderListDAO orderListDAO;
	@Autowired
	private CommodityDAO commodityDAO;

	@Override
	public boolean addComment(OrderList order) {
		try {
			orderListDAO.findById(order.getOrderId()).setComment(
					order.getComment());
			orderListDAO.findById(order.getOrderId()).setCommentDate(
					order.getCommentDate());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<OrderList> checkComment(long commodityId) {
		try {
			Set<OrderList> ordersetSet = commodityDAO.findById(commodityId)
					.getOrderLists();
			return ordersetSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
}
