package edu.cqun.eshop.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.SalesRecord;

/**
 * A data access object (DAO) providing persistence and search support for
 * ImportList entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.domain.ImportList
 * @author MyEclipse Persistence Tools
 */

public class ImportListDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ImportListDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String PRICE = "price";

	protected void initDao() {
		// do nothing
	}

	public void save(ImportList transientInstance) {
		log.debug("saving ImportList instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ImportList persistentInstance) {
		log.debug("deleting ImportList instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ImportList findById(java.lang.Long id) {
		log.debug("getting ImportList instance with id: " + id);
		try {
			ImportList instance = (ImportList) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.ImportList", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ImportList> findByExample(ImportList instance) {
		log.debug("finding ImportList instance by example");
		try {
			List<ImportList> results = (List<ImportList>) getHibernateTemplate()
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
		log.debug("finding ImportList instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ImportList as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ImportList> findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List<ImportList> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findAll() {
		log.debug("finding all ImportList instances");
		try {
			String queryString = "from ImportList";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ImportList merge(ImportList detachedInstance) {
		log.debug("merging ImportList instance");
		try {
			ImportList result = (ImportList) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ImportList instance) {
		log.debug("attaching dirty ImportList instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ImportList instance) {
		log.debug("attaching clean ImportList instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ImportListDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ImportListDAO) ctx.getBean("ImportListDAO");
	}

	public List<ImportList> getOverallImportByPeriod(Timestamp start,
			Timestamp end) {
		org.hibernate.Session session = getSession();
		List<ImportList> record_needed = session
				.createCriteria(ImportList.class)
				.add(Restrictions.between("importDate", start, end)).list();
		return record_needed;
	}

	public List findByForeignProperty(String propertyName, Object value) {
		log.debug("finding Reply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Reply as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findImportListByCommodity(Object commodity) {
		return findByProperty("commodity", commodity);
	}

//	public List<ImportList> getImportListByCommodityId(Long id) {
//		org.hibernate.Session session = null;
//		try {
//			session = getSession();
//			String HQL = "select i.name from Import as s where s.tid ="
//					+ id.toString();
//			Query query = session.createQuery(HQL);
//			return query.list();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// logs.error("查询学生时候出现错误！");
//			return null;
//		} finally {
//			this.releaseSession(session);
//		}
//		// return record_needed;
//	}
}