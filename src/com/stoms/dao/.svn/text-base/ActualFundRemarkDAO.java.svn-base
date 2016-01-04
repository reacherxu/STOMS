package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.ActualFundRemark;

/**
 	* A data access object (DAO) providing persistence and search support for ActualFundRemark entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.ActualFundRemark
  * @author MyEclipse Persistence Tools 
 */

public class ActualFundRemarkDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ActualFundRemarkDAO.class);
		//property constants
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String STAFF_COST = "staffCost";
	public static final String EQUIPMENT_COST = "equipmentCost";
	public static final String FUEL_COST = "fuelCost";
	public static final String MATERIAL_COST = "materialCost";
	public static final String TEST_COST = "testCost";
	public static final String TRAVEL_COST = "travelCost";
	public static final String CONFERENCE_COST = "conferenceCost";
	public static final String PUBLISH_COST = "publishCost";
	public static final String MANAGE_COST = "manageCost";
	public static final String OTHER_COST = "otherCost";
	public static final String SUM_COST = "sumCost";



	protected void initDao() {
		//do nothing
	}
    
    public void save(ActualFundRemark transientInstance) {
        log.debug("saving ActualFundRemark instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ActualFundRemark persistentInstance) {
        log.debug("deleting ActualFundRemark instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ActualFundRemark findById( java.lang.Long id) {
        log.debug("getting ActualFundRemark instance with id: " + id);
        try {
            ActualFundRemark instance = (ActualFundRemark) getHibernateTemplate()
                    .get("com.stoms.model.ActualFundRemark", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ActualFundRemark instance) {
        log.debug("finding ActualFundRemark instance by example");
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
      log.debug("finding ActualFundRemark instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ActualFundRemark as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByItemPk(Object itemPk
	) {
		return findByProperty(ITEM_PK, itemPk
		);
	}
	
	public List findByItemId(Object itemId
	) {
		return findByProperty(ITEM_ID, itemId
		);
	}
	
	public List findByStaffCost(Object staffCost
	) {
		return findByProperty(STAFF_COST, staffCost
		);
	}
	
	public List findByEquipmentCost(Object equipmentCost
	) {
		return findByProperty(EQUIPMENT_COST, equipmentCost
		);
	}
	
	public List findByFuelCost(Object fuelCost
	) {
		return findByProperty(FUEL_COST, fuelCost
		);
	}
	
	public List findByMaterialCost(Object materialCost
	) {
		return findByProperty(MATERIAL_COST, materialCost
		);
	}
	
	public List findByTestCost(Object testCost
	) {
		return findByProperty(TEST_COST, testCost
		);
	}
	
	public List findByTravelCost(Object travelCost
	) {
		return findByProperty(TRAVEL_COST, travelCost
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
	
	public List findByManageCost(Object manageCost
	) {
		return findByProperty(MANAGE_COST, manageCost
		);
	}
	
	public List findByOtherCost(Object otherCost
	) {
		return findByProperty(OTHER_COST, otherCost
		);
	}
	
	public List findBySumCost(Object sumCost
	) {
		return findByProperty(SUM_COST, sumCost
		);
	}
	

	public List findAll() {
		log.debug("finding all ActualFundRemark instances");
		try {
			String queryString = "from ActualFundRemark";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ActualFundRemark merge(ActualFundRemark detachedInstance) {
        log.debug("merging ActualFundRemark instance");
        try {
            ActualFundRemark result = (ActualFundRemark) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ActualFundRemark instance) {
        log.debug("attaching dirty ActualFundRemark instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ActualFundRemark instance) {
        log.debug("attaching clean ActualFundRemark instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ActualFundRemarkDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ActualFundRemarkDAO) ctx.getBean("ActualFundRemarkDAO");
	}
}