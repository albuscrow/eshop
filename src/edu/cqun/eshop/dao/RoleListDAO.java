package edu.cqun.eshop.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.RoleList;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoleList entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.dao.RoleList
 * @author MyEclipse Persistence Tools
 */

public class RoleListDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RoleListDAO.class);
	// property constants
	public static final String ROLE = "role";
	public static final String AUTHORITY = "authority";

	protected void initDao() {
		// do nothing
	}

	public void save(RoleList transientInstance) {
		log.debug("saving RoleList instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleList persistentInstance) {
		log.debug("deleting RoleList instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleList findById(java.lang.Long id) {
		log.debug("getting RoleList instance with id: " + id);
		try {
			RoleList instance = (RoleList) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.RoleList", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<RoleList> findByExample(RoleList instance) {
		log.debug("finding RoleList instance by example");
		try {
			List<RoleList> results = (List<RoleList>) getHibernateTemplate()
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
		log.debug("finding RoleList instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RoleList as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<RoleList> findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List<RoleList> findByAuthority(Object authority) {
		return findByProperty(AUTHORITY, authority);
	}

	public List findAll() {
		log.debug("finding all RoleList instances");
		try {
			String queryString = "from RoleList";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleList merge(RoleList detachedInstance) {
		log.debug("merging RoleList instance");
		try {
			RoleList result = (RoleList) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleList instance) {
		log.debug("attaching dirty RoleList instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleList instance) {
		log.debug("attaching clean RoleList instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleListDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RoleListDAO) ctx.getBean("RoleListDAO");
	}
}