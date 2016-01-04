package com.stoms.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.AddOutlay;

/**
 * A data access object (DAO) providing persistence and search support for
 * AddOutlay entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.stoms.model.AddOutlay
 * @author MyEclipse Persistence Tools
 */

public class AddOutlayDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AddOutlayDAO.class);
	// property constants
	public static final String ITEM_ID = "itemId";
	public static final String CONTRACT_ID = "contractId";
	public static final String ITEM_NAME = "itemName";
	public static final String OUTLAY_DEPARTMENT = "outlayDepartment";
	public static final String TYPE_PK = "typePk";
	public static final String TYPE_ID = "typeId";
	public static final String TYPE_NAME = "typeName";
	public static final String TEACHER_NAME = "teacherName";
	public static final String OTHER_TEACHER = "otherTeacher";
	public static final String DEPARTMENT_ID = "departmentId";
	public static final String DEPARTMENT_NAME = "departmentName";
	public static final String DEPARTMENT_TYPE = "departmentType";
	public static final String CARD_ID = "cardId";
	public static final String BANK_ID = "bankId";
	public static final String OUTLAY_VALUE = "outlayValue";
	public static final String REMIT_VALUE = "remitValue";
	public static final String OTHER = "other";
	public static final String MANAGE = "manage";
	public static final String MANAGE2 = "manage2";
	public static final String PAY2 = "pay2";
	public static final String PAY = "pay";
	public static final String ACT = "act";
	public static final String IMPROVE = "improve";
	public static final String CONSULT = "consult";
	public static final String AVAILABLE_MANAGE_CREDIT = "availableManageCredit";
	public static final String TRAVEL_COST = "travelCost";
	public static final String EXCHANGE = "exchange";
	public static final String EQUIPMENT = "equipment";
	public static final String CONFERENCE = "conference";
	public static final String DEPARTMENT_PUBLIC = "departmentPublic";
	public static final String CO_PROJECT = "coProject";
	public static final String PERFORMANCE1 = "performance1";
	public static final String PERFORMANCE2 = "performance2";
	public static final String SUMONE = "sumone";
	public static final String SUMTWO = "sumtwo";
	public static final String SUMTHREE = "sumthree";
	public static final String IS_CROSS = "isCross";
	public static final String DEPARTMENT_PAY = "departmentPay";
	public static final String PAY3 = "pay3";
	public static final String TAX1 = "tax1";
	public static final String TAX2 = "tax2";
	public static final String TAX3 = "tax3";
	public static final String IS_TAX = "isTax";
	public static final String IS_INVOICE = "isInvoice";
	public static final String INVOICE_TITLE = "invoiceTitle";
	public static final String INVOICE_DETAIL = "invoiceDetail";
	public static final String IS_FIRST_OUTLAY = "isFirstOutlay";
	public static final String IS_MARK = "isMark";
	public static final String OUTLAY_TIME = "outlayTime";
	public static final String PICTURE = "picture";
	public static final String REMARK = "remark";
	public static final String ASTATUS = "astatus";
	public static final String DIRECT_VALUE = "directValue";
	public static final String INDIRECT_VALUE = "indirectValue";
	public static final String PERFORMANCE = "performance";
	public static final String OPERATOR_ID = "operatorId";

	protected void initDao() {
		// do nothing
	}
	
	public List addoutlayQuery(String itemId,double outlayValue,double remitValue,int isCross,
			String outlayDepartment,String teacherName,String departmentId, String departmentType,
			String lowYear,String upperYear) {
		Session session = this.getSession();
	   log.debug("finding addoutlayInfo By Manager");
	   try {
	   	String queryString = "from AddOutlay as model where 1=1";
	   	
	   	if(itemId.length()!=0){
	   		queryString+=" and model.itemId='"+itemId+"'";
	   	}
	   	if(outlayValue != 0){
	   		queryString+=" and model.outlayValue="+outlayValue+"";
	   	}
	   	if(remitValue !=0){
	   		queryString+=" and model.remitValue="+remitValue+"";
	   	}
	   	if(isCross != 2){
	   		queryString+=" and model.isCross="+isCross+"";
	   	}
	   	if(outlayDepartment.length() !=0){
	   		queryString+=" and model.outlayDepartment like '%"+outlayDepartment+"%'";
	   	}
	   	if(teacherName.length()!=0){
	   		queryString+=" and model.teacherName='"+teacherName+"'";
	   	}
	   	if(departmentId.length()!=0){
	   		queryString+=" and model.departmentId='"+departmentId+"'";
	   	}
	   	if(departmentType.length()!=0){
	   		queryString+=" and model.departmentType='"+departmentType+"'";
	   	}
	   	if(lowYear.length()!=0){
	   		queryString+=" and model.outlayTime >='"+lowYear+"' and model.outlayTime !=''";
	   	}
	   	if(upperYear.length()!=0){
	   		queryString+=" and model.outlayTime <='"+upperYear+"' and model.outlayTime !=''";
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

	//管理员端查询经费功能：item表和addoutlay表联合查询（项目代码，项目名称，项目类型，是否横向，
	//项目负责人，院系，经费卡号，合同编号，来款金额，汇出金额，来款单位，是否开票，项目时间范围，入账时间）
	public List findByItemAndAddOutlay(String itemName,String teacherName,String cardId,
			String itemId,String contractId,String outlayDepartment,int isInvoice,
			int isCross,int[] typepks,int[] departmentpks) {
	   	Session session = this.getSession();
        log.debug("finding StatisticsItemlist By Manager");
        try {
        	String queryString = "select i.itemId,i.itemName,i.typeName,i.isCross,i.teacherName,"+
        						"i.departmentName,a.id,a.cardId,i.contractId,a.outlayValue,a.remitValue,"+
        						"a.outlayDepartment,a.isInvoice,i.timeLower,i.timeUpper,a.outlayTime,a.astatus"+
        						" from Item as i,AddOutlay as a where i.itemId=a.itemId";

			if (!itemName.equals("")&&itemName!=null) {
				queryString += " and i.itemName like :itemName";
			}			
			if (!teacherName.equals("")&&teacherName!=null) {
				queryString += " and i.teacherName like :teacherName";
			}
        	if (!cardId.equals("")&&cardId!=null) {
        		queryString += " and i.cardId='"+cardId+"'";
			}
        	if (!contractId.equals("")&&contractId!=null) {
        		queryString += " and i.contractId='"+contractId+"'";
			}
			if (!outlayDepartment.equals("")&&outlayDepartment!=null) {
				queryString += " and a.outlayDepartment like :outlayDepartment";
			}
			if (isInvoice==1) {
				queryString += " and a.isInvoice=1";
			}
			if (!itemId.equals("")&&itemId!=null) {
				queryString += " and i.itemId='"+itemId+"'";
			}
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and i.isCross=:iscross";
				
			}
//typepks是或的关系
        	if (typepks!=null&&typepks.length>0) {
				for (int i = 0; i < typepks.length; i++) {
					if (i==0) {
						queryString+=" and (i.projectType.typePk="+typepks[i]+" or ";
					}
					queryString+=" i.projectType.typePk="+typepks[i]+" or ";
					if (i==typepks.length-1) {
						queryString+=" i.projectType.typePk="+typepks[i]+")";
					}
				}
			}

        	//departmentpks是或的关系
        	if (departmentpks!=null&&departmentpks.length>0) {
				for (int i = 0; i < departmentpks.length; i++) {
					if (i==0) {
						queryString+=" and (i.department.departmentPk="+departmentpks[i]+" or ";
					}
					queryString+=" i.department.departmentPk="+departmentpks[i]+" or ";
					if (i==departmentpks.length-1) {
						queryString+=" i.department.departmentPk="+departmentpks[i]+")";
					}
				}
			}
        	
        	Query query = session.createQuery(queryString); 
        	

			if (!itemName.equals("")&&itemName!=null) {

				query.setString("itemName", "%" + itemName + "%");
			}
			if (!teacherName.equals("")&&teacherName!=null) {

				query.setString("teacherName", "%" + teacherName + "%");
			}
			if (!outlayDepartment.equals("")&&outlayDepartment!=null) {

				query.setString("outlayDepartment", "%" + outlayDepartment + "%");
			}
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
	
   //管理员校级经费统计：AddOutlay的typepk和item表的iscross联合查询
	public List findStatisticsCampus(int isCross,int[] typepks) {
	   	Session session = this.getSession();
        log.debug("finding StatisticsItemlist By Manager");
        try {
        	String queryString = "select i.itemId,a.outlayValue,a.remitValue,a.outlayTime"+
        						" from Item as i,AddOutlay as a where i.itemId=a.itemId";

        	
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and i.isCross=:iscross";
				
			}
             //typepks是或的关系
        	if (typepks!=null&&typepks.length>0) {
				for (int i = 0; i < typepks.length; i++) {
					if (i==0) {
						queryString+=" and (i.projectType.typePk="+typepks[i]+" or ";
					}
					queryString+=" i.projectType.typePk="+typepks[i]+" or ";
					if (i==typepks.length-1) {
						queryString+=" i.projectType.typePk="+typepks[i]+")";
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
	
	
   //管理员院系级经费统计：AddOutlay和item表的iscross联合查询
	public List findStatisticsDepartment(int isCross,String departmenttype,int departmentpk) {
	   	Session session = this.getSession();
        log.debug("finding StatisticsItemlist By Manager");
        try {
        	String queryString = "select a.outlayValue,a.remitValue,a.outlayTime,i.department.departmentName"+
        						" from Item as i,AddOutlay as a where i.itemId=a.itemId";

        	
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and i.isCross=:iscross";
				
			}
        	
        	//筛选院系
			queryString+=" and i.department.departmentPk=:departmentpk";
  	
        	
        	      	
        	//判断departmentType
        	if (!departmenttype.equals("") && departmenttype!=null && !departmenttype.equals("所有")) {
        		queryString+=" and a.departmentType='"+departmenttype+"'";
        	}
        		
        	Query query = session.createQuery(queryString); 
        	if (isCross!=-1) {
				query.setInteger("iscross", isCross);
			}
        	query.setInteger("departmentpk", departmentpk);
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
	
	
   //管理员教师级经费统计：AddOutlay和item表联合查询
	public List findStatisticsTeacher(int isCross,String departmenttype,int[] departmentpks,String teacherName) 

{
	   	Session session = this.getSession();
        log.debug("finding StatisticsItemlist By Manager");
        try {
        	String queryString = "select a.outlayValue,a.remitValue,a.outlayTime,i.teacherName,i.department.departmentName"+
        						" from Item as i,AddOutlay as a where i.itemId=a.itemId";

        	
        	//判断是否为横向项目
        	if (isCross!=-1) {
				queryString+=" and i.isCross=:iscross";
				
			}
        	
        	//departmentpks是或的关系
        	if (departmentpks!=null&&departmentpks.length>0) {
				for (int i = 0; i < departmentpks.length; i++) {
					if (i==0) {
						queryString+=" and (i.department.departmentPk="+departmentpks[i]+" or ";
					}
					queryString+=" i.department.departmentPk="+departmentpks[i]+" or ";
					if (i==departmentpks.length-1) {
						queryString+=" i.department.departmentPk="+departmentpks[i]+")";
					}
				}
			}
  	
        	
        	      	
        	//判断departmentType
        	if (!departmenttype.equals("") && departmenttype!=null && !departmenttype.equals("所有")) {
        		queryString+=" and a.departmentType='"+departmenttype+"'";
        	}
        		
        	//判断项目负责人姓名
			if (!teacherName.equals("")) {
				queryString += " and i.teacherName like :teacherName";
			}
        	
        	Query query = session.createQuery(queryString); 
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
	
  	//查询入账状态为11和operatorId
    public List findByProjectStatusAndoperatorId(String operatorId) {
    	Session session = this.getSession();
        try {
        	String queryString = "from AddOutlay as model where model.astatus='11' and model.operatorId='" + operatorId+"'";
        	
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
	
	
	public void save(AddOutlay transientInstance) {
		log.debug("saving AddOutlay instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AddOutlay persistentInstance) {
		log.debug("deleting AddOutlay instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AddOutlay findById(java.lang.Long id) {
		log.debug("getting AddOutlay instance with id: " + id);
		try {
			AddOutlay instance = (AddOutlay) getHibernateTemplate().get(
					"com.stoms.model.AddOutlay", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AddOutlay instance) {
		log.debug("finding AddOutlay instance by example");
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
		log.debug("finding AddOutlay instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AddOutlay as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItemId(Object itemId) {
		return findByProperty(ITEM_ID, itemId);
	}

	public List findByContractId(Object contractId) {
		return findByProperty(CONTRACT_ID, contractId);
	}

	public List findByItemName(Object itemName) {
		return findByProperty(ITEM_NAME, itemName);
	}

	public List findByOutlayDepartment(Object outlayDepartment) {
		return findByProperty(OUTLAY_DEPARTMENT, outlayDepartment);
	}

	public List findByTypePk(Object typePk) {
		return findByProperty(TYPE_PK, typePk);
	}

	public List findByTypeId(Object typeId) {
		return findByProperty(TYPE_ID, typeId);
	}

	public List findByTypeName(Object typeName) {
		return findByProperty(TYPE_NAME, typeName);
	}

	public List findByTeacherName(Object teacherName) {
		return findByProperty(TEACHER_NAME, teacherName);
	}

	public List findByOtherTeacher(Object otherTeacher) {
		return findByProperty(OTHER_TEACHER, otherTeacher);
	}

	public List findByDepartmentId(Object departmentId) {
		return findByProperty(DEPARTMENT_ID, departmentId);
	}

	public List findByDepartmentName(Object departmentName) {
		return findByProperty(DEPARTMENT_NAME, departmentName);
	}

	public List findByDepartmentType(Object departmentType) {
		return findByProperty(DEPARTMENT_TYPE, departmentType);
	}

	public List findByCardId(Object cardId) {
		return findByProperty(CARD_ID, cardId);
	}

	public List findByBankId(Object bankId) {
		return findByProperty(BANK_ID, bankId);
	}

	public List findByOutlayValue(Object outlayValue) {
		return findByProperty(OUTLAY_VALUE, outlayValue);
	}

	public List findByRemitValue(Object remitValue) {
		return findByProperty(REMIT_VALUE, remitValue);
	}

	public List findByOther(Object other) {
		return findByProperty(OTHER, other);
	}

	public List findByManage(Object manage) {
		return findByProperty(MANAGE, manage);
	}

	public List findByManage2(Object manage2) {
		return findByProperty(MANAGE2, manage2);
	}

	public List findByPay2(Object pay2) {
		return findByProperty(PAY2, pay2);
	}

	public List findByPay(Object pay) {
		return findByProperty(PAY, pay);
	}

	public List findByAct(Object act) {
		return findByProperty(ACT, act);
	}

	public List findByImprove(Object improve) {
		return findByProperty(IMPROVE, improve);
	}

	public List findByConsult(Object consult) {
		return findByProperty(CONSULT, consult);
	}

	public List findByAvailableManageCredit(Object availableManageCredit) {
		return findByProperty(AVAILABLE_MANAGE_CREDIT, availableManageCredit);
	}

	public List findByTravelCost(Object travelCost) {
		return findByProperty(TRAVEL_COST, travelCost);
	}

	public List findByExchange(Object exchange) {
		return findByProperty(EXCHANGE, exchange);
	}

	public List findByEquipment(Object equipment) {
		return findByProperty(EQUIPMENT, equipment);
	}

	public List findByConference(Object conference) {
		return findByProperty(CONFERENCE, conference);
	}

	public List findByDepartmentPublic(Object departmentPublic) {
		return findByProperty(DEPARTMENT_PUBLIC, departmentPublic);
	}

	public List findByCoProject(Object coProject) {
		return findByProperty(CO_PROJECT, coProject);
	}

	public List findByPerformance1(Object performance1) {
		return findByProperty(PERFORMANCE1, performance1);
	}

	public List findByPerformance2(Object performance2) {
		return findByProperty(PERFORMANCE2, performance2);
	}

	public List findBySumone(Object sumone) {
		return findByProperty(SUMONE, sumone);
	}

	public List findBySumtwo(Object sumtwo) {
		return findByProperty(SUMTWO, sumtwo);
	}

	public List findBySumthree(Object sumthree) {
		return findByProperty(SUMTHREE, sumthree);
	}

	public List findByIsCross(Object isCross) {
		return findByProperty(IS_CROSS, isCross);
	}

	public List findByDepartmentPay(Object departmentPay) {
		return findByProperty(DEPARTMENT_PAY, departmentPay);
	}

	public List findByPay3(Object pay3) {
		return findByProperty(PAY3, pay3);
	}

	public List findByTax1(Object tax1) {
		return findByProperty(TAX1, tax1);
	}

	public List findByTax2(Object tax2) {
		return findByProperty(TAX2, tax2);
	}

	public List findByTax3(Object tax3) {
		return findByProperty(TAX3, tax3);
	}

	public List findByIsTax(Object isTax) {
		return findByProperty(IS_TAX, isTax);
	}

	public List findByIsInvoice(Object isInvoice) {
		return findByProperty(IS_INVOICE, isInvoice);
	}

	public List findByInvoiceTitle(Object invoiceTitle) {
		return findByProperty(INVOICE_TITLE, invoiceTitle);
	}

	public List findByInvoiceDetail(Object invoiceDetail) {
		return findByProperty(INVOICE_DETAIL, invoiceDetail);
	}

	public List findByIsFirstOutlay(Object isFirstOutlay) {
		return findByProperty(IS_FIRST_OUTLAY, isFirstOutlay);
	}

	public List findByIsMark(Object isMark) {
		return findByProperty(IS_MARK, isMark);
	}

	public List findByOutlayTime(Object outlayTime) {
		return findByProperty(OUTLAY_TIME, outlayTime);
	}

	public List findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByAstatus(Object astatus) {
		return findByProperty(ASTATUS, astatus);
	}

	public List findByDirectValue(Object directValue) {
		return findByProperty(DIRECT_VALUE, directValue);
	}

	public List findByIndirectValue(Object indirectValue) {
		return findByProperty(INDIRECT_VALUE, indirectValue);
	}

	public List findByPerformance(Object performance) {
		return findByProperty(PERFORMANCE, performance);
	}

	public List findByOperatorId(Object operatorId) {
		return findByProperty(OPERATOR_ID, operatorId);
	}

	public List findAll() {
		log.debug("finding all AddOutlay instances");
		try {
			String queryString = "from AddOutlay";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AddOutlay merge(AddOutlay detachedInstance) {
		log.debug("merging AddOutlay instance");
		try {
			AddOutlay result = (AddOutlay) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AddOutlay instance) {
		log.debug("attaching dirty AddOutlay instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AddOutlay instance) {
		log.debug("attaching clean AddOutlay instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AddOutlayDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AddOutlayDAO) ctx.getBean("AddOutlayDAO");
	}
}