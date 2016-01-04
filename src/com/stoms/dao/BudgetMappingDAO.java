package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.BudgetMapping;

/**
 * A data access object (DAO) providing persistence and search support for
 * BudgetMapping entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.BudgetMapping
 * @author MyEclipse Persistence Tools
 */

public class BudgetMappingDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BudgetMappingDAO.class);
	// property constants
	public static final String PROJECT_ID = "projectId";
	public static final String MANAGER = "manager";
	public static final String RESEARCH = "research";
	public static final String SRBUSINESS = "srbusiness";
	public static final String TEST = "test";
	public static final String ENERGY = "energy";
	public static final String MEETINGS = "meetings";
	public static final String PUBLISHMENTS = "publishments";
	public static final String OTHER_SRBUSINESS = "otherSrbusiness";
	public static final String EXPERIMENT_MATERIAL = "experimentMaterial";
	public static final String RAW_MATERIAL = "rawMaterial";
	public static final String OTHER_MATERIAL = "otherMaterial";
	public static final String EQUIPMENT = "equipment";
	public static final String EQUIPMENT_PURCHASE = "equipmentPurchase";
	public static final String EQUIPMENT_PRODUCE = "equipmentProduce";
	public static final String LAB_RECONSTRUCTION = "labReconstruction";
	public static final String COLLABORATION = "collaboration";
	public static final String INTERNATIONAL_COMMUNICATION = "internationalCommunication";
	public static final String EXPORT_COMMUNICATION = "exportCommunication";
	public static final String IMPORT_COMMUNICATION = "importCommunication";
	public static final String LABOUR = "labour";
	public static final String MANAGEMENT = "management";

	protected void initDao() {
		// do nothing
	}

	public void save(BudgetMapping transientInstance) {
		log.debug("saving BudgetMapping instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BudgetMapping persistentInstance) {
		log.debug("deleting BudgetMapping instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BudgetMapping findById(java.lang.Integer id) {
		log.debug("getting BudgetMapping instance with id: " + id);
		try {
			BudgetMapping instance = (BudgetMapping) getHibernateTemplate()
					.get("com.stoms.model.BudgetMapping", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BudgetMapping instance) {
		log.debug("finding BudgetMapping instance by example");
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
		log.debug("finding BudgetMapping instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BudgetMapping as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProjectId(Object projectId) {
		return findByProperty(PROJECT_ID, projectId);
	}

	public List findByManager(Object manager) {
		return findByProperty(MANAGER, manager);
	}

	public List findByResearch(Object research) {
		return findByProperty(RESEARCH, research);
	}

	public List findBySrbusiness(Object srbusiness) {
		return findByProperty(SRBUSINESS, srbusiness);
	}

	public List findByTest(Object test) {
		return findByProperty(TEST, test);
	}

	public List findByEnergy(Object energy) {
		return findByProperty(ENERGY, energy);
	}

	public List findByMeetings(Object meetings) {
		return findByProperty(MEETINGS, meetings);
	}

	public List findByPublishments(Object publishments) {
		return findByProperty(PUBLISHMENTS, publishments);
	}

	public List findByOtherSrbusiness(Object otherSrbusiness) {
		return findByProperty(OTHER_SRBUSINESS, otherSrbusiness);
	}

	public List findByExperimentMaterial(Object experimentMaterial) {
		return findByProperty(EXPERIMENT_MATERIAL, experimentMaterial);
	}

	public List findByRawMaterial(Object rawMaterial) {
		return findByProperty(RAW_MATERIAL, rawMaterial);
	}

	public List findByOtherMaterial(Object otherMaterial) {
		return findByProperty(OTHER_MATERIAL, otherMaterial);
	}

	public List findByEquipment(Object equipment) {
		return findByProperty(EQUIPMENT, equipment);
	}

	public List findByEquipmentPurchase(Object equipmentPurchase) {
		return findByProperty(EQUIPMENT_PURCHASE, equipmentPurchase);
	}

	public List findByEquipmentProduce(Object equipmentProduce) {
		return findByProperty(EQUIPMENT_PRODUCE, equipmentProduce);
	}

	public List findByLabReconstruction(Object labReconstruction) {
		return findByProperty(LAB_RECONSTRUCTION, labReconstruction);
	}

	public List findByCollaboration(Object collaboration) {
		return findByProperty(COLLABORATION, collaboration);
	}

	public List findByInternationalCommunication(
			Object internationalCommunication) {
		return findByProperty(INTERNATIONAL_COMMUNICATION,
				internationalCommunication);
	}

	public List findByExportCommunication(Object exportCommunication) {
		return findByProperty(EXPORT_COMMUNICATION, exportCommunication);
	}

	public List findByImportCommunication(Object importCommunication) {
		return findByProperty(IMPORT_COMMUNICATION, importCommunication);
	}

	public List findByLabour(Object labour) {
		return findByProperty(LABOUR, labour);
	}

	public List findByManagement(Object management) {
		return findByProperty(MANAGEMENT, management);
	}

	public List findAll() {
		log.debug("finding all BudgetMapping instances");
		try {
			String queryString = "from BudgetMapping";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BudgetMapping merge(BudgetMapping detachedInstance) {
		log.debug("merging BudgetMapping instance");
		try {
			BudgetMapping result = (BudgetMapping) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BudgetMapping instance) {
		log.debug("attaching dirty BudgetMapping instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BudgetMapping instance) {
		log.debug("attaching clean BudgetMapping instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BudgetMappingDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (BudgetMappingDAO) ctx.getBean("BudgetMappingDAO");
	}
}