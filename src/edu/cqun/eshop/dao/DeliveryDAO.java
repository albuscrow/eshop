package edu.cqun.eshop.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.Delivery;

/**
 * A data access object (DAO) providing persistence and search support for
 * Delivery entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.dao.Delivery
 * @author MyEclipse Persistence Tools
 */

public class DeliveryDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(DeliveryDAO.class);
	// property constants
	public static final String POSTCODE = "postcode";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";

	protected void initDao() {
		// do nothing
	}

	public void save(Delivery transientInstance) {
		log.debug("saving Delivery instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Delivery persistentInstance) {
		log.debug("deleting Delivery instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Delivery findById(java.lang.Long id) {
		log.debug("getting Delivery instance with id: " + id);
		try {
			Delivery instance = (Delivery) getHibernateTemplate().get(
					"edu.cqun.eshop.dao.Delivery", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Delivery> findByExample(Delivery instance) {
		log.debug("finding Delivery instance by example");
		try {
			List<Delivery> results = (List<Delivery>) getHibernateTemplate()
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
		log.debug("finding Delivery instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Delivery as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Delivery> findByPostcode(Object postcode) {
		return findByProperty(POSTCODE, postcode);
	}

	public List<Delivery> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Delivery> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findAll() {
		log.debug("finding all Delivery instances");
		try {
			String queryString = "from Delivery";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Delivery merge(Delivery detachedInstance) {
		log.debug("merging Delivery instance");
		try {
			Delivery result = (Delivery) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Delivery instance) {
		log.debug("attaching dirty Delivery instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Delivery instance) {
		log.debug("attaching clean Delivery instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DeliveryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DeliveryDAO) ctx.getBean("DeliveryDAO");
	}
}