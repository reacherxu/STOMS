package com.stoms.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.ProjectType;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProjectType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.stoms.model.ProjectType
 * @author MyEclipse Persistence Tools
 */

public class ProjectTypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ProjectTypeDAO.class);
	// property constants
	public static final String TYPE_ID = "typeId";
	public static final String TYPE_NAME = "typeName";
	public static final String SUB_TYPE_ID = "subTypeId";
	public static final String SUB_TYPE_NAME = "subTypeName";
	public static final String DEPARTMENT_TYPE = "departmentType";
	public static final String PMANAGE = "pmanage";
	public static final String PMANAGE2 = "pmanage2";
	public static final String PPAY = "ppay";
	public static final String PPAY2 = "ppay2";
	public static final String PCONSULT = "pconsult";
	public static final String PACT = "pact";
	public static final String PIMPROVE = "pimprove";
	public static final String PAVAILABLE_MANAGE_CREDIT = "pavailableManageCredit";
	public static final String PDEPARTMENT_PAY = "pdepartmentPay";
	public static final String PTRAVEL_COST = "ptravelCost";
	public static final String PEXCHANGE = "pexchange";
	public static final String PEQUIPMENT = "pequipment";
	public static final String PCONFERENCE = "pconference";
	public static final String PPAY3 = "ppay3";
	public static final String PTAX1 = "ptax1";
	public static final String PTAX2 = "ptax2";
	public static final String PTAX3 = "ptax3";
	public static final String IS_TAX = "isTax";
	public static final String IS_CROSS = "isCross";
	public static final String BUDGET_TYPE = "budgetType";
	public static final String DEPARTMENT_PUBLIC = "departmentPublic";
	public static final String CO_PROJECT = "coProject";

	protected void initDao() {
		// do nothing
	}

	public void save(ProjectType transientInstance) {
		log.debug("saving ProjectType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProjectType persistentInstance) {
		log.debug("deleting ProjectType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProjectType findById(java.lang.Integer id) {
		log.debug("getting ProjectType instance with id: " + id);
		try {
			ProjectType instance = (ProjectType) getHibernateTemplate().get(
					"com.stoms.model.ProjectType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ProjectType instance) {
		log.debug("finding ProjectType instance by example");
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
		log.debug("finding ProjectType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ProjectType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTypeId(Object typeId) {
		return findByProperty(TYPE_ID, typeId);
	}

	public List findByTypeName(Object typeName) {
		return findByProperty(TYPE_NAME, typeName);
	}

	public List findBySubTypeId(Object subTypeId) {
		return findByProperty(SUB_TYPE_ID, subTypeId);
	}

	public List findBySubTypeName(Object subTypeName) {
		return findByProperty(SUB_TYPE_NAME, subTypeName);
	}

	public List findByDepartmentType(Object departmentType) {
		return findByProperty(DEPARTMENT_TYPE, departmentType);
	}

	public List findByPmanage(Object pmanage) {
		return findByProperty(PMANAGE, pmanage);
	}

	public List findByPmanage2(Object pmanage2) {
		return findByProperty(PMANAGE2, pmanage2);
	}

	public List findByPpay(Object ppay) {
		return findByProperty(PPAY, ppay);
	}

	public List findByPpay2(Object ppay2) {
		return findByProperty(PPAY2, ppay2);
	}

	public List findByPconsult(Object pconsult) {
		return findByProperty(PCONSULT, pconsult);
	}

	public List findByPact(Object pact) {
		return findByProperty(PACT, pact);
	}

	public List findByPimprove(Object pimprove) {
		return findByProperty(PIMPROVE, pimprove);
	}

	public List findByPavailableManageCredit(Object pavailableManageCredit) {
		return findByProperty(PAVAILABLE_MANAGE_CREDIT, pavailableManageCredit);
	}

	public List findByPdepartmentPay(Object pdepartmentPay) {
		return findByProperty(PDEPARTMENT_PAY, pdepartmentPay);
	}

	public List findByPtravelCost(Object ptravelCost) {
		return findByProperty(PTRAVEL_COST, ptravelCost);
	}

	public List findByPexchange(Object pexchange) {
		return findByProperty(PEXCHANGE, pexchange);
	}

	public List findByPequipment(Object pequipment) {
		return findByProperty(PEQUIPMENT, pequipment);
	}

	public List findByPconference(Object pconference) {
		return findByProperty(PCONFERENCE, pconference);
	}

	public List findByPpay3(Object ppay3) {
		return findByProperty(PPAY3, ppay3);
	}

	public List findByPtax1(Object ptax1) {
		return findByProperty(PTAX1, ptax1);
	}

	public List findByPtax2(Object ptax2) {
		return findByProperty(PTAX2, ptax2);
	}

	public List findByPtax3(Object ptax3) {
		return findByProperty(PTAX3, ptax3);
	}

	public List findByIsTax(Object isTax) {
		return findByProperty(IS_TAX, isTax);
	}

	public List findByIsCross(Object isCross) {
		return findByProperty(IS_CROSS, isCross);
	}

	public List findByBudgetType(Object budgetType) {
		return findByProperty(BUDGET_TYPE, budgetType);
	}

	public List findByDepartmentPublic(Object departmentPublic) {
		return findByProperty(DEPARTMENT_PUBLIC, departmentPublic);
	}

	public List findByCoProject(Object coProject) {
		return findByProperty(CO_PROJECT, coProject);
	}

	public List findAll() {
		log.debug("finding all ProjectType instances");
		try {
			String queryString = "from ProjectType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProjectType merge(ProjectType detachedInstance) {
		log.debug("merging ProjectType instance");
		try {
			ProjectType result = (ProjectType) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProjectType instance) {
		log.debug("attaching dirty ProjectType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProjectType instance) {
		log.debug("attaching clean ProjectType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProjectTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ProjectTypeDAO) ctx.getBean("ProjectTypeDAO");
	}
}