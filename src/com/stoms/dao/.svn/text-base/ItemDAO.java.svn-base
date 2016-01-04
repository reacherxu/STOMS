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

import com.stoms.model.Item;

/**
 	* A data access object (DAO) providing persistence and search support for Item entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.stoms.model.Item
  * @author MyEclipse Persistence Tools 
 */

public class ItemDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ItemDAO.class);
		//property constants
	public static final String ITEM_ID = "itemId";
	public static final String ITEM_NAME = "itemName";
	public static final String TYPE_ID = "typeId";
	public static final String TYPE_NAME = "typeName";
	public static final String CONTRACT_ID = "contractId";
	public static final String CREAT_ID = "creatId";
	public static final String CREAT_NAME = "creatName";
	public static final String TEACHER_ID = "teacherId";
	public static final String TEACHER_NAME = "teacherName";
	public static final String DEPARTMENT_TYPE = "departmentType";
	public static final String DEPARTMENT_ID = "departmentId";
	public static final String DEPARTMENT_NAME = "departmentName";
	public static final String ITEM_VALUE = "itemValue";
	public static final String CARD_ID = "cardId";
	public static final String REMIT_VALUE = "remitValue";
	public static final String TIME_LOWER = "timeLower";
	public static final String TIME_UPPER = "timeUpper";
	public static final String PAID_FUNDS = "paidFunds";
	public static final String APPLY_YEAR = "applyYear";
	public static final String APPLY_DATE = "applyDate";
	public static final String APPROVE_DATE = "approveDate";
	public static final String TIME_FINISH = "timeFinish";
	public static final String PROJECT_STATUS = "projectStatus";
	public static final String IS_CROSS = "isCross";
	public static final String IS_FINISHED = "isFinished";
	public static final String EVALUATE = "evaluate";
	public static final String PICTURE = "picture";
	public static final String OTHER = "other";
	public static final String OPERATOR_ID = "operatorId";



	protected void initDao() {
		//do nothing
	}
  
    //管理员功能：
	public List findItemInfoByManager2(String itemid,String contractid,String typeid,String itemname,
			String departmentid,String departmenttype,String teachername,String lowYear,String upperYear) {
		Session session = this.getSession();
	   log.debug("finding ItemInfo By Manager");
	   try {
	   	String queryString = "select model.itemPk,model.itemId,model.itemName,model.teacherName," +
	   			"model.otherTeacher,model.departmentName,model.typeId from Item as model where 1=1";
	   	
	   	if(itemid.length()!=0){
	   		queryString+=" and model.itemId='"+itemid+"'";
	   	}
	   	if(contractid.length()!=0){
	   		queryString+=" and model.contractId='"+contractid+"'";
	   	}
	   	if(typeid.length()!=0){
	   		queryString+=" and model.typeId='"+typeid+"'";
	   	}
	   	if(itemname.length()!=0){
	   		queryString+=" and model.itemName like '%"+itemname+"%'";
	   	}
	   	if(departmentid.length()!=0){
	   		queryString+=" and model.departmentId='"+departmentid+"'";
	   	}
	   	if(departmenttype.length()!=0){
	   		queryString+=" and model.departmentType='"+departmenttype+"'";
	   	}
	   	if(teachername.length()!=0){
	   		queryString+=" and model.teacherName='"+teachername+"'";
	   	}
	   	if(lowYear.length()!=0){
	   		queryString+=" and model.timeLower >'"+lowYear+"'";
	   	}
	   	if(upperYear.length()!=0){
	   		queryString+=" and model.timeUpper <'"+upperYear+"' and model.timeUpper !=''";
	   	}
	   	
	   	System.out.println("queryString:"+queryString);
	   	Query query = session.createQuery(queryString); 
	
	   	return query.list();
	   	
	   } catch (RuntimeException re) {
	      log.error("find by Dim name failed", re);
	      System.out.println(re);
	      throw re;
	   }
	   finally
	   {
	   	session.close();
	   }    	
	}	
	
	     //管理员功能：根据typepk数组，departmentpk数组，时间段，是否横向查询符合条件的item列表
    public List findItemInfoByManager(int[] typepks,int isCross,int[] departmentpks) {
    	Session session = this.getSession();
        log.debug("finding ItemInfo By Manager");
        try {
        	String queryString = "from Item as model where 1=1";
        	//typepks是或的关系
        	if (typepks!=null&&typepks.length>0) {
				for (int i = 0; i < typepks.length; i++) {
					if (i==0) {
						queryString+=" and (model.projectType.typePk="+typepks[i]+" or ";
					}
					queryString+=" model.projectType.typePk="+typepks[i]+" or ";
					if (i==typepks.length-1) {
						queryString+=" model.projectType.typePk="+typepks[i]+")";
					}
				}
			}
        	
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and model.isCross=:iscross";
				
			}
        	//departmentpks是或的关系
        	if (departmentpks!=null&&departmentpks.length>0) {
				for (int i = 0; i < departmentpks.length; i++) {
					if (i==0) {
						queryString+=" and (model.department.departmentPk="+departmentpks[i]+" or ";
					}
					queryString+=" model.department.departmentPk="+departmentpks[i]+" or ";
					if (i==departmentpks.length-1) {
						queryString+=" model.department.departmentPk="+departmentpks[i]+")";
					}
				}
			}
        	System.out.println("queryString:"+queryString);
        	Query query = session.createQuery(queryString); 
        	
        	if (isCross!=-1) {
				query.setInteger("iscross", isCross);
			}
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
	
  //查询属于teacherID和creatID的项目
    public List findbyTeacherIDandCreatID(Object value) {
        log.debug("finding Item instance with Dim: TeacherIDandCreatID"
              + ", value: " + value);
        try {
           String queryString = "from Item as model where model.teacherId=? or model.creatId=?";
  		 return getHibernateTemplate().find(queryString,value,value);
        } catch (RuntimeException re) {
           log.error("find by Dim name failed", re);
           throw re;
        }
  	}

  	//查询属于teacherID和creatID的项目,通过isCross筛选
    public List findbyTeacherIDandCreatIDWithIsCross(int isCross,Object value) {
    	Session session = this.getSession();
        log.debug("finding Item instance with Dim: TeacherIDandCreatID"
              + ", value: " + value);
        try {
        	String queryString = "from Item as model where (model.teacherId=? or model.creatId=?)";
        	if (isCross!=-1) {
				queryString+=" and model.isCross=:iscross";
				
			}
        	Query query = session.createQuery(queryString); 
        	
        	if (isCross!=-1) {
				query.setInteger("iscross", isCross);
			}
        	query.setParameter(0, value);
        	query.setParameter(1, value);
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

  //通过TeacherID查询横向项目CardID
    public List findCardIDbyTeacherID(Object value) {
        log.debug("finding Item instance with Dim: TeacherID"
              + ", value: " + value);
        try {
           String queryString = "select distinct model.cardId from Item as model where model.teacherId=? and model.isCross=1";
  		 return getHibernateTemplate().find(queryString,value);
        } catch (RuntimeException re) {
           log.error("find by Dim name failed", re);
           throw re;
        }
  	}

  //模糊查询    
    public List findByDim(String propertyName, Object value) {
        log.debug("finding Item instance with Dim: " + propertyName
              + ", value: " + value);
        try {
           String queryString = "from Item as model where model." 
           						+ propertyName + " like ?  order by model.itemPk";
  		 return getHibernateTemplate().find(queryString,value+"%");
        } catch (RuntimeException re) {
           log.error("find by Dim name failed", re);
           throw re;
        }
  	}

  //创建itemID时的模糊查询    
	public List findByItemString(Object itemId
	) {
		return findByDim(ITEM_ID, itemId
		);
	}    

   //双字段查询   
    public List findTeaIDVSProperty(String propertyName, Object value) {
        log.debug("finding Item instance with teacherID VS property: " + propertyName
              + ", value: " + value);
        try {
           String queryString = "from Item as model where (model.projectStatus=? or model.projectStatus=?) and model." 
           					 + propertyName + "= ?";
  		 return getHibernateTemplate().find(queryString, new String[]{"10","11",(String)value});
        } catch (RuntimeException re) {
           log.error("find by teacherID vs property failed", re);
           throw re;
        }
  	}

	public List findTeaIDVSproStatus(Object teacherId
	) {
		return findTeaIDVSProperty(TEACHER_ID, teacherId
		);
	}
      //管理员统计院系经费：根据departmentType，departmentpk数组，是否横向查询符合条件的item列表
    public List findSpareItemlistByManager(String departmentType,int isCross,int[] departmentpks) {
    	Session session = this.getSession();
        log.debug("finding SpareItemlist By Manager");
        try {
        	String queryString = "from Item as model where 1=1 ";
        	//判断departmentType
        	if (!departmentType.equals("") && departmentType!=null && !departmentType.equals("所有")) {
        		queryString+=" and model.departmentType='"+departmentType+"'";
			}
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and model.isCross=:iscross";
				
			}
        	//departmentpks是或的关系
        	if (departmentpks!=null&&departmentpks.length>0) {
				for (int i = 0; i < departmentpks.length; i++) {
					if (i==0) {
						queryString+=" and (model.department.departmentPk="+departmentpks[i]+" or ";
					}
					queryString+=" model.department.departmentPk="+departmentpks[i]+" or ";
					if (i==departmentpks.length-1) {
						queryString+=" model.department.departmentPk="+departmentpks[i]+")";
					}
				}
			}       	
        	Query query = session.createQuery(queryString); 
        	
        	if (isCross!=-1) {
				query.setInteger("iscross", isCross);
			}
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
        //管理员统计全校经费：根据typepks数组，是否横向查询符合条件的item列表
    public List findCampusItemlistByManager(int isCross,int[] typepks) {
    	Session session = this.getSession();
        log.debug("finding CampusItemlist By Manager");
        try {
        	String queryString = "from Item as model where 1=1 ";
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and model.isCross=:iscross";
				
			}
        	//typepks是或的关系
        	if (typepks!=null&&typepks.length>0) {
				for (int i = 0; i < typepks.length; i++) {
					if (i==0) {
						queryString+=" and (model.projectType.typePk="+typepks[i]+" or ";
					}
					queryString+=" model.projectType.typePk="+typepks[i]+" or ";
					if (i==typepks.length-1) {
						queryString+=" model.projectType.typePk="+typepks[i]+")";
					}
				}
			}
        	Query query = session.createQuery(queryString); 
        	
        	if (isCross!=-1) {
				query.setInteger("iscross", isCross);
			}
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
   //管理员统计负责人经费：根据departmentType，departmentpk数组，是否横向，项目负责人姓名查询符合条件的item列表
    public List findTeacherOulayItemlistByManager(String departmentType,int isCross,int[] departmentpks,String teacherName) {
    	Session session = this.getSession();
        log.debug("finding SpareItemlist By Manager");
        try {
        	String queryString = "from Item as model where 1=1 ";
        	//判断departmentType
        	if (!departmentType.equals("") && departmentType!=null && !departmentType.equals("所有")) {
        		queryString+=" and model.departmentType='"+departmentType+"'";
			}
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and model.isCross=:iscross";
				
			}
        	//departmentpks是或的关系
        	if (departmentpks!=null&&departmentpks.length>0) {
				for (int i = 0; i < departmentpks.length; i++) {
					if (i==0) {
						queryString+=" and (model.department.departmentPk="+departmentpks[i]+" or ";
					}
					queryString+=" model.department.departmentPk="+departmentpks[i]+" or ";
					if (i==departmentpks.length-1) {
						queryString+=" model.department.departmentPk="+departmentpks[i]+")";
					}
				}
			}
        	//判断项目负责人姓名
			if (!teacherName.equals("")) {
				queryString += " and model.teacherName like :teacherName";
			}
        	
        	Query query = session.createQuery(queryString); 
			//用第二个参数替换第一个参数所对应的变量     	
        	if (isCross!=-1) {
				query.setInteger("iscross", isCross);
			}
			if (!teacherName.equals("")) {

				query.setString("teacherName", "%" + teacherName + "%");
			}
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
  //教师端经费统计功能：查询属于teacherID和creatID的项目,通过isCross筛选
    public List findItemlistWithIsCrossAndProjectStatus(int isCross,Object value) {
    	Session session = this.getSession();
        log.debug("finding Item instance with Dim: TeacherIDandCreatID"
              + ", value: " + value);
        try {
        	String queryString = "from Item as model where (model.teacherId=? or model.creatId=?) ";
        	if (isCross!=-1) {
				queryString+=" and model.isCross=:iscross";
				
			}
        	Query query = session.createQuery(queryString); 
        	
        	if (isCross!=-1) {
				query.setInteger("iscross", isCross);
			}
        	query.setParameter(0, value);
        	query.setParameter(1, value);
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
      //管理员项目统计查询功能：根据typepk数组，departmentpk数组，是否横向查询符合条件的item列表
    public List findStatisticsItemlistByManager(int[] typepks,int isCross,int[] departmentpks) {
    	Session session = this.getSession();
        log.debug("finding StatisticsItemlist By Manager");
        try {
        	String queryString = "from Item as model where 1=1";
        	//typepks是或的关系
        	if (typepks!=null&&typepks.length>0) {
				for (int i = 0; i < typepks.length; i++) {
					if (i==0) {
						queryString+=" and (model.projectType.typePk="+typepks[i]+" or ";
					}
					queryString+=" model.projectType.typePk="+typepks[i]+" or ";
					if (i==typepks.length-1) {
						queryString+=" model.projectType.typePk="+typepks[i]+")";
					}
				}
			}
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and model.isCross=:iscross";
				
			}
        	//departmentpks是或的关系
        	if (departmentpks!=null&&departmentpks.length>0) {
				for (int i = 0; i < departmentpks.length; i++) {
					if (i==0) {
						queryString+=" and (model.department.departmentPk="+departmentpks[i]+" or ";
					}
					queryString+=" model.department.departmentPk="+departmentpks[i]+" or ";
					if (i==departmentpks.length-1) {
						queryString+=" model.department.departmentPk="+departmentpks[i]+")";
					}
				}
			}
        	
        	Query query = session.createQuery(queryString); 
        	
        	if (isCross!=-1) {
				query.setInteger("iscross", isCross);
			}
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
	
    
  	//查询项目状态为11和operatorId
    public List findByProjectStatusAndoperatorId(String operatorId) {
    	Session session = this.getSession();
        try {
        	String queryString = "from Item as model where model.projectStatus='11' and model.operatorId='" + operatorId+"'";
        	
        	Query query = session.createQuery(queryString); 
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
	
    public void save(Item transientInstance) {
        log.debug("saving Item instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Item persistentInstance) {
        log.debug("deleting Item instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Item findById( java.lang.Long id) {
        log.debug("getting Item instance with id: " + id);
        try {
            Item instance = (Item) getHibernateTemplate()
                    .get("com.stoms.model.Item", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Item instance) {
        log.debug("finding Item instance by example");
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
      log.debug("finding Item instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Item as model where model." 
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
	
	public List findByTypeId(Object typeId
	) {
		return findByProperty(TYPE_ID, typeId
		);
	}
	
	public List findByTypeName(Object typeName
	) {
		return findByProperty(TYPE_NAME, typeName
		);
	}
	
	public List findByContractId(Object contractId
	) {
		return findByProperty(CONTRACT_ID, contractId
		);
	}
	
	public List findByCreatId(Object creatId
	) {
		return findByProperty(CREAT_ID, creatId
		);
	}
	
	public List findByCreatName(Object creatName
	) {
		return findByProperty(CREAT_NAME, creatName
		);
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
	
	public List findByDepartmentType(Object departmentType
	) {
		return findByProperty(DEPARTMENT_TYPE, departmentType
		);
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
	
	public List findByItemValue(Object itemValue
	) {
		return findByProperty(ITEM_VALUE, itemValue
		);
	}
	
	public List findByCardId(Object cardId
	) {
		return findByProperty(CARD_ID, cardId
		);
	}
	
	public List findByRemitValue(Object remitValue
	) {
		return findByProperty(REMIT_VALUE, remitValue
		);
	}
	
	public List findByTimeLower(Object timeLower
	) {
		return findByProperty(TIME_LOWER, timeLower
		);
	}
	
	public List findByTimeUpper(Object timeUpper
	) {
		return findByProperty(TIME_UPPER, timeUpper
		);
	}
	
	public List findByPaidFunds(Object paidFunds
	) {
		return findByProperty(PAID_FUNDS, paidFunds
		);
	}
	
	public List findByApplyYear(Object applyYear
	) {
		return findByProperty(APPLY_YEAR, applyYear
		);
	}
	
	public List findByApplyDate(Object applyDate
	) {
		return findByProperty(APPLY_DATE, applyDate
		);
	}
	
	public List findByApproveDate(Object approveDate
	) {
		return findByProperty(APPROVE_DATE, approveDate
		);
	}
	
	public List findByTimeFinish(Object timeFinish
	) {
		return findByProperty(TIME_FINISH, timeFinish
		);
	}
	
	public List findByProjectStatus(Object projectStatus
	) {
		return findByProperty(PROJECT_STATUS, projectStatus
		);
	}
	
	public List findByIsCross(Object isCross
	) {
		return findByProperty(IS_CROSS, isCross
		);
	}
	
	public List findByIsFinished(Object isFinished
	) {
		return findByProperty(IS_FINISHED, isFinished
		);
	}
	
	public List findByEvaluate(Object evaluate
	) {
		return findByProperty(EVALUATE, evaluate
		);
	}
	
	public List findByPicture(Object picture
	) {
		return findByProperty(PICTURE, picture
		);
	}
	
	public List findByOther(Object other
	) {
		return findByProperty(OTHER, other
		);
	}
	
	public List findByOperatorId(Object operatorId
	) {
		return findByProperty(OPERATOR_ID, operatorId
		);
	}
	

	public List findAll() {
		log.debug("finding all Item instances");
		try {
			String queryString = "from Item";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Item merge(Item detachedInstance) {
        log.debug("merging Item instance");
        try {
            Item result = (Item) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Item instance) {
        log.debug("attaching dirty Item instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Item instance) {
        log.debug("attaching clean Item instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ItemDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ItemDAO) ctx.getBean("ItemDAO");
	}
}