package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.TeacherTitle;

/**
 	* A data access object (DAO) providing persistence and search support for TeacherTitle entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.TeacherTitle
  * @author MyEclipse Persistence Tools 
 */

public class TeacherTitleDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(TeacherTitleDAO.class);
		//property constants
	public static final String TITLE_NAME = "titleName";



	protected void initDao() {
		//do nothing
	}
    
    public void save(TeacherTitle transientInstance) {
        log.debug("saving TeacherTitle instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TeacherTitle persistentInstance) {
        log.debug("deleting TeacherTitle instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TeacherTitle findById( java.lang.Integer id) {
        log.debug("getting TeacherTitle instance with id: " + id);
        try {
            TeacherTitle instance = (TeacherTitle) getHibernateTemplate()
                    .get("com.stoms.model.TeacherTitle", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TeacherTitle instance) {
        log.debug("finding TeacherTitle instance by example");
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
      log.debug("finding TeacherTitle instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TeacherTitle as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTitleName(Object titleName
	) {
		return findByProperty(TITLE_NAME, titleName
		);
	}
	

	public List findAll() {
		log.debug("finding all TeacherTitle instances");
		try {
			String queryString = "from TeacherTitle";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TeacherTitle merge(TeacherTitle detachedInstance) {
        log.debug("merging TeacherTitle instance");
        try {
            TeacherTitle result = (TeacherTitle) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TeacherTitle instance) {
        log.debug("attaching dirty TeacherTitle instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TeacherTitle instance) {
        log.debug("attaching clean TeacherTitle instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TeacherTitleDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TeacherTitleDAO) ctx.getBean("TeacherTitleDAO");
	}
}