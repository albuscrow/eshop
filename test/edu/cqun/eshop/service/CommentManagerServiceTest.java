package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.domain.OrderList;
import edu.cqun.eshop.Iservice.*;
import edu.cqun.eshop.dao.*;


@Service("CommentManagerServiceTest")

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CommentManagerServiceTest {
	@Autowired
	private ICommentManagerService commentManagerServiceTest;
	@Autowired
	private OrderListDAO orderListDAO;

	@Test
	public void test() {
//		Session session=null;
//		session= sessionFa.
//		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
//		AnnotationSessionFactoryBean senssionSession = ((org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean)context.getBean("sessionFactory"));
//		Session session = senssionSession
		
		OrderList orderTest=new OrderList();
//		orderTest=orderListDAO.findById(20130903000103l);
		
		orderTest.setOrderId(20130903000103l);
		orderTest.setComment("what??");
		//orderTest.setCommentDate(new Timestamp(2010, 9, 9, 9, 9, 9, 9));
		
		commentManagerServiceTest.addComment(orderTest);
		
		
		Set<OrderList> orderSet=null;
		orderSet=commentManagerServiceTest.checkComment(10401001);
		for (OrderList order : orderSet) {
			System.out.println(order.getComment());
		}
	}

}
