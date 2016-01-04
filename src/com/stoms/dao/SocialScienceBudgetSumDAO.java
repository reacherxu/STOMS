package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.SocialScienceBudgetSum;

/**
 * A data access object (DAO) providing persistence and search support for
 * SocialScienceBudgetSum entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.SocialScienceBudgetSum
 * @author MyEclipse Persistence Tools
 */

public class SocialScienceBudgetSumDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SocialScienceBudgetSumDAO.class);
	// property constants
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String MATERIAL_COST = "materialCost";
	public static final String DATA_COST = "dataCost";
	public static final String TRAVEL_COST = "travelCost";
	public static final String CONFERENCE_COST = "conferenceCost";
	public static final String EXCHANGE_COST = "exchangeCost";
	public static final String EQUIPMENT_COST = "equipmentCost";
	public static final String SERVICE_COST = "serviceCost";
	public static final String CONSULT_COST = "consultCost";
	public static final String PRINT_COST = "printCost";
	public static final String MANAGE_COST = "manageCost";
	public static final String OTHER_COST = "otherCost";
	public static final String COST_SUM = "costSum";

	protected void initDao() {
		// do nothing
	}

	public void save(SocialScienceBudgetSum transientInstance) {
		log.debug("saving SocialScienceBudgetSum instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SocialScienceBudgetSum persistentInstance) {
		log.debug("deleting SocialScienceBudgetSum instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SocialScienceBudgetSum findById(java.lang.Long id) {
		log.debug("getting SocialScienceBudgetSum instance with id: " + id);
		try {
			SocialScienceBudgetSum instance = (SocialScienceBudgetSum) getHibernateTemplate()
					.get("com.stoms.model.SocialScienceBudgetSum", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SocialScienceBudgetSum instance) {
		log.debug("finding SocialScienceBudgetSum instance by example");
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
		log.debug("finding SocialScienceBudgetSum instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SocialScienceBudgetSum as model where model."
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

	public List findByMaterialCost(Object materialCost) {
		return findByProperty(MATERIAL_COST, materialCost);
	}

	public List findByDataCost(Object dataCost) {
		return findByProperty(DATA_COST, dataCost);
	}

	public List findByTravelCost(Object travelCost) {
		return findByProperty(TRAVEL_COST, travelCost);
	}

	public List findByConferenceCost(Object conferenceCost) {
		return findByProperty(CONFERENCE_COST, conferenceCost);
	}

	public List findByExchangeCost(Object exchangeCost) {
		return findByProperty(EXCHANGE_COST, exchangeCost);
	}

	public List findByEquipmentCost(Object equipmentCost) {
		return findByProperty(EQUIPMENT_COST, equipmentCost);
	}

	public List findByServiceCost(Object serviceCost) {
		return findByProperty(SERVICE_COST, serviceCost);
	}

	public List findByConsultCost(Object consultCost) {
		return findByProperty(CONSULT_COST, consultCost);
	}

	public List findByPrintCost(Object printCost) {
		return findByProperty(PRINT_COST, printCost);
	}

	public List findByManageCost(Object manageCost) {
		return findByProperty(MANAGE_COST, manageCost);
	}

	public List findByOtherCost(Object otherCost) {
		return findByProperty(OTHER_COST, otherCost);
	}

	public List findByCostSum(Object costSum) {
		return findByProperty(COST_SUM, costSum);
	}

	public List findAll() {
		log.debug("finding all SocialScienceBudgetSum instances");
		try {
			String queryString = "from SocialScienceBudgetSum";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SocialScienceBudgetSum merge(SocialScienceBudgetSum detachedInstance) {
		log.debug("merging SocialScienceBudgetSum instance");
		try {
			SocialScienceBudgetSum result = (SocialScienceBudgetSum) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SocialScienceBudgetSum instance) {
		log.debug("attaching dirty SocialScienceBudgetSum instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SocialScienceBudgetSum instance) {
		log.debug("attaching clean SocialScienceBudgetSum instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SocialScienceBudgetSumDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SocialScienceBudgetSumDAO) ctx
				.getBean("SocialScienceBudgetSumDAO");
	}
}