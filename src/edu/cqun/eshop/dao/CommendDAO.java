package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.Commend;

/**
 * A data access object (DAO) providing persistence and search support for
 * Commend entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.domain.Commend
 * @author MyEclipse Persistence Tools
 */

public class CommendDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CommendDAO.class);
	// property constants
	public static final String COMMEND = "commend";
	public static final String IS_MATCHED = "isMatched";
	public static final String LOGISTICS_SPEED = "logisticsSpeed";
	public static final String ATTITUDE = "attitude";
	public static final String TOTAL = "total";

	protected void initDao() {
		// do nothing
	}

	public void save(Commend transientInstance) {
		log.debug("saving Commend instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Commend persistentInstance) {
		log.debug("deleting Commend instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Commend findById(java.lang.Long id) {
		log.debug("getting Commend instance with id: " + id);
		try {
			Commend instance = (Commend) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.Commend", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Commend> findByExample(Commend instance) {
		log.debug("finding Commend instance by example");
		try {
			List<Commend> results = (List<Commend>) getHibernateTemplate()
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
		log.debug("finding Commend instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Commend as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Commend> findByCommend(Object commend) {
		return findByProperty(COMMEND, commend);
	}

	public List<Commend> findByIsMatched(Object isMatched) {
		return findByProperty(IS_MATCHED, isMatched);
	}

	public List<Commend> findByLogisticsSpeed(Object logisticsSpeed) {
		return findByProperty(LOGISTICS_SPEED, logisticsSpeed);
	}

	public List<Commend> findByAttitude(Object attitude) {
		return findByProperty(ATTITUDE, attitude);
	}

	public List<Commend> findByTotal(Object total) {
		return findByProperty(TOTAL, total);
	}

	public List findAll() {
		log.debug("finding all Commend instances");
		try {
			String queryString = "from Commend";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commend merge(Commend detachedInstance) {
		log.debug("merging Commend instance");
		try {
			Commend result = (Commend) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commend instance) {
		log.debug("attaching dirty Commend instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commend instance) {
		log.debug("attaching clean Commend instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CommendDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CommendDAO) ctx.getBean("CommendDAO");
	}
}