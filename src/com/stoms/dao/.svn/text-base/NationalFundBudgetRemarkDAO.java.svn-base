package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.NationalFundBudgetRemark;

/**
 * A data access object (DAO) providing persistence and search support for
 * NationalFundBudgetRemark entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.stoms.model.NationalFundBudgetRemark
 * @author MyEclipse Persistence Tools
 */

public class NationalFundBudgetRemarkDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(NationalFundBudgetRemarkDAO.class);
	// property constants
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String TEST_COST = "testCost";
	public static final String FUEL_COST = "fuelCost";
	public static final String CONFERENCE_COST = "conferenceCost";
	public static final String PUBLISH_COST = "publishCost";
	public static final String OTHER_BUSINESS = "otherBusiness";
	public static final String SUM_BUSINESS = "sumBusiness";
	public static final String RAW_MATERIAL = "rawMaterial";
	public static final String OTHER_MATERIAL = "otherMaterial";
	public static final String SUM_MATERIAL = "sumMaterial";
	public static final String BUY_EQUIPMENT = "buyEquipment";
	public static final String TRIAL_EQUIPMENT = "trialEquipment";
	public static final String SUM_EQUIPMENT = "sumEquipment";
	public static final String LABORATORY = "laboratory";
	public static final String COOPERATION = "cooperation";
	public static final String STUDY_FUND = "studyFund";
	public static final String EXCHANGE = "exchange";
	public static final String EXPERT = "expert";
	public static final String EXCHANGE_SUM = "exchangeSum";
	public static final String SERVICE_COST = "serviceCost";
	public static final String MANAGE_COST = "manageCost";
	public static final String SUMS = "sums";

	protected void initDao() {
		// do nothing
	}

	public void save(NationalFundBudgetRemark transientInstance) {
		log.debug("saving NationalFundBudgetRemark instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NationalFundBudgetRemark persistentInstance) {
		log.debug("deleting NationalFundBudgetRemark instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NationalFundBudgetRemark findById(java.lang.Long id) {
		log.debug("getting NationalFundBudgetRemark instance with id: " + id);
		try {
			NationalFundBudgetRemark instance = (NationalFundBudgetRemark) getHibernateTemplate()
					.get("com.stoms.model.NationalFundBudgetRemark", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NationalFundBudgetRemark instance) {
		log.debug("finding NationalFundBudgetRemark instance by example");
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
		log.debug("finding NationalFundBudgetRemark instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from NationalFundBudgetRemark as model where model."
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

	public List findByTestCost(Object testCost) {
		return findByProperty(TEST_COST, testCost);
	}

	public List findByFuelCost(Object fuelCost) {
		return findByProperty(FUEL_COST, fuelCost);
	}

	public List findByConferenceCost(Object conferenceCost) {
		return findByProperty(CONFERENCE_COST, conferenceCost);
	}

	public List findByPublishCost(Object publishCost) {
		return findByProperty(PUBLISH_COST, publishCost);
	}

	public List findByOtherBusiness(Object otherBusiness) {
		return findByProperty(OTHER_BUSINESS, otherBusiness);
	}

	public List findBySumBusiness(Object sumBusiness) {
		return findByProperty(SUM_BUSINESS, sumBusiness);
	}

	public List findByRawMaterial(Object rawMaterial) {
		return findByProperty(RAW_MATERIAL, rawMaterial);
	}

	public List findByOtherMaterial(Object otherMaterial) {
		return findByProperty(OTHER_MATERIAL, otherMaterial);
	}

	public List findBySumMaterial(Object sumMaterial) {
		return findByProperty(SUM_MATERIAL, sumMaterial);
	}

	public List findByBuyEquipment(Object buyEquipment) {
		return findByProperty(BUY_EQUIPMENT, buyEquipment);
	}

	public List findByTrialEquipment(Object trialEquipment) {
		return findByProperty(TRIAL_EQUIPMENT, trialEquipment);
	}

	public List findBySumEquipment(Object sumEquipment) {
		return findByProperty(SUM_EQUIPMENT, sumEquipment);
	}

	public List findByLaboratory(Object laboratory) {
		return findByProperty(LABORATORY, laboratory);
	}

	public List findByCooperation(Object cooperation) {
		return findByProperty(COOPERATION, cooperation);
	}

	public List findByStudyFund(Object studyFund) {
		return findByProperty(STUDY_FUND, studyFund);
	}

	public List findByExchange(Object exchange) {
		return findByProperty(EXCHANGE, exchange);
	}

	public List findByExpert(Object expert) {
		return findByProperty(EXPERT, expert);
	}

	public List findByExchangeSum(Object exchangeSum) {
		return findByProperty(EXCHANGE_SUM, exchangeSum);
	}

	public List findByServiceCost(Object serviceCost) {
		return findByProperty(SERVICE_COST, serviceCost);
	}

	public List findByManageCost(Object manageCost) {
		return findByProperty(MANAGE_COST, manageCost);
	}

	public List findBySums(Object sums) {
		return findByProperty(SUMS, sums);
	}

	public List findAll() {
		log.debug("finding all NationalFundBudgetRemark instances");
		try {
			String queryString = "from NationalFundBudgetRemark";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NationalFundBudgetRemark merge(
			NationalFundBudgetRemark detachedInstance) {
		log.debug("merging NationalFundBudgetRemark instance");
		try {
			NationalFundBudgetRemark result = (NationalFundBudgetRemark) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NationalFundBudgetRemark instance) {
		log.debug("attaching dirty NationalFundBudgetRemark instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NationalFundBudgetRemark instance) {
		log.debug("attaching clean NationalFundBudgetRemark instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NationalFundBudgetRemarkDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (NationalFundBudgetRemarkDAO) ctx
				.getBean("NationalFundBudgetRemarkDAO");
	}
}