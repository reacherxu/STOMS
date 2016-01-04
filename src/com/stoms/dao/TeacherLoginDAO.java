package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.Teacher;
import com.stoms.model.TeacherLogin;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeacherLogin entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.TeacherLogin
 * @author MyEclipse Persistence Tools
 */

public class TeacherLoginDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TeacherLoginDAO.class);
	// property constants
	public static final String TEACHER_ID = "teacherId";
	public static final String TPASSWORD = "tpassword";
	public static final String RECENT_LOGIN_TIME = "recentLoginTime";
	public static final String RECENT_LOGIN_IP = "recentLoginIp";
	public static final String USER_TYPE = "userType";
	public static final String IS_ACTIVATE = "isActivate";

	protected void initDao() {
		// do nothing
	}

	public void save(TeacherLogin transientInstance) {
		log.debug("saving TeacherLogin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeacherLogin persistentInstance) {
		log.debug("deleting TeacherLogin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeacherLogin findById(java.lang.Long id) {
		log.debug("getting TeacherLogin instance with id: " + id);
		try {
			TeacherLogin instance = (TeacherLogin) getHibernateTemplate().get(
					"com.stoms.model.TeacherLogin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByExample(TeacherLogin instance) {
		log.debug("finding TeacherLogin instance by example");
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
		log.debug("finding TeacherLogin instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TeacherLogin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTeacherId(Object teacherId) {
		return findByProperty(TEACHER_ID, teacherId);
	}

	public List findByTpassword(Object tpassword) {
		return findByProperty(TPASSWORD, tpassword);
	}

	public List findByRecentLoginTime(Object recentLoginTime) {
		return findByProperty(RECENT_LOGIN_TIME, recentLoginTime);
	}

	public List findByRecentLoginIp(Object recentLoginIp) {
		return findByProperty(RECENT_LOGIN_IP, recentLoginIp);
	}

	public List findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List findByIsActivate(Object isActivate) {
		return findByProperty(IS_ACTIVATE, isActivate);
	}

	public List findAll() {
		log.debug("finding all TeacherLogin instances");
		try {
			String queryString = "from TeacherLogin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findNormalUserList() {
		log.debug("finding all Normal User instances");
		try {
			String queryString = "select teacherId from TeacherLogin where userType = 1";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAdminAndSuperAdminUserList() {
		log.debug("finding all Admin User instances");
		try {
			String queryString = "select teacherId from TeacherLogin where userType = 0 or userType = 2";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findAdminUserList() {
		log.debug("finding all Admin User instances");
		try {
			String queryString = "select teacherId from TeacherLogin where userType = 0";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public TeacherLogin merge(TeacherLogin detachedInstance) {
		log.debug("merging TeacherLogin instance");
		try {
			TeacherLogin result = (TeacherLogin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeacherLogin instance) {
		log.debug("attaching dirty TeacherLogin instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeacherLogin instance) {
		log.debug("attaching clean TeacherLogin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	

	
	public static TeacherLoginDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TeacherLoginDAO) ctx.getBean("TeacherLoginDAO");
	}
}