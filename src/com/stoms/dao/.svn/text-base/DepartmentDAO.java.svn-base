package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.Department;

/**
 	* A data access object (DAO) providing persistence and search support for Department entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.Department
  * @author MyEclipse Persistence Tools 
 */

public class DepartmentDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(DepartmentDAO.class);
		//property constants
	public static final String DEPARTMENT_ID = "departmentId";
	public static final String DEPARTMENT_NAME = "departmentName";
	public static final String DEPARTMENT_TYPE = "departmentType";
	public static final String ASSISTANCE_ID = "assistanceId";
	public static final String DIRECTOR_ID = "directorId";
	public static final String ASSISTANCE_TEL = "assistanceTel";
	public static final String ASSISTANCE_MOBILE = "assistanceMobile";
	public static final String ASSISTANCE_EMAIL = "assistanceEmail";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Department transientInstance) {
        log.debug("saving Department instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Department persistentInstance) {
        log.debug("deleting Department instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Department findById( java.lang.Integer id) {
        log.debug("getting Department instance with id: " + id);
        try {
            Department instance = (Department) getHibernateTemplate()
                    .get("com.stoms.model.Department", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Department instance) {
        log.debug("finding Department instance by example");
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
      log.debug("finding Department instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Department as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDepartmentId(Object departmentId
	) {
		return findByProperty(DEPARTMENT_ID, departmentId
		);
	}
	
	public List findByDepartmentName(Object departmentName
	) {
		return findByProperty(DEPARTMENT_NAME, departmentName
		);
	}
	
	public List findByDepartmentType(Object departmentType
	) {
		return findByProperty(DEPARTMENT_TYPE, departmentType
		);
	}
	
	public List findByAssistanceId(Object assistanceId
	) {
		return findByProperty(ASSISTANCE_ID, assistanceId
		);
	}
	
	public List findByDirectorId(Object directorId
	) {
		return findByProperty(DIRECTOR_ID, directorId
		);
	}
	
	public List findByAssistanceTel(Object assistanceTel
	) {
		return findByProperty(ASSISTANCE_TEL, assistanceTel
		);
	}
	
	public List findByAssistanceMobile(Object assistanceMobile
	) {
		return findByProperty(ASSISTANCE_MOBILE, assistanceMobile
		);
	}
	
	public List findByAssistanceEmail(Object assistanceEmail
	) {
		return findByProperty(ASSISTANCE_EMAIL, assistanceEmail
		);
	}
	

	public List findAll() {
		log.debug("finding all Department instances");
		try {
			String queryString = "from Department";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Department merge(Department detachedInstance) {
        log.debug("merging Department instance");
        try {
            Department result = (Department) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Department instance) {
        log.debug("attaching dirty Department instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Department instance) {
        log.debug("attaching clean Department instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static DepartmentDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (DepartmentDAO) ctx.getBean("DepartmentDAO");
	}
}