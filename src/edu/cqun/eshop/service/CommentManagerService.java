package edu.cqun.eshop.service;

import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ICommentManagerService;
import edu.cqun.eshop.constant.OrderStatus;
import edu.cqun.eshop.dao.CommodityDAO;
import edu.cqun.eshop.dao.OrderListDAO;
import edu.cqun.eshop.domain.OrderList;



@Transactional
@Service("CommentManagerService")
public class CommentManagerService implements ICommentManagerService {

	@Autowired
	private OrderListDAO orderListDAO;
	@Autowired
	private CommodityDAO commodityDAO;

	@Override
	public boolean addComment(OrderList order) {
		try {
			order.setState(OrderStatus.COMMENTED);
			orderListDAO.attachDirty(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<OrderList> checkComment(long commodityId) {
		try {
			Set<OrderList> orderSet = commodityDAO.findById(commodityId)
					.getOrderLists();
			Hibernate.initialize(orderSet);//ǿ�Ƴ�ʼ��
			return orderSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
}
