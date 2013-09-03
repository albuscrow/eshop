package edu.cqun.eshop.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.StockOut;

/**
 * A data access object (DAO) providing persistence and search support for
 * StockOut entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.dao.StockOut
 * @author MyEclipse Persistence Tools
 */

public class StockOutDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(StockOutDAO.class);
	// property constants
	public static final String NEED_QUANTITY = "needQuantity";

	protected void initDao() {
		// do nothing
	}

	public void save(StockOut transientInstance) {
		log.debug("saving StockOut instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StockOut persistentInstance) {
		log.debug("deleting StockOut instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StockOut findById(java.lang.Long id) {
		log.debug("getting StockOut instance with id: " + id);
		try {
			StockOut instance = (StockOut) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.StockOut", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<StockOut> findByExample(StockOut instance) {
		log.debug("finding StockOut instance by example");
		try {
			List<StockOut> results = (List<StockOut>) getHibernateTemplate()
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
		log.debug("finding StockOut instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StockOut as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<StockOut> findByNeedQuantity(Object needQuantity) {
		return findByProperty(NEED_QUANTITY, needQuantity);
	}

	public List findAll() {
		log.debug("finding all StockOut instances");
		try {
			String queryString = "from StockOut";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StockOut merge(StockOut detachedInstance) {
		log.debug("merging StockOut instance");
		try {
			StockOut result = (StockOut) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StockOut instance) {
		log.debug("attaching dirty StockOut instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StockOut instance) {
		log.debug("attaching clean StockOut instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StockOutDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StockOutDAO) ctx.getBean("StockOutDAO");
	}
}