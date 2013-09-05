package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;

/**
 * A data access object (DAO) providing persistence and search support for
 * OtherPay entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.domain.OtherPay
 * @author MyEclipse Persistence Tools
 */

public class OtherPayDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OtherPayDAO.class);
	// property constants
	public static final String NOTE = "note";

	protected void initDao() {
		// do nothing
	}

	public void save(OtherPay transientInstance) {
		log.debug("saving OtherPay instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OtherPay persistentInstance) {
		log.debug("deleting OtherPay instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OtherPay findById(java.lang.Long id) {
		log.debug("getting OtherPay instance with id: " + id);
		try {
			OtherPay instance = (OtherPay) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.OtherPay", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<OtherPay> findByExample(OtherPay instance) {
		log.debug("finding OtherPay instance by example");
		try {
			List<OtherPay> results = (List<OtherPay>) getHibernateTemplate()
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
		log.debug("finding OtherPay instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OtherPay as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<OtherPay> findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all OtherPay instances");
		try {
			String queryString = "from OtherPay";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OtherPay merge(OtherPay detachedInstance) {
		log.debug("merging OtherPay instance");
		try {
			OtherPay result = (OtherPay) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OtherPay instance) {
		log.debug("attaching dirty OtherPay instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OtherPay instance) {
		log.debug("attaching clean OtherPay instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OtherPayDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OtherPayDAO) ctx.getBean("OtherPayDAO");
	}
	
	public List<OtherPay> getOverallImportByPeriod(Timestamp start, Timestamp end){
		org.hibernate.Session session = getSession();
		List<OtherPay> record_needed = session.createCriteria(OtherPay.class)
				.add(Restrictions.between("oPayDate", start, end))
				.list();
		return record_needed;
	}
}