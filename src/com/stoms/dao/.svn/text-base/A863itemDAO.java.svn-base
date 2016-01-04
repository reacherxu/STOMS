package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.A863item;

/**
 * A data access object (DAO) providing persistence and search support for
 * A863item entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.stoms.model.A863item
 * @author MyEclipse Persistence Tools
 */

public class A863itemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(A863itemDAO.class);
	// property constants
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String CONTRACT_ID = "contractId";
	public static final String ITEM_NAME = "itemName";
	public static final String TEACHER_NAME = "teacherName";
	public static final String INSIDE_ID = "insideId";
	public static final String CARD_ID = "cardId";

	protected void initDao() {
		// do nothing
	}

	public void save(A863item transientInstance) {
		log.debug("saving A863item instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(A863item persistentInstance) {
		log.debug("deleting A863item instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public A863item findById(java.lang.Long id) {
		log.debug("getting A863item instance with id: " + id);
		try {
			A863item instance = (A863item) getHibernateTemplate().get(
					"com.stoms.model.A863item", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(A863item instance) {
		log.debug("finding A863item instance by example");
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
		log.debug("finding A863item instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from A863item as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItemPk(Object itemPk) {
		return findByProperty(ITEM_PK, itemPk);
	}

	public List findByItemId(Object itemId) {
		return findByProperty(ITEM_ID, itemId);
	}

	public List findByContractId(Object contractId) {
		return findByProperty(CONTRACT_ID, contractId);
	}

	public List findByItemName(Object itemName) {
		return findByProperty(ITEM_NAME, itemName);
	}

	public List findByTeacherName(Object teacherName) {
		return findByProperty(TEACHER_NAME, teacherName);
	}

	public List findByInsideId(Object insideId) {
		return findByProperty(INSIDE_ID, insideId);
	}

	public List findByCardId(Object cardId) {
		return findByProperty(CARD_ID, cardId);
	}

	public List findAll() {
		log.debug("finding all A863item instances");
		try {
			String queryString = "from A863item";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public A863item merge(A863item detachedInstance) {
		log.debug("merging A863item instance");
		try {
			A863item result = (A863item) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(A863item instance) {
		log.debug("attaching dirty A863item instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(A863item instance) {
		log.debug("attaching clean A863item instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static A863itemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (A863itemDAO) ctx.getBean("A863itemDAO");
	}
}