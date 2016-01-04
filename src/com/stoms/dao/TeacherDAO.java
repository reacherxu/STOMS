package com.stoms.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.Teacher;

/**
 * A data access object (DAO) providing persistence and search support for
 * Teacher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.stoms.model.Teacher
 * @author MyEclipse Persistence Tools
 */

public class TeacherDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TeacherDAO.class);
	// property constants
	public static final String TEACHER_ID = "teacherId";
	public static final String TEACHER_NAME = "teacherName";
	public static final String TITLE_NAME = "titleName";
	public static final String DEPARTMENT_ID = "departmentId";
	public static final String DEPARTMENT_NAME = "departmentName";
	public static final String TEL = "tel";
	public static final String MOBILE = "mobile";
	public static final String EMAIL = "email";
	public static final String INDIRECT_ID = "indirectId";

	protected void initDao() {
		// do nothing
	}

//	public List findUserlist(int userType) {
//	   	Session session = this.getSession();
//        log.debug("finding Userlist By Manager");
//        try {
//        	String queryString = "select t.teacherId,t.teacherName,a.remitValue,a.outlayTime"+
//        						" from Teacher as t,TeacherLogin as l where i.itemId=a.itemId";
//
//        	
//        	//判断是否为横向项目
//        	if (isCross!=-1) {
//				queryString+=" and i.isCross=:iscross";
//				
//			}
//             //typepks是或的关系
//        	if (typepks!=null&&typepks.length>0) {
//				for (int i = 0; i < typepks.length; i++) {
//					if (i==0) {
//						queryString+=" and (i.projectType.typePk="+typepks[i]+" or ";
//					}
//					queryString+=" i.projectType.typePk="+typepks[i]+" or ";
//					if (i==typepks.length-1) {
//						queryString+=" i.projectType.typePk="+typepks[i]+")";
//					}
//				}
//			}
//
//        	
//        	Query query = session.createQuery(queryString); 
//        	      	
//        	
//        	if (isCross!=-1) {
//				query.setInteger("iscross", isCross);
//			}
//        	
//        	
//        	return query.list();
//        	
//        } catch (RuntimeException re) {
//           log.error("find by Dim name failed", re);
//           throw re;
//        }
//        finally
//        {
//        	session.close();
//        }    	
//	}
	
	
	// 通过teacherName和院系名称查询教师信息
	//20131008 add by shi
	public List findbyTeacherNameandDepartmentName(String teacherName,
			String departmentName) {
		
		Session session = this.getSession();
        try {
        	String queryString = "from Teacher as model where model.teacherName=? and model.departmentName=?";

        	Query query = session.createQuery(queryString); 

        	query.setParameter(0, teacherName);
        	query.setParameter(1, departmentName);
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
	
	  //模糊查询    
    public List findByDim(String propertyName, Object value) {
        log.debug("finding Teacher instance with Dim: " + propertyName
              + ", value: " + value);
        try {
           String queryString = "from Teacher as model where model." 
           						+ propertyName + " like ?  order by model.indirectId";
  		 return getHibernateTemplate().find(queryString,value+"%");
        } catch (RuntimeException re) {
           log.error("find by Dim name failed", re);
           throw re;
        }
  	}

  //创建indirectId时的模糊查询    
	public List findByindirectString(Object indirectId
	) {
		return findByDim(INDIRECT_ID, indirectId
		);
	}    
	
	public void save(Teacher transientInstance) {
		log.debug("saving Teacher instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teacher persistentInstance) {
		log.debug("deleting Teacher instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teacher findById(java.lang.Long id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) getHibernateTemplate().get(
					"com.stoms.model.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByExample(Teacher instance) {
		log.debug("finding Teacher instance by example");
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
		log.debug("finding Teacher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Teacher as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTeacherId(Object teacherId) {
		return findByProperty(TEACHER_ID, teacherId);
	}

	public List findByTeacherName(Object teacherName) {
		return findByProperty(TEACHER_NAME, teacherName);
	}

	public List findByTitleName(Object titleName) {
		return findByProperty(TITLE_NAME, titleName);
	}

	public List findByDepartmentId(Object departmentId) {
		return findByProperty(DEPARTMENT_ID, departmentId);
	}

	public List findByDepartmentName(Object departmentName) {
		return findByProperty(DEPARTMENT_NAME, departmentName);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByIndirectId(Object indirectId) {
		return findByProperty(INDIRECT_ID, indirectId);
	}

	public List findAll() {
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teacher merge(Teacher detachedInstance) {
		log.debug("merging Teacher instance");
		try {
			Teacher result = (Teacher) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teacher instance) {
		log.debug("attaching dirty Teacher instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teacher instance) {
		log.debug("attaching clean Teacher instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TeacherDAO) ctx.getBean("TeacherDAO");
	}
}