package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.Buyer;

/**
 * A data access object (DAO) providing persistence and search support for Buyer
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see edu.cqun.eshop.dao.Buyer
 * @author MyEclipse Persistence Tools
 */

public class BuyerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BuyerDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String USER = "user";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";

	protected void initDao() {
		// do nothing
	}

	public void save(Buyer transientInstance) {
		log.debug("saving Buyer instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Buyer persistentInstance) {
		log.debug("deleting Buyer instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Buyer findById(java.lang.Long id) {
		log.debug("getting Buyer instance with id: " + id);
		try {
			Buyer instance = (Buyer) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.Buyer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Buyer> findByExample(Buyer instance) {
		log.debug("finding Buyer instance by example");
		try {
			List<Buyer> results = (List<Buyer>) getHibernateTemplate()
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
		log.debug("finding Buyer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Buyer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Buyer> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Buyer> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<Buyer> findByUser(Object user) {
		return findByProperty(USER, user);
	}

	public List<Buyer> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Buyer> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findAll() {
		log.debug("finding all Buyer instances");
		try {
			String queryString = "from Buyer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Buyer merge(Buyer detachedInstance) {
		log.debug("merging Buyer instance");
		try {
			Buyer result = (Buyer) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Buyer instance) {
		log.debug("attaching dirty Buyer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Buyer instance) {
		log.debug("attaching clean Buyer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BuyerDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BuyerDAO) ctx.getBean("BuyerDAO");
	}
}