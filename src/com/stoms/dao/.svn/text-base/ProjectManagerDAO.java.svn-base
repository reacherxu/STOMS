package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.ProjectManager;

/**
 	* A data access object (DAO) providing persistence and search support for ProjectManager entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.ProjectManager
  * @author MyEclipse Persistence Tools 
 */

public class ProjectManagerDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ProjectManagerDAO.class);
		//property constants
	public static final String ITEM_PK = "itemPk";
	public static final String ITEM_ID = "itemId";
	public static final String TEACHER_ID = "teacherId";
	public static final String TEACHER2ID = "teacher2id";
	public static final String TEACHER2NAME = "teacher2name";
	public static final String STATUS = "status";



	protected void initDao() {
		//do nothing
	}
    
    public void save(ProjectManager transientInstance) {
        log.debug("saving ProjectManager instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ProjectManager persistentInstance) {
        log.debug("deleting ProjectManager instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProjectManager findById( java.lang.Long id) {
        log.debug("getting ProjectManager instance with id: " + id);
        try {
            ProjectManager instance = (ProjectManager) getHibernateTemplate()
                    .get("com.stoms.model.ProjectManager", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ProjectManager instance) {
        log.debug("finding ProjectManager instance by example");
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
      log.debug("finding ProjectManager instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProjectManager as model where model." 
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
	
	public List findByTeacherId(Object teacherId
	) {
		return findByProperty(TEACHER_ID, teacherId
		);
	}
	
	public List findByTeacher2id(Object teacher2id
	) {
		return findByProperty(TEACHER2ID, teacher2id
		);
	}
	
	public List findByTeacher2name(Object teacher2name
	) {
		return findByProperty(TEACHER2NAME, teacher2name
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	

	public List findAll() {
		log.debug("finding all ProjectManager instances");
		try {
			String queryString = "from ProjectManager";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProjectManager merge(ProjectManager detachedInstance) {
        log.debug("merging ProjectManager instance");
        try {
            ProjectManager result = (ProjectManager) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProjectManager instance) {
        log.debug("attaching dirty ProjectManager instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProjectManager instance) {
        log.debug("attaching clean ProjectManager instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ProjectManagerDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ProjectManagerDAO) ctx.getBean("ProjectManagerDAO");
	}
}