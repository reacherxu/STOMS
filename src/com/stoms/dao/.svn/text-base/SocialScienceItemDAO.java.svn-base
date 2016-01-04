package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.SocialScienceItem;

/**
 * A data access object (DAO) providing persistence and search support for
 * SocialScienceItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.SocialScienceItem
 * @author MyEclipse Persistence Tools
 */

public class SocialScienceItemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SocialScienceItemDAO.class);
	// property constants
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String CONTRACT_ID = "contractId";
	public static final String ITEM_NAME = "itemName";
	public static final String TEACHER_NAME = "teacherName";
	public static final String CARD_ID = "cardId";

	protected void initDao() {
		// do nothing
	}

	public void save(SocialScienceItem transientInstance) {
		log.debug("saving SocialScienceItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SocialScienceItem persistentInstance) {
		log.debug("deleting SocialScienceItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SocialScienceItem findById(java.lang.Long id) {
		log.debug("getting SocialScienceItem instance with id: " + id);
		try {
			SocialScienceItem instance = (SocialScienceItem) getHibernateTemplate()
					.get("com.stoms.model.SocialScienceItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SocialScienceItem instance) {
		log.debug("finding SocialScienceItem instance by example");
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
		log.debug("finding SocialScienceItem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SocialScienceItem as model where model."
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

	public List findByCardId(Object cardId) {
		return findByProperty(CARD_ID, cardId);
	}

	public List findAll() {
		log.debug("finding all SocialScienceItem instances");
		try {
			String queryString = "from SocialScienceItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SocialScienceItem merge(SocialScienceItem detachedInstance) {
		log.debug("merging SocialScienceItem instance");
		try {
			SocialScienceItem result = (SocialScienceItem) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SocialScienceItem instance) {
		log.debug("attaching dirty SocialScienceItem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SocialScienceItem instance) {
		log.debug("attaching clean SocialScienceItem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SocialScienceItemDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SocialScienceItemDAO) ctx.getBean("SocialScienceItemDAO");
	}
}