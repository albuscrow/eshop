package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.OrderList;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderList entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.dao.OrderList
 * @author MyEclipse Persistence Tools
 */

public class OrderListDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OrderListDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String PAY_TYPE = "payType";
	public static final String STATE = "state";
	public static final String LOGISTICS_STATE = "logisticsState";
	public static final String POST_TYPE = "postType";
	public static final String POSTCODE = "postcode";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String CARRIAGE_FEE = "carriageFee";

	protected void initDao() {
		// do nothing
	}

	public void save(OrderList transientInstance) {
		log.debug("saving OrderList instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderList persistentInstance) {
		log.debug("deleting OrderList instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderList findById(java.lang.Long id) {
		log.debug("getting OrderList instance with id: " + id);
		try {
			OrderList instance = (OrderList) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.OrderList", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<OrderList> findByExample(OrderList instance) {
		log.debug("finding OrderList instance by example");
		try {
			List<OrderList> results = (List<OrderList>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding OrderList instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderList as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<OrderList> findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List<OrderList> findByPayType(Object payType) {
		return findByProperty(PAY_TYPE, payType);
	}

	public List<OrderList> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<OrderList> findByLogisticsState(Object logisticsState) {
		return findByProperty(LOGISTICS_STATE, logisticsState);
	}

	public List<OrderList> findByPostType(Object postType) {
		return findByProperty(POST_TYPE, postType);
	}

	public List<OrderList> findByPostcode(Object postcode) {
		return findByProperty(POSTCODE, postcode);
	}

	public List<OrderList> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<OrderList> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<OrderList> findByCarriageFee(Object carriageFee) {
		return findByProperty(CARRIAGE_FEE, carriageFee);
	}

	public List findAll() {
		log.debug("finding all OrderList instances");
		try {
			String queryString = "from OrderList";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrderList merge(OrderList detachedInstance) {
		log.debug("merging OrderList instance");
		try {
			OrderList result = (OrderList) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderList instance) {
		log.debug("attaching dirty OrderList instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderList instance) {
		log.debug("attaching clean OrderList instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderListDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrderListDAO) ctx.getBean("OrderListDAO");
	}
}