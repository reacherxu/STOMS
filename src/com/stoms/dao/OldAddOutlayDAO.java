package com.stoms.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.stoms.model.AddOutlay;
import com.stoms.model.OldAddOutlay;

public class OldAddOutlayDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
	.getLogger(OldAddOutlayDAO.class);
	// property constants
	public static final String ADDOUTLAY_PK = "addOutlayPk";
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
	
	public void save(OldAddOutlay transientInstance) {
		log.debug("saving OldAddOutlay instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding oldAddOutlay instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OldAddOutlay as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAddOutlayPk(Object addOutlayPk) {
		return findByProperty(ADDOUTLAY_PK, addOutlayPk);
	}
	
	
	
	public static OldAddOutlayDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OldAddOutlayDAO) ctx.getBean("OldAddOutlayDAO");
	}
}
