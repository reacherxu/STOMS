package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.PforNew;

/**
 * A data access object (DAO) providing persistence and search support for
 * PforNew entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.stoms.model.PforNew
 * @author MyEclipse Persistence Tools
 */

public class PforNewDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PforNewDAO.class);
	// property constants
	public static final String ITEM_ID = "itemId";
	public static final String PTRAVEL_COST = "ptravelCost";
	public static final String PEXCHANGE = "pexchange";
	public static final String PEQUIPMENT = "pequipment";
	public static final String PCONFERENCE = "pconference";

	protected void initDao() {
		// do nothing
	}

	public void save(PforNew transientInstance) {
		log.debug("saving PforNew instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PforNew persistentInstance) {
		log.debug("deleting PforNew instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PforNew findById(java.lang.Integer id) {
		log.debug("getting PforNew instance with id: " + id);
		try {
			PforNew instance = (PforNew) getHibernateTemplate().get(
					"com.stoms.model.PforNew", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PforNew instance) {
		log.debug("finding PforNew instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PforNew instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PforNew as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItemId(Object itemId) {
		return findByProperty(ITEM_ID, itemId);
	}

	public List findByPtravelCost(Object ptravelCost) {
		return findByProperty(PTRAVEL_COST, ptravelCost);
	}

	public List findByPexchange(Object pexchange) {
		return findByProperty(PEXCHANGE, pexchange);
	}

	public List findByPequipment(Object pequipment) {
		return findByProperty(PEQUIPMENT, pequipment);
	}

	public List findByPconference(Object pconference) {
		return findByProperty(PCONFERENCE, pconference);
	}

	public List findAll() {
		log.debug("finding all PforNew instances");
		try {
			String queryString = "from PforNew";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PforNew merge(PforNew detachedInstance) {
		log.debug("merging PforNew instance");
		try {
			PforNew result = (PforNew) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PforNew instance) {
		log.debug("attaching dirty PforNew instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PforNew instance) {
		log.debug("attaching clean PforNew instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PforNewDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PforNewDAO) ctx.getBean("PforNewDAO");
	}
}