package edu.cqun.eshop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.ShopCar;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShopCar entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.dao.ShopCar
 * @author MyEclipse Persistence Tools
 */

public class ShopCarDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ShopCarDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(ShopCar transientInstance) {
		log.debug("saving ShopCar instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ShopCar persistentInstance) {
		log.debug("deleting ShopCar instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopCar findById(edu.cqun.eshop.domain.ShopCarId id) {
		log.debug("getting ShopCar instance with id: " + id);
		try {
			ShopCar instance = (ShopCar) getHibernateTemplate().get(
					"edu.cqun.eshop.dao.ShopCar", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ShopCar> findByExample(ShopCar instance) {
		log.debug("finding ShopCar instance by example");
		try {
			List<ShopCar> results = (List<ShopCar>) getHibernateTemplate()
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
		log.debug("finding ShopCar instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ShopCar as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all ShopCar instances");
		try {
			String queryString = "from ShopCar";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ShopCar merge(ShopCar detachedInstance) {
		log.debug("merging ShopCar instance");
		try {
			ShopCar result = (ShopCar) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopCar instance) {
		log.debug("attaching dirty ShopCar instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopCar instance) {
		log.debug("attaching clean ShopCar instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShopCarDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ShopCarDAO) ctx.getBean("ShopCarDAO");
	}
}