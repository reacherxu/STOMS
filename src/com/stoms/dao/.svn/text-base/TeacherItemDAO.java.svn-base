package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.TeacherItem;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeacherItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.TeacherItem
 * @author MyEclipse Persistence Tools
 */

public class TeacherItemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TeacherItemDAO.class);
	// property constants
	public static final String ITEM_ID = "itemId";
	public static final String TEACHER_ID = "teacherId";

	protected void initDao() {
		// do nothing
	}

	public void save(TeacherItem transientInstance) {
		log.debug("saving TeacherItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeacherItem persistentInstance) {
		log.debug("deleting TeacherItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeacherItem findById(java.lang.Long id) {
		log.debug("getting TeacherItem instance with id: " + id);
		try {
			TeacherItem instance = (TeacherItem) getHibernateTemplate().get(
					"com.stoms.model.TeacherItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeacherItem instance) {
		log.debug("finding TeacherItem instance by example");
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
		log.debug("finding TeacherItem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TeacherItem as model where model."
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

	public List findByTeacherId(Object teacherId) {
		return findByProperty(TEACHER_ID, teacherId);
	}

	public List findAll() {
		log.debug("finding all TeacherItem instances");
		try {
			String queryString = "from TeacherItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeacherItem merge(TeacherItem detachedInstance) {
		log.debug("merging TeacherItem instance");
		try {
			TeacherItem result = (TeacherItem) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeacherItem instance) {
		log.debug("attaching dirty TeacherItem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeacherItem instance) {
		log.debug("attaching clean TeacherItem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherItemDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TeacherItemDAO) ctx.getBean("TeacherItemDAO");
	}
}