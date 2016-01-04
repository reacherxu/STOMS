package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.SocialScienceOutlay;

/**
 	* A data access object (DAO) providing persistence and search support for SocialScienceOutlay entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.SocialScienceOutlay
  * @author MyEclipse Persistence Tools 
 */

public class SocialScienceOutlayDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(SocialScienceOutlayDAO.class);
		//property constants
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
	public static final String OUTLAY_TIME = "outlayTime";



	protected void initDao() {
		//do nothing
	}
    
	//查询当前项目（社科基金项目）各字段支出总和
    public List findColumnSumListByItemPK(long itempk) {
    	Session session = this.getSession();
        log.debug("finding Column Sum by itempk");
        try {
        	String queryString = "select sum(materialCost),sum(dataCost),sum(travelCost)," +
        			"sum(conferenceCost),sum(exchangeCost),sum(equipmentCost),sum(serviceCost)," +
        			"sum(consultCost),sum(printCost),sum(manageCost),sum(otherCost)," +
           			"sum(costSum)" + " from SocialScienceOutlay as model where model.itemPk=?";

        	Query query = session.createQuery(queryString); 
        	
        	query.setParameter(0, itempk);
        	return query.list();
        	
        } catch (RuntimeException re) {
           log.error("find by Dim name failed", re);
           throw re;
        }
        finally
        {
        	session.close();
        }
  	}
	
    public void save(SocialScienceOutlay transientInstance) {
        log.debug("saving SocialScienceOutlay instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SocialScienceOutlay persistentInstance) {
        log.debug("deleting SocialScienceOutlay instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SocialScienceOutlay findById( java.lang.Long id) {
        log.debug("getting SocialScienceOutlay instance with id: " + id);
        try {
            SocialScienceOutlay instance = (SocialScienceOutlay) getHibernateTemplate()
                    .get("com.stoms.model.SocialScienceOutlay", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SocialScienceOutlay instance) {
        log.debug("finding SocialScienceOutlay instance by example");
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
      log.debug("finding SocialScienceOutlay instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SocialScienceOutlay as model where model." 
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
	
	public List findByMaterialCost(Object materialCost
	) {
		return findByProperty(MATERIAL_COST, materialCost
		);
	}
	
	public List findByDataCost(Object dataCost
	) {
		return findByProperty(DATA_COST, dataCost
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
	
	public List findByExchangeCost(Object exchangeCost
	) {
		return findByProperty(EXCHANGE_COST, exchangeCost
		);
	}
	
	public List findByEquipmentCost(Object equipmentCost
	) {
		return findByProperty(EQUIPMENT_COST, equipmentCost
		);
	}
	
	public List findByServiceCost(Object serviceCost
	) {
		return findByProperty(SERVICE_COST, serviceCost
		);
	}
	
	public List findByConsultCost(Object consultCost
	) {
		return findByProperty(CONSULT_COST, consultCost
		);
	}
	
	public List findByPrintCost(Object printCost
	) {
		return findByProperty(PRINT_COST, printCost
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
	
	public List findByCostSum(Object costSum
	) {
		return findByProperty(COST_SUM, costSum
		);
	}
	
	public List findByOutlayTime(Object outlayTime
	) {
		return findByProperty(OUTLAY_TIME, outlayTime
		);
	}
	

	public List findAll() {
		log.debug("finding all SocialScienceOutlay instances");
		try {
			String queryString = "from SocialScienceOutlay";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SocialScienceOutlay merge(SocialScienceOutlay detachedInstance) {
        log.debug("merging SocialScienceOutlay instance");
        try {
            SocialScienceOutlay result = (SocialScienceOutlay) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SocialScienceOutlay instance) {
        log.debug("attaching dirty SocialScienceOutlay instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SocialScienceOutlay instance) {
        log.debug("attaching clean SocialScienceOutlay instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SocialScienceOutlayDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SocialScienceOutlayDAO) ctx.getBean("SocialScienceOutlayDAO");
	}
}