package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.Expenditure;

/**
 * A data access object (DAO) providing persistence and search support for
 * Expenditure entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.Expenditure
 * @author MyEclipse Persistence Tools
 */

public class ExpenditureDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ExpenditureDAO.class);
	// property constants
	public static final String CERTIFICATE_DATE = "certificateDate";
	public static final String TYPE = "type";
	public static final String CERTIFICATE_ID = "certificateId";
	public static final String ABSTRACT_ = "abstract_";
	public static final String SUBJECT_ID = "subjectId";
	public static final String SECTOR = "sector";
	public static final String PROJECT_ID = "projectId";
	public static final String EXPENDITURE = "expenditure";
	public static final String LOAN = "loan";

	protected void initDao() {
		// do nothing
	}

	public void save(Expenditure transientInstance) {
		log.debug("saving Expenditure instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Expenditure persistentInstance) {
		log.debug("deleting Expenditure instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Expenditure findById(java.lang.Integer id) {
		log.debug("getting Expenditure instance with id: " + id);
		try {
			Expenditure instance = (Expenditure) getHibernateTemplate().get(
					"com.stoms.model.Expenditure", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Expenditure instance) {
		log.debug("finding Expenditure instance by example");
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
		log.debug("finding Expenditure instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Expenditure as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCertificateDate(Object certificateDate) {
		return findByProperty(CERTIFICATE_DATE, certificateDate);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByCertificateId(Object certificateId) {
		return findByProperty(CERTIFICATE_ID, certificateId);
	}

	public List findByAbstract_(Object abstract_) {
		return findByProperty(ABSTRACT_, abstract_);
	}

	public List findBySubjectId(Object subjectId) {
		return findByProperty(SUBJECT_ID, subjectId);
	}

	public List findBySector(Object sector) {
		return findByProperty(SECTOR, sector);
	}

	public List findByProjectId(Object projectId) {
		return findByProperty(PROJECT_ID, projectId);
	}

	public List findByExpenditure(Object expenditure) {
		return findByProperty(EXPENDITURE, expenditure);
	}

	public List findByLoan(Object loan) {
		return findByProperty(LOAN, loan);
	}

	public List findAll() {
		log.debug("finding all Expenditure instances");
		try {
			String queryString = "from Expenditure";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Expenditure merge(Expenditure detachedInstance) {
		log.debug("merging Expenditure instance");
		try {
			Expenditure result = (Expenditure) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Expenditure instance) {
		log.debug("attaching dirty Expenditure instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Expenditure instance) {
		log.debug("attaching clean Expenditure instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExpenditureDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ExpenditureDAO) ctx.getBean("ExpenditureDAO");
	}
}