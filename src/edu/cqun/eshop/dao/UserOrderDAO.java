package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.UserOrder;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserOrder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.domain.UserOrder
 * @author MyEclipse Persistence Tools
 */

public class UserOrderDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserOrderDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String PAY_TYPE = "payType";
	public static final String STATE = "state";
	public static final String LOGISTICS_STATE = "logisticsState";
	public static final String POST_TYPE = "postType";

	protected void initDao() {
		// do nothing
	}

	public void save(UserOrder transientInstance) {
		log.debug("saving UserOrder instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserOrder persistentInstance) {
		log.debug("deleting UserOrder instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserOrder findById(java.lang.Long id) {
		log.debug("getting UserOrder instance with id: " + id);
		try {
			UserOrder instance = (UserOrder) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.UserOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<UserOrder> findByExample(UserOrder instance) {
		log.debug("finding UserOrder instance by example");
		try {
			List<UserOrder> results = (List<UserOrder>) getHibernateTemplate()
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
		log.debug("finding UserOrder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserOrder as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<UserOrder> findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List<UserOrder> findByPayType(Object payType) {
		return findByProperty(PAY_TYPE, payType);
	}

	public List<UserOrder> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<UserOrder> findByLogisticsState(Object logisticsState) {
		return findByProperty(LOGISTICS_STATE, logisticsState);
	}

	public List<UserOrder> findByPostType(Object postType) {
		return findByProperty(POST_TYPE, postType);
	}

	public List findAll() {
		log.debug("finding all UserOrder instances");
		try {
			String queryString = "from UserOrder";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserOrder merge(UserOrder detachedInstance) {
		log.debug("merging UserOrder instance");
		try {
			UserOrder result = (UserOrder) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserOrder instance) {
		log.debug("attaching dirty UserOrder instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserOrder instance) {
		log.debug("attaching clean UserOrder instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserOrderDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserOrderDAO) ctx.getBean("UserOrderDAO");
	}
}