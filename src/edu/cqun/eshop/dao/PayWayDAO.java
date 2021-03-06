package edu.cqun.eshop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.PayWay;

/**
 * A data access object (DAO) providing persistence and search support for
 * PayWay entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.domain.PayWay
 * @author MyEclipse Persistence Tools
 */

public class PayWayDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PayWayDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String COMPANY = "company";
	public static final String URL = "url";

	protected void initDao() {
		// do nothing
	}

	public void save(PayWay transientInstance) {
		log.debug("saving PayWay instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PayWay persistentInstance) {
		log.debug("deleting PayWay instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PayWay findById(java.lang.Long id) {
		log.debug("getting PayWay instance with id: " + id);
		try {
			PayWay instance = (PayWay) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.PayWay", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PayWay> findByExample(PayWay instance) {
		log.debug("finding PayWay instance by example");
		try {
			List<PayWay> results = (List<PayWay>) getHibernateTemplate()
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
		log.debug("finding PayWay instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PayWay as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PayWay> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<PayWay> findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List<PayWay> findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findAll() {
		log.debug("finding all PayWay instances");
		try {
			String queryString = "from PayWay";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PayWay merge(PayWay detachedInstance) {
		log.debug("merging PayWay instance");
		try {
			PayWay result = (PayWay) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PayWay instance) {
		log.debug("attaching dirty PayWay instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PayWay instance) {
		log.debug("attaching clean PayWay instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PayWayDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PayWayDAO) ctx.getBean("PayWayDAO");
	}
}