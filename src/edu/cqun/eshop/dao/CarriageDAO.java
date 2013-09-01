package edu.cqun.eshop.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.Carriage;

/**
 * A data access object (DAO) providing persistence and search support for
 * Carriage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.domain.Carriage
 * @author MyEclipse Persistence Tools
 */

public class CarriageDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CarriageDAO.class);
	// property constants
	public static final String START = "start";
	public static final String DESTINATION = "destination";
	public static final String AFFORD_TYPE = "affordType";
	public static final String AMOUNT = "amount";

	protected void initDao() {
		// do nothing
	}

	public void save(Carriage transientInstance) {
		log.debug("saving Carriage instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Carriage persistentInstance) {
		log.debug("deleting Carriage instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Carriage findById(java.lang.Long id) {
		log.debug("getting Carriage instance with id: " + id);
		try {
			Carriage instance = (Carriage) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.Carriage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Carriage> findByExample(Carriage instance) {
		log.debug("finding Carriage instance by example");
		try {
			List<Carriage> results = (List<Carriage>) getHibernateTemplate()
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
		log.debug("finding Carriage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Carriage as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Carriage> findByStart(Object start) {
		return findByProperty(START, start);
	}

	public List<Carriage> findByDestination(Object destination) {
		return findByProperty(DESTINATION, destination);
	}

	public List<Carriage> findByAffordType(Object affordType) {
		return findByProperty(AFFORD_TYPE, affordType);
	}

	public List<Carriage> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all Carriage instances");
		try {
			String queryString = "from Carriage";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Carriage merge(Carriage detachedInstance) {
		log.debug("merging Carriage instance");
		try {
			Carriage result = (Carriage) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Carriage instance) {
		log.debug("attaching dirty Carriage instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Carriage instance) {
		log.debug("attaching clean Carriage instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CarriageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CarriageDAO) ctx.getBean("CarriageDAO");
	}
}