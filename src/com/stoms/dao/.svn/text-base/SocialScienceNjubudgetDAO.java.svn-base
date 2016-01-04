package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.SocialScienceNjubudget;

/**
 * A data access object (DAO) providing persistence and search support for
 * SocialScienceNjubudget entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.SocialScienceNjubudget
 * @author MyEclipse Persistence Tools
 */

public class SocialScienceNjubudgetDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SocialScienceNjubudgetDAO.class);
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
	public static final String ASTATUS = "astatus";

	protected void initDao() {
		// do nothing
	}

	public void save(SocialScienceNjubudget transientInstance) {
		log.debug("saving SocialScienceNjubudget instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SocialScienceNjubudget persistentInstance) {
		log.debug("deleting SocialScienceNjubudget instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SocialScienceNjubudget findById(java.lang.Long id) {
		log.debug("getting SocialScienceNjubudget instance with id: " + id);
		try {
			SocialScienceNjubudget instance = (SocialScienceNjubudget) getHibernateTemplate()
					.get("com.stoms.model.SocialScienceNjubudget", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SocialScienceNjubudget instance) {
		log.debug("finding SocialScienceNjubudget instance by example");
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
		log.debug("finding SocialScienceNjubudget instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SocialScienceNjubudget as model where model."
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

	public List findByAstatus(Object astatus) {
		return findByProperty(ASTATUS, astatus);
	}

	public List findAll() {
		log.debug("finding all SocialScienceNjubudget instances");
		try {
			String queryString = "from SocialScienceNjubudget";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SocialScienceNjubudget merge(SocialScienceNjubudget detachedInstance) {
		log.debug("merging SocialScienceNjubudget instance");
		try {
			SocialScienceNjubudget result = (SocialScienceNjubudget) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SocialScienceNjubudget instance) {
		log.debug("attaching dirty SocialScienceNjubudget instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SocialScienceNjubudget instance) {
		log.debug("attaching clean SocialScienceNjubudget instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SocialScienceNjubudgetDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SocialScienceNjubudgetDAO) ctx
				.getBean("SocialScienceNjubudgetDAO");
	}
}