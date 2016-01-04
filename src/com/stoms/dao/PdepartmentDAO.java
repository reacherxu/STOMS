package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.Pdepartment;

/**
 	* A data access object (DAO) providing persistence and search support for Pdepartment entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.Pdepartment
  * @author MyEclipse Persistence Tools 
 */

public class PdepartmentDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(PdepartmentDAO.class);
		//property constants
	public static final String ITEM_ID = "itemId";
	public static final String ITEM_NAME = "itemName";
	public static final String PMANAGE = "pmanage";
	public static final String PMANAGE2 = "pmanage2";
	public static final String PPAY = "ppay";
	public static final String PPAY2 = "ppay2";
	public static final String PCONSULT = "pconsult";
	public static final String PACT = "pact";
	public static final String PIMPROVE = "pimprove";
	public static final String PAVAILABLE_MANAGE_CREDIT = "pavailableManageCredit";
	public static final String PDEPARTMENT_PAY = "pdepartmentPay";
	public static final String PPAY3 = "ppay3";
	public static final String PTAX1 = "ptax1";
	public static final String PTAX2 = "ptax2";
	public static final String PTAX3 = "ptax3";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Pdepartment transientInstance) {
        log.debug("saving Pdepartment instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Pdepartment persistentInstance) {
        log.debug("deleting Pdepartment instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Pdepartment findById( java.lang.Integer id) {
        log.debug("getting Pdepartment instance with id: " + id);
        try {
            Pdepartment instance = (Pdepartment) getHibernateTemplate()
                    .get("com.stoms.model.Pdepartment", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Pdepartment instance) {
        log.debug("finding Pdepartment instance by example");
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
      log.debug("finding Pdepartment instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Pdepartment as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByItemId(Object itemId
	) {
		return findByProperty(ITEM_ID, itemId
		);
	}
	
	public List findByItemName(Object itemName
	) {
		return findByProperty(ITEM_NAME, itemName
		);
	}
	
	public List findByPmanage(Object pmanage
	) {
		return findByProperty(PMANAGE, pmanage
		);
	}
	
	public List findByPmanage2(Object pmanage2
	) {
		return findByProperty(PMANAGE2, pmanage2
		);
	}
	
	public List findByPpay(Object ppay
	) {
		return findByProperty(PPAY, ppay
		);
	}
	
	public List findByPpay2(Object ppay2
	) {
		return findByProperty(PPAY2, ppay2
		);
	}
	
	public List findByPconsult(Object pconsult
	) {
		return findByProperty(PCONSULT, pconsult
		);
	}
	
	public List findByPact(Object pact
	) {
		return findByProperty(PACT, pact
		);
	}
	
	public List findByPimprove(Object pimprove
	) {
		return findByProperty(PIMPROVE, pimprove
		);
	}
	
	public List findByPavailableManageCredit(Object pavailableManageCredit
	) {
		return findByProperty(PAVAILABLE_MANAGE_CREDIT, pavailableManageCredit
		);
	}
	
	public List findByPdepartmentPay(Object pdepartmentPay
	) {
		return findByProperty(PDEPARTMENT_PAY, pdepartmentPay
		);
	}
	
	public List findByPpay3(Object ppay3
	) {
		return findByProperty(PPAY3, ppay3
		);
	}
	
	public List findByPtax1(Object ptax1
	) {
		return findByProperty(PTAX1, ptax1
		);
	}
	
	public List findByPtax2(Object ptax2
	) {
		return findByProperty(PTAX2, ptax2
		);
	}
	
	public List findByPtax3(Object ptax3
	) {
		return findByProperty(PTAX3, ptax3
		);
	}
	

	public List findAll() {
		log.debug("finding all Pdepartment instances");
		try {
			String queryString = "from Pdepartment";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Pdepartment merge(Pdepartment detachedInstance) {
        log.debug("merging Pdepartment instance");
        try {
            Pdepartment result = (Pdepartment) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Pdepartment instance) {
        log.debug("attaching dirty Pdepartment instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Pdepartment instance) {
        log.debug("attaching clean Pdepartment instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PdepartmentDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (PdepartmentDAO) ctx.getBean("PdepartmentDAO");
	}
}