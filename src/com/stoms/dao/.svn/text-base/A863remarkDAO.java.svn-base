package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.A863remark;

/**
 * A data access object (DAO) providing persistence and search support for
 * A863remark entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.stoms.model.A863remark
 * @author MyEclipse Persistence Tools
 */

public class A863remarkDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(A863remarkDAO.class);
	// property constants
	public static final String A863OUTLAY_PK = "a863outlayPk";
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String BUY_EQUIPMENT = "buyEquipment";
	public static final String TRIAL_EQUIPMENT = "trialEquipment";
	public static final String TRANSFORM = "transform";
	public static final String EQUIPMENT_COST = "equipmentCost";
	public static final String MATERIAL_COST = "materialCost";
	public static final String TEST_COST = "testCost";
	public static final String FUEL_COST = "fuelCost";
	public static final String TRAVEL_COST = "travelCost";
	public static final String CONFERENCE_COST = "conferenceCost";
	public static final String EXCHANGE_COST = "exchangeCost";
	public static final String PUBLISH_COST = "publishCost";
	public static final String SERVICE_COST = "serviceCost";
	public static final String CONSULT_COST = "consultCost";
	public static final String CONSTRUCTION_COST = "constructionCost";
	public static final String OTHER_COST = "otherCost";
	public static final String DIRECT_COST = "directCost";
	public static final String COST_SUM = "costSum";
	public static final String PERFORMANCE_COST = "performanceCost";
	public static final String INDIRECT_COST = "indirectCost";
	public static final String SUBSIDIZE_SPECIAL = "subsidizeSpecial";
	public static final String OTHER_FUNDS_SELF = "otherFundsSelf";
	public static final String OWN_FUNDS_SELF = "ownFundsSelf";
	public static final String OTHER_SELF = "otherSelf";
	public static final String SELF_FINANCE = "selfFinance";
	public static final String FUND_SUM = "fundSum";

	protected void initDao() {
		// do nothing
	}

	public void save(A863remark transientInstance) {
		log.debug("saving A863remark instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(A863remark persistentInstance) {
		log.debug("deleting A863remark instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public A863remark findById(java.lang.Long id) {
		log.debug("getting A863remark instance with id: " + id);
		try {
			A863remark instance = (A863remark) getHibernateTemplate().get(
					"com.stoms.model.A863remark", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(A863remark instance) {
		log.debug("finding A863remark instance by example");
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
		log.debug("finding A863remark instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from A863remark as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByA863outlayPk(Object a863outlayPk) {
		return findByProperty(A863OUTLAY_PK, a863outlayPk);
	}

	public List findByItemPk(Object itemPk) {
		return findByProperty(ITEM_PK, itemPk);
	}

	public List findByItemId(Object itemId) {
		return findByProperty(ITEM_ID, itemId);
	}

	public List findByBuyEquipment(Object buyEquipment) {
		return findByProperty(BUY_EQUIPMENT, buyEquipment);
	}

	public List findByTrialEquipment(Object trialEquipment) {
		return findByProperty(TRIAL_EQUIPMENT, trialEquipment);
	}

	public List findByTransform(Object transform) {
		return findByProperty(TRANSFORM, transform);
	}

	public List findByEquipmentCost(Object equipmentCost) {
		return findByProperty(EQUIPMENT_COST, equipmentCost);
	}

	public List findByMaterialCost(Object materialCost) {
		return findByProperty(MATERIAL_COST, materialCost);
	}

	public List findByTestCost(Object testCost) {
		return findByProperty(TEST_COST, testCost);
	}

	public List findByFuelCost(Object fuelCost) {
		return findByProperty(FUEL_COST, fuelCost);
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

	public List findByPublishCost(Object publishCost) {
		return findByProperty(PUBLISH_COST, publishCost);
	}

	public List findByServiceCost(Object serviceCost) {
		return findByProperty(SERVICE_COST, serviceCost);
	}

	public List findByConsultCost(Object consultCost) {
		return findByProperty(CONSULT_COST, consultCost);
	}

	public List findByConstructionCost(Object constructionCost) {
		return findByProperty(CONSTRUCTION_COST, constructionCost);
	}

	public List findByOtherCost(Object otherCost) {
		return findByProperty(OTHER_COST, otherCost);
	}

	public List findByDirectCost(Object directCost) {
		return findByProperty(DIRECT_COST, directCost);
	}

	public List findByCostSum(Object costSum) {
		return findByProperty(COST_SUM, costSum);
	}

	public List findByPerformanceCost(Object performanceCost) {
		return findByProperty(PERFORMANCE_COST, performanceCost);
	}

	public List findByIndirectCost(Object indirectCost) {
		return findByProperty(INDIRECT_COST, indirectCost);
	}

	public List findBySubsidizeSpecial(Object subsidizeSpecial) {
		return findByProperty(SUBSIDIZE_SPECIAL, subsidizeSpecial);
	}

	public List findByOtherFundsSelf(Object otherFundsSelf) {
		return findByProperty(OTHER_FUNDS_SELF, otherFundsSelf);
	}

	public List findByOwnFundsSelf(Object ownFundsSelf) {
		return findByProperty(OWN_FUNDS_SELF, ownFundsSelf);
	}

	public List findByOtherSelf(Object otherSelf) {
		return findByProperty(OTHER_SELF, otherSelf);
	}

	public List findBySelfFinance(Object selfFinance) {
		return findByProperty(SELF_FINANCE, selfFinance);
	}

	public List findByFundSum(Object fundSum) {
		return findByProperty(FUND_SUM, fundSum);
	}

	public List findAll() {
		log.debug("finding all A863remark instances");
		try {
			String queryString = "from A863remark";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public A863remark merge(A863remark detachedInstance) {
		log.debug("merging A863remark instance");
		try {
			A863remark result = (A863remark) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(A863remark instance) {
		log.debug("attaching dirty A863remark instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(A863remark instance) {
		log.debug("attaching clean A863remark instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static A863remarkDAO getFromApplicationContext(ApplicationContext ctx) {
		return (A863remarkDAO) ctx.getBean("A863remarkDAO");
	}
}