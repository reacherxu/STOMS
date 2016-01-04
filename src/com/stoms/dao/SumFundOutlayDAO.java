package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.SumFundOutlay;

/**
 * A data access object (DAO) providing persistence and search support for
 * SumFundOutlay entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.SumFundOutlay
 * @author MyEclipse Persistence Tools
 */

public class SumFundOutlayDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SumFundOutlayDAO.class);
	// property constants
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
	public static final String OUTLAY_TIME = "outlayTime";

	protected void initDao() {
		// do nothing
	}

	//查询当前项目（省基金）各字段支出总和
    public List findColumnSumListByItemPK(long itempk) {
    	Session session = this.getSession();
        log.debug("finding Column Sum by itempk");
        try {
        	String queryString = "select sum(staffCost),sum(equipmentCost),sum(fuelCost)," +
        			"sum(materialCost),sum(testCost),sum(travelCost),sum(conferenceCost)," +
        			"sum(publishCost),sum(manageCost),sum(otherCost),sum(sumCost)" +
        			" from SumFundOutlay as model where model.itemPk=?";

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
	
	public void save(SumFundOutlay transientInstance) {
		log.debug("saving SumFundOutlay instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SumFundOutlay persistentInstance) {
		log.debug("deleting SumFundOutlay instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SumFundOutlay findById(java.lang.Long id) {
		log.debug("getting SumFundOutlay instance with id: " + id);
		try {
			SumFundOutlay instance = (SumFundOutlay) getHibernateTemplate()
					.get("com.stoms.model.SumFundOutlay", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SumFundOutlay instance) {
		log.debug("finding SumFundOutlay instance by example");
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
		log.debug("finding SumFundOutlay instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SumFundOutlay as model where model."
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

	public List findByStaffCost(Object staffCost) {
		return findByProperty(STAFF_COST, staffCost);
	}

	public List findByEquipmentCost(Object equipmentCost) {
		return findByProperty(EQUIPMENT_COST, equipmentCost);
	}

	public List findByFuelCost(Object fuelCost) {
		return findByProperty(FUEL_COST, fuelCost);
	}

	public List findByMaterialCost(Object materialCost) {
		return findByProperty(MATERIAL_COST, materialCost);
	}

	public List findByTestCost(Object testCost) {
		return findByProperty(TEST_COST, testCost);
	}

	public List findByTravelCost(Object travelCost) {
		return findByProperty(TRAVEL_COST, travelCost);
	}

	public List findByConferenceCost(Object conferenceCost) {
		return findByProperty(CONFERENCE_COST, conferenceCost);
	}

	public List findByPublishCost(Object publishCost) {
		return findByProperty(PUBLISH_COST, publishCost);
	}

	public List findByManageCost(Object manageCost) {
		return findByProperty(MANAGE_COST, manageCost);
	}

	public List findByOtherCost(Object otherCost) {
		return findByProperty(OTHER_COST, otherCost);
	}

	public List findBySumCost(Object sumCost) {
		return findByProperty(SUM_COST, sumCost);
	}

	public List findByOutlayTime(Object outlayTime) {
		return findByProperty(OUTLAY_TIME, outlayTime);
	}

	public List findAll() {
		log.debug("finding all SumFundOutlay instances");
		try {
			String queryString = "from SumFundOutlay";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SumFundOutlay merge(SumFundOutlay detachedInstance) {
		log.debug("merging SumFundOutlay instance");
		try {
			SumFundOutlay result = (SumFundOutlay) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SumFundOutlay instance) {
		log.debug("attaching dirty SumFundOutlay instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SumFundOutlay instance) {
		log.debug("attaching clean SumFundOutlay instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SumFundOutlayDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SumFundOutlayDAO) ctx.getBean("SumFundOutlayDAO");
	}
}