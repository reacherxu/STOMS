package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.NationalFundAdjust;

/**
 	* A data access object (DAO) providing persistence and search support for NationalFundAdjust entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.NationalFundAdjust
  * @author MyEclipse Persistence Tools 
 */

public class NationalFundAdjustDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(NationalFundAdjustDAO.class);
		//property constants
	public static final String ITEM_PK2 = "itemPk2";
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
	public static final String NTIME = "ntime";
	public static final String NSTATUS = "nstatus";
	public static final String PICTURE = "picture";
	public static final String SUGGESTION = "suggestion";
	public static final String OPERATOR_ID = "operatorId";



	protected void initDao() {
		//do nothing
	}
    
	//查找itemPK对应的Nstatus为“10”的list
    public List findByItemPkAndNstatus(Object value) {
        log.debug("finding Item instance with Nstatus: ItemPK"
              + ", value: " + value);
        try {
           String queryString = "from NationalFundAdjust as model where model.item.itemPk=? and model.nstatus='10'";
  		 return getHibernateTemplate().find(queryString,value);
        } catch (RuntimeException re) {
           log.error("find by ItemPK and Nstatus name failed", re);
           throw re;
        }
  	}

	
    public void save(NationalFundAdjust transientInstance) {
        log.debug("saving NationalFundAdjust instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(NationalFundAdjust persistentInstance) {
        log.debug("deleting NationalFundAdjust instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public NationalFundAdjust findById( java.lang.Long id) {
        log.debug("getting NationalFundAdjust instance with id: " + id);
        try {
            NationalFundAdjust instance = (NationalFundAdjust) getHibernateTemplate()
                    .get("com.stoms.model.NationalFundAdjust", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(NationalFundAdjust instance) {
        log.debug("finding NationalFundAdjust instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding NationalFundAdjust instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from NationalFundAdjust as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByItemPk2(Object itemPk2
	) {
		return findByProperty(ITEM_PK2, itemPk2
		);
	}
	
	public List findByItemId(Object itemId
	) {
		return findByProperty(ITEM_ID, itemId
		);
	}
	
	public List findByTestCost(Object testCost
	) {
		return findByProperty(TEST_COST, testCost
		);
	}
	
	public List findByFuelCost(Object fuelCost
	) {
		return findByProperty(FUEL_COST, fuelCost
		);
	}
	
	public List findByConferenceCost(Object conferenceCost
	) {
		return findByProperty(CONFERENCE_COST, conferenceCost
		);
	}
	
	public List findByPublishCost(Object publishCost
	) {
		return findByProperty(PUBLISH_COST, publishCost
		);
	}
	
	public List findByOtherBusiness(Object otherBusiness
	) {
		return findByProperty(OTHER_BUSINESS, otherBusiness
		);
	}
	
	public List findBySumBusiness(Object sumBusiness
	) {
		return findByProperty(SUM_BUSINESS, sumBusiness
		);
	}
	
	public List findByRawMaterial(Object rawMaterial
	) {
		return findByProperty(RAW_MATERIAL, rawMaterial
		);
	}
	
	public List findByOtherMaterial(Object otherMaterial
	) {
		return findByProperty(OTHER_MATERIAL, otherMaterial
		);
	}
	
	public List findBySumMaterial(Object sumMaterial
	) {
		return findByProperty(SUM_MATERIAL, sumMaterial
		);
	}
	
	public List findByBuyEquipment(Object buyEquipment
	) {
		return findByProperty(BUY_EQUIPMENT, buyEquipment
		);
	}
	
	public List findByTrialEquipment(Object trialEquipment
	) {
		return findByProperty(TRIAL_EQUIPMENT, trialEquipment
		);
	}
	
	public List findBySumEquipment(Object sumEquipment
	) {
		return findByProperty(SUM_EQUIPMENT, sumEquipment
		);
	}
	
	public List findByLaboratory(Object laboratory
	) {
		return findByProperty(LABORATORY, laboratory
		);
	}
	
	public List findByCooperation(Object cooperation
	) {
		return findByProperty(COOPERATION, cooperation
		);
	}
	
	public List findByStudyFund(Object studyFund
	) {
		return findByProperty(STUDY_FUND, studyFund
		);
	}
	
	public List findByExchange(Object exchange
	) {
		return findByProperty(EXCHANGE, exchange
		);
	}
	
	public List findByExpert(Object expert
	) {
		return findByProperty(EXPERT, expert
		);
	}
	
	public List findByExchangeSum(Object exchangeSum
	) {
		return findByProperty(EXCHANGE_SUM, exchangeSum
		);
	}
	
	public List findByServiceCost(Object serviceCost
	) {
		return findByProperty(SERVICE_COST, serviceCost
		);
	}
	
	public List findByManageCost(Object manageCost
	) {
		return findByProperty(MANAGE_COST, manageCost
		);
	}
	
	public List findBySums(Object sums
	) {
		return findByProperty(SUMS, sums
		);
	}
	
	public List findByNtime(Object ntime
	) {
		return findByProperty(NTIME, ntime
		);
	}
	
	public List findByNstatus(Object nstatus
	) {
		return findByProperty(NSTATUS, nstatus
		);
	}
	
	public List findByPicture(Object picture
	) {
		return findByProperty(PICTURE, picture
		);
	}
	
	public List findBySuggestion(Object suggestion
	) {
		return findByProperty(SUGGESTION, suggestion
		);
	}
	
	public List findByOperatorId(Object operatorId
	) {
		return findByProperty(OPERATOR_ID, operatorId
		);
	}
	

	public List findAll() {
		log.debug("finding all NationalFundAdjust instances");
		try {
			String queryString = "from NationalFundAdjust";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public NationalFundAdjust merge(NationalFundAdjust detachedInstance) {
        log.debug("merging NationalFundAdjust instance");
        try {
            NationalFundAdjust result = (NationalFundAdjust) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(NationalFundAdjust instance) {
        log.debug("attaching dirty NationalFundAdjust instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(NationalFundAdjust instance) {
        log.debug("attaching clean NationalFundAdjust instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static NationalFundAdjustDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (NationalFundAdjustDAO) ctx.getBean("NationalFundAdjustDAO");
	}
}