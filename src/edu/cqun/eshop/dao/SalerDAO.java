package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.Saler;

/**
 * A data access object (DAO) providing persistence and search support for Saler
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see edu.cqun.eshop.domain.Saler
 * @author MyEclipse Persistence Tools
 */

public class SalerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SalerDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String AVERAGE_MARK = "averageMark";
	public static final String USER = "user";
	public static final String PASSWORD = "password";
	public static final String INTRODUCTION = "introduction";

	protected void initDao() {
		// do nothing
	}

	public void save(Saler transientInstance) {
		log.debug("saving Saler instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Saler persistentInstance) {
		log.debug("deleting Saler instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Saler findById(java.lang.Long id) {
		log.debug("getting Saler instance with id: " + id);
		try {
			Saler instance = (Saler) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.Saler", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Saler> findByExample(Saler instance) {
		log.debug("finding Saler instance by example");
		try {
			List<Saler> results = (List<Saler>) getHibernateTemplate()
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
		log.debug("finding Saler instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Saler as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Saler> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Saler> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Saler> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Saler> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Saler> findByAverageMark(Object averageMark) {
		return findByProperty(AVERAGE_MARK, averageMark);
	}

	public List<Saler> findByUser(Object user) {
		return findByProperty(USER, user);
	}

	public List<Saler> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Saler> findByIntroduction(Object introduction) {
		return findByProperty(INTRODUCTION, introduction);
	}

	public List findAll() {
		log.debug("finding all Saler instances");
		try {
			String queryString = "from Saler";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Saler merge(Saler detachedInstance) {
		log.debug("merging Saler instance");
		try {
			Saler result = (Saler) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Saler instance) {
		log.debug("attaching dirty Saler instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Saler instance) {
		log.debug("attaching clean Saler instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalerDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SalerDAO) ctx.getBean("SalerDAO");
	}
}