package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.NationalFundItem;

/**
 * A data access object (DAO) providing persistence and search support for
 * NationalFundItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.NationalFundItem
 * @author MyEclipse Persistence Tools
 */

public class NationalFundItemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(NationalFundItemDAO.class);
	// property constants
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String CONTRACT_ID = "contractId";
	public static final String ITEM_NAME = "itemName";
	public static final String TEACHER_NAME = "teacherName";
	public static final String APPROVE_ID = "approveId";
	public static final String DIAL_FUNDS_SUM = "dialFundsSum";
	public static final String DIAL_FUNDS_LAST = "dialFundsLast";
	public static final String OTHER_PLAN_FUNDS_BUGET = "otherPlanFundsBuget";
	public static final String OTHER_PLAN_FUNDS_OUTLAY = "otherPlanFundsOutlay";
	public static final String OTHER_SUBSIDIZE_BUGET = "otherSubsidizeBuget";
	public static final String OTHER_SUBSIDIZE_OUTLAY = "otherSubsidizeOutlay";
	public static final String OTHER_SUM_BUGET = "otherSumBuget";
	public static final String OTHER_SUM_OUTLAY = "otherSumOutlay";

	protected void initDao() {
		// do nothing
	}

	public void save(NationalFundItem transientInstance) {
		log.debug("saving NationalFundItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NationalFundItem persistentInstance) {
		log.debug("deleting NationalFundItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NationalFundItem findById(java.lang.Long id) {
		log.debug("getting NationalFundItem instance with id: " + id);
		try {
			NationalFundItem instance = (NationalFundItem) getHibernateTemplate()
					.get("com.stoms.model.NationalFundItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NationalFundItem instance) {
		log.debug("finding NationalFundItem instance by example");
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
		log.debug("finding NationalFundItem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from NationalFundItem as model where model."
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

	public List findByApproveId(Object approveId) {
		return findByProperty(APPROVE_ID, approveId);
	}

	public List findByDialFundsSum(Object dialFundsSum) {
		return findByProperty(DIAL_FUNDS_SUM, dialFundsSum);
	}

	public List findByDialFundsLast(Object dialFundsLast) {
		return findByProperty(DIAL_FUNDS_LAST, dialFundsLast);
	}

	public List findByOtherPlanFundsBuget(Object otherPlanFundsBuget) {
		return findByProperty(OTHER_PLAN_FUNDS_BUGET, otherPlanFundsBuget);
	}

	public List findByOtherPlanFundsOutlay(Object otherPlanFundsOutlay) {
		return findByProperty(OTHER_PLAN_FUNDS_OUTLAY, otherPlanFundsOutlay);
	}

	public List findByOtherSubsidizeBuget(Object otherSubsidizeBuget) {
		return findByProperty(OTHER_SUBSIDIZE_BUGET, otherSubsidizeBuget);
	}

	public List findByOtherSubsidizeOutlay(Object otherSubsidizeOutlay) {
		return findByProperty(OTHER_SUBSIDIZE_OUTLAY, otherSubsidizeOutlay);
	}

	public List findByOtherSumBuget(Object otherSumBuget) {
		return findByProperty(OTHER_SUM_BUGET, otherSumBuget);
	}

	public List findByOtherSumOutlay(Object otherSumOutlay) {
		return findByProperty(OTHER_SUM_OUTLAY, otherSumOutlay);
	}

	public List findAll() {
		log.debug("finding all NationalFundItem instances");
		try {
			String queryString = "from NationalFundItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NationalFundItem merge(NationalFundItem detachedInstance) {
		log.debug("merging NationalFundItem instance");
		try {
			NationalFundItem result = (NationalFundItem) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NationalFundItem instance) {
		log.debug("attaching dirty NationalFundItem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NationalFundItem instance) {
		log.debug("attaching clean NationalFundItem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NationalFundItemDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (NationalFundItemDAO) ctx.getBean("NationalFundItemDAO");
	}
}