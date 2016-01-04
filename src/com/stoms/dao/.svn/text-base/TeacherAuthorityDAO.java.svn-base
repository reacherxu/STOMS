package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.TeacherAuthority;

/**
 	* A data access object (DAO) providing persistence and search support for TeacherAuthority entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.TeacherAuthority
  * @author MyEclipse Persistence Tools 
 */

public class TeacherAuthorityDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(TeacherAuthorityDAO.class);
		//property constants
	public static final String TEACHER_ID = "teacherId";
	public static final String TEACHER_NAME = "teacherName";
	public static final String AUTHORIZED_ID = "authorizedId";
	public static final String AUTHORIZED_NAME = "authorizedName";



	protected void initDao() {
		//do nothing
	}
    
    public void save(TeacherAuthority transientInstance) {
        log.debug("saving TeacherAuthority instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TeacherAuthority persistentInstance) {
        log.debug("deleting TeacherAuthority instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TeacherAuthority findById( java.lang.Long id) {
        log.debug("getting TeacherAuthority instance with id: " + id);
        try {
            TeacherAuthority instance = (TeacherAuthority) getHibernateTemplate()
                    .get("com.stoms.model.TeacherAuthority", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TeacherAuthority instance) {
        log.debug("finding TeacherAuthority instance by example");
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
      log.debug("finding TeacherAuthority instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TeacherAuthority as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTeacherId(Object teacherId
	) {
		return findByProperty(TEACHER_ID, teacherId
		);
	}
	
	public List findByTeacherName(Object teacherName
	) {
		return findByProperty(TEACHER_NAME, teacherName
		);
	}
	
	public List findByAuthorizedId(Object authorizedId
	) {
		return findByProperty(AUTHORIZED_ID, authorizedId
		);
	}
	
	public List findByAuthorizedName(Object authorizedName
	) {
		return findByProperty(AUTHORIZED_NAME, authorizedName
		);
	}
	

	public List findAll() {
		log.debug("finding all TeacherAuthority instances");
		try {
			String queryString = "from TeacherAuthority";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TeacherAuthority merge(TeacherAuthority detachedInstance) {
        log.debug("merging TeacherAuthority instance");
        try {
            TeacherAuthority result = (TeacherAuthority) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TeacherAuthority instance) {
        log.debug("attaching dirty TeacherAuthority instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TeacherAuthority instance) {
        log.debug("attaching clean TeacherAuthority instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TeacherAuthorityDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TeacherAuthorityDAO) ctx.getBean("TeacherAuthorityDAO");
	}
}