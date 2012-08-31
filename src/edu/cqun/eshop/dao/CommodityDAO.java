package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.Commodity;

/**
 * A data access object (DAO) providing persistence and search support for
 * Commodity entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.dao.Commodity
 * @author MyEclipse Persistence Tools
 */

public class CommodityDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CommodityDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String SALES = "sales";
	public static final String PRICE = "price";
	public static final String DISCOUNT_PRICE = "discountPrice";
	public static final String IS_RECOMMEND = "isRecommend";
	public static final String REST = "rest";
	public static final String PICTURE = "picture";
	public static final String AVERAGE_MARK = "averageMark";
	public static final String INTRODUCTION = "introduction";
	public static final String START = "start";
	public static final String MARKET_PRICE = "marketPrice";

	protected void initDao() {
		// do nothing
	}

	public void save(Commodity transientInstance) {
		log.debug("saving Commodity instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Commodity persistentInstance) {
		log.debug("deleting Commodity instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Commodity findById(java.lang.Long id) {
		log.debug("getting Commodity instance with id: " + id);
		try {
			Commodity instance = (Commodity) getHibernateTemplate().get(
					"edu.cqun.eshop.dao.Commodity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Commodity> findByExample(Commodity instance) {
		log.debug("finding Commodity instance by example");
		try {
			List<Commodity> results = (List<Commodity>) getHibernateTemplate()
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
		log.debug("finding Commodity instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Commodity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Commodity> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Commodity> findBySales(Object sales) {
		return findByProperty(SALES, sales);
	}

	public List<Commodity> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<Commodity> findByDiscountPrice(Object discountPrice) {
		return findByProperty(DISCOUNT_PRICE, discountPrice);
	}

	public List<Commodity> findByIsRecommend(Object isRecommend) {
		return findByProperty(IS_RECOMMEND, isRecommend);
	}

	public List<Commodity> findByRest(Object rest) {
		return findByProperty(REST, rest);
	}

	public List<Commodity> findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List<Commodity> findByAverageMark(Object averageMark) {
		return findByProperty(AVERAGE_MARK, averageMark);
	}

	public List<Commodity> findByIntroduction(Object introduction) {
		return findByProperty(INTRODUCTION, introduction);
	}

	public List<Commodity> findByStart(Object start) {
		return findByProperty(START, start);
	}

	public List<Commodity> findByMarketPrice(Object marketPrice) {
		return findByProperty(MARKET_PRICE, marketPrice);
	}

	public List findAll() {
		log.debug("finding all Commodity instances");
		try {
			String queryString = "from Commodity";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commodity merge(Commodity detachedInstance) {
		log.debug("merging Commodity instance");
		try {
			Commodity result = (Commodity) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commodity instance) {
		log.debug("attaching dirty Commodity instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commodity instance) {
		log.debug("attaching clean Commodity instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CommodityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CommodityDAO) ctx.getBean("CommodityDAO");
	}
}