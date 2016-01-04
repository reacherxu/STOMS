package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.Budget;

/**
 * A data access object (DAO) providing persistence and search support for
 * Budget entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.stoms.model.Budget
 * @author MyEclipse Persistence Tools
 */

public class BudgetDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BudgetDAO.class);
	// property constants
	public static final String CONTRACT_ID = "contractId";
	public static final String MANAGER = "manager";
	public static final String STUDY_OUTLAY = "studyOutlay";
	public static final String STUDY_OUTLAY_SR = "studyOutlaySr";
	public static final String STUDY_OUTLAY_SR_TEST = "studyOutlaySrTest";
	public static final String STUDY_OUTLAY_SR_ENERGY = "studyOutlaySrEnergy";
	public static final String STUDY_OUTLAY_SR_MEETING = "studyOutlaySrMeeting";
	public static final String STUDY_OUTLAY_SR_PUBLISH = "studyOutlaySrPublish";
	public static final String STUDY_OUTLAY_SR_OTHER = "studyOutlaySrOther";
	public static final String STUDY_OUTLAY_EM = "studyOutlayEm";
	public static final String STUDY_OUTLAY_EM_MATERIAL = "studyOutlayEmMaterial";
	public static final String STUDY_OUTLAY_EM_OTHER = "studyOutlayEmOther";
	public static final String STUDY_OUTLAY_EI = "studyOutlayEi";
	public static final String STUDY_OUTLAY_EI_PURCHASE = "studyOutlayEiPurchase";
	public static final String STUDY_OUTLAY_EI_PRODUCE = "studyOutlayEiProduce";
	public static final String STUDY_OUTLAY_LR = "studyOutlayLr";
	public static final String STUDY_OUTLAY_COLABORATE = "studyOutlayColaborate";
	public static final String INTERNATIONAL = "international";
	public static final String INTERNATIONAL1 = "international1";
	public static final String INTERNATIONAL2 = "international2";
	public static final String SERVICE = "service";
	public static final String MANAGEMENT = "management";
	public static final String SUM = "sum";

	protected void initDao() {
		// do nothing
	}

	public void save(Budget transientInstance) {
		log.debug("saving Budget instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Budget persistentInstance) {
		log.debug("deleting Budget instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Budget findById(java.lang.Integer id) {
		log.debug("getting Budget instance with id: " + id);
		try {
			Budget instance = (Budget) getHibernateTemplate().get(
					"com.stoms.model.Budget", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Budget instance) {
		log.debug("finding Budget instance by example");
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
		log.debug("finding Budget instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Budget as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContractId(Object contractId) {
		return findByProperty(CONTRACT_ID, contractId);
	}

	public List findByManager(Object manager) {
		return findByProperty(MANAGER, manager);
	}

	public List findByStudyOutlay(Object studyOutlay) {
		return findByProperty(STUDY_OUTLAY, studyOutlay);
	}

	public List findByStudyOutlaySr(Object studyOutlaySr) {
		return findByProperty(STUDY_OUTLAY_SR, studyOutlaySr);
	}

	public List findByStudyOutlaySrTest(Object studyOutlaySrTest) {
		return findByProperty(STUDY_OUTLAY_SR_TEST, studyOutlaySrTest);
	}

	public List findByStudyOutlaySrEnergy(Object studyOutlaySrEnergy) {
		return findByProperty(STUDY_OUTLAY_SR_ENERGY, studyOutlaySrEnergy);
	}

	public List findByStudyOutlaySrMeeting(Object studyOutlaySrMeeting) {
		return findByProperty(STUDY_OUTLAY_SR_MEETING, studyOutlaySrMeeting);
	}

	public List findByStudyOutlaySrPublish(Object studyOutlaySrPublish) {
		return findByProperty(STUDY_OUTLAY_SR_PUBLISH, studyOutlaySrPublish);
	}

	public List findByStudyOutlaySrOther(Object studyOutlaySrOther) {
		return findByProperty(STUDY_OUTLAY_SR_OTHER, studyOutlaySrOther);
	}

	public List findByStudyOutlayEm(Object studyOutlayEm) {
		return findByProperty(STUDY_OUTLAY_EM, studyOutlayEm);
	}

	public List findByStudyOutlayEmMaterial(Object studyOutlayEmMaterial) {
		return findByProperty(STUDY_OUTLAY_EM_MATERIAL, studyOutlayEmMaterial);
	}

	public List findByStudyOutlayEmOther(Object studyOutlayEmOther) {
		return findByProperty(STUDY_OUTLAY_EM_OTHER, studyOutlayEmOther);
	}

	public List findByStudyOutlayEi(Object studyOutlayEi) {
		return findByProperty(STUDY_OUTLAY_EI, studyOutlayEi);
	}

	public List findByStudyOutlayEiPurchase(Object studyOutlayEiPurchase) {
		return findByProperty(STUDY_OUTLAY_EI_PURCHASE, studyOutlayEiPurchase);
	}

	public List findByStudyOutlayEiProduce(Object studyOutlayEiProduce) {
		return findByProperty(STUDY_OUTLAY_EI_PRODUCE, studyOutlayEiProduce);
	}

	public List findByStudyOutlayLr(Object studyOutlayLr) {
		return findByProperty(STUDY_OUTLAY_LR, studyOutlayLr);
	}

	public List findByStudyOutlayColaborate(Object studyOutlayColaborate) {
		return findByProperty(STUDY_OUTLAY_COLABORATE, studyOutlayColaborate);
	}

	public List findByInternational(Object international) {
		return findByProperty(INTERNATIONAL, international);
	}

	public List findByInternational1(Object international1) {
		return findByProperty(INTERNATIONAL1, international1);
	}

	public List findByInternational2(Object international2) {
		return findByProperty(INTERNATIONAL2, international2);
	}

	public List findByService(Object service) {
		return findByProperty(SERVICE, service);
	}

	public List findByManagement(Object management) {
		return findByProperty(MANAGEMENT, management);
	}

	public List findBySum(Object sum) {
		return findByProperty(SUM, sum);
	}

	public List findAll() {
		log.debug("finding all Budget instances");
		try {
			String queryString = "from Budget";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Budget merge(Budget detachedInstance) {
		log.debug("merging Budget instance");
		try {
			Budget result = (Budget) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Budget instance) {
		log.debug("attaching dirty Budget instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Budget instance) {
		log.debug("attaching clean Budget instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BudgetDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BudgetDAO) ctx.getBean("BudgetDAO");
	}
}