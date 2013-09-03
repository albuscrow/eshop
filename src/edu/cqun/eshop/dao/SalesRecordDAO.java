package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.SalesRecord;

/**
 * A data access object (DAO) providing persistence and search support for
 * SalesRecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.cqun.eshop.domain.SalesRecord
 * @author MyEclipse Persistence Tools
 */

public class SalesRecordDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SalesRecordDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String AMOUNT = "amount";

	protected void initDao() {
		// do nothing
	}

	public void save(SalesRecord transientInstance) {
		log.debug("saving SalesRecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SalesRecord persistentInstance) {
		log.debug("deleting SalesRecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalesRecord findById(java.lang.Long id) {
		log.debug("getting SalesRecord instance with id: " + id);
		try {
			SalesRecord instance = (SalesRecord) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.SalesRecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SalesRecord> findByExample(SalesRecord instance) {
		log.debug("finding SalesRecord instance by example");
		try {
			List<SalesRecord> results = (List<SalesRecord>) getHibernateTemplate()
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
		log.debug("finding SalesRecord instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SalesRecord as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SalesRecord> findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List<SalesRecord> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all SalesRecord instances");
		try {
			String queryString = "from SalesRecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SalesRecord merge(SalesRecord detachedInstance) {
		log.debug("merging SalesRecord instance");
		try {
			SalesRecord result = (SalesRecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SalesRecord instance) {
		log.debug("attaching dirty SalesRecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalesRecord instance) {
		log.debug("attaching clean SalesRecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalesRecordDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SalesRecordDAO) ctx.getBean("SalesRecordDAO");
	}
}