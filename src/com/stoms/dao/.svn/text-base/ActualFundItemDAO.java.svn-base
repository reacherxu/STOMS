package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.ActualFundItem;

/**
 * A data access object (DAO) providing persistence and search support for
 * ActualFundItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.ActualFundItem
 * @author MyEclipse Persistence Tools
 */

public class ActualFundItemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ActualFundItemDAO.class);
	// property constants
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String CONTRACT_ID = "contractId";
	public static final String ITEM_NAME = "itemName";
	public static final String TEACHER_NAME = "teacherName";
	public static final String NATION_FUND = "nationFund";
	public static final String AGENCY_FUND = "agencyFund";
	public static final String COUNTY_FUND = "countyFund";
	public static final String DEPARTMENT_FUND = "departmentFund";
	public static final String SELF_FUND = "selfFund";
	public static final String OTHER_FUND = "otherFund";
	public static final String FUND_SUM = "fundSum";

	protected void initDao() {
		// do nothing
	}

	public void save(ActualFundItem transientInstance) {
		log.debug("saving ActualFundItem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ActualFundItem persistentInstance) {
		log.debug("deleting ActualFundItem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ActualFundItem findById(java.lang.Long id) {
		log.debug("getting ActualFundItem instance with id: " + id);
		try {
			ActualFundItem instance = (ActualFundItem) getHibernateTemplate()
					.get("com.stoms.model.ActualFundItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ActualFundItem instance) {
		log.debug("finding ActualFundItem instance by example");
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
		log.debug("finding ActualFundItem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ActualFundItem as model where model."
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

	public List findByNationFund(Object nationFund) {
		return findByProperty(NATION_FUND, nationFund);
	}

	public List findByAgencyFund(Object agencyFund) {
		return findByProperty(AGENCY_FUND, agencyFund);
	}

	public List findByCountyFund(Object countyFund) {
		return findByProperty(COUNTY_FUND, countyFund);
	}

	public List findByDepartmentFund(Object departmentFund) {
		return findByProperty(DEPARTMENT_FUND, departmentFund);
	}

	public List findBySelfFund(Object selfFund) {
		return findByProperty(SELF_FUND, selfFund);
	}

	public List findByOtherFund(Object otherFund) {
		return findByProperty(OTHER_FUND, otherFund);
	}

	public List findByFundSum(Object fundSum) {
		return findByProperty(FUND_SUM, fundSum);
	}

	public List findAll() {
		log.debug("finding all ActualFundItem instances");
		try {
			String queryString = "from ActualFundItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ActualFundItem merge(ActualFundItem detachedInstance) {
		log.debug("merging ActualFundItem instance");
		try {
			ActualFundItem result = (ActualFundItem) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ActualFundItem instance) {
		log.debug("attaching dirty ActualFundItem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ActualFundItem instance) {
		log.debug("attaching clean ActualFundItem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ActualFundItemDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ActualFundItemDAO) ctx.getBean("ActualFundItemDAO");
	}
}