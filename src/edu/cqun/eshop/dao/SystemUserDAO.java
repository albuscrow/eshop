package edu.cqun.eshop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.cqun.eshop.domain.SystemUser;

/**
 * A data access object (DAO) providing persistence and search support for
 * SystemUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.cqun.eshop.domain.SystemUser
 * @author MyEclipse Persistence Tools
 */

public class SystemUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SystemUserDAO.class);
	// property constants
	public static final String USER = "user";
	public static final String PASSWORD = "password";
	public static final String ROLE = "role";

	protected void initDao() {
		// do nothing
	}

	public void save(SystemUser transientInstance) {
		log.debug("saving SystemUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SystemUser persistentInstance) {
		log.debug("deleting SystemUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SystemUser findById(java.lang.Long id) {
		log.debug("getting SystemUser instance with id: " + id);
		try {
			SystemUser instance = (SystemUser) getHibernateTemplate().get(
					"edu.cqun.eshop.domain.SystemUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SystemUser> findByExample(SystemUser instance) {
		log.debug("finding SystemUser instance by example");
		try {
			List<SystemUser> results = (List<SystemUser>) getHibernateTemplate()
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
		log.debug("finding SystemUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SystemUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SystemUser> findByUser(Object user) {
		return findByProperty(USER, user);
	}

	public List<SystemUser> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<SystemUser> findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List findAll() {
		log.debug("finding all SystemUser instances");
		try {
			String queryString = "from SystemUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SystemUser merge(SystemUser detachedInstance) {
		log.debug("merging SystemUser instance");
		try {
			SystemUser result = (SystemUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SystemUser instance) {
		log.debug("attaching dirty SystemUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SystemUser instance) {
		log.debug("attaching clean SystemUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SystemUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SystemUserDAO) ctx.getBean("SystemUserDAO");
	}
}