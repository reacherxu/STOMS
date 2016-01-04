package com.stoms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.stoms.dao.A863itemDAO;
import com.stoms.dao.A863outlayDAO;
import com.stoms.dao.ActualFundBudgetDAO;
import com.stoms.dao.AddOutlayDAO;
import com.stoms.dao.DepartmentDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.dao.NationalFundBudgetDAO;
import com.stoms.dao.NationalFundOutlayDAO;
import com.stoms.dao.ProjectTypeDAO;
import com.stoms.dao.SocialScienceOutlayDAO;
import com.stoms.dao.SumFundOutlayDAO;
import com.stoms.dao.TeacherDAO;
import com.stoms.model.A863item;
import com.stoms.model.A863outlay;
import com.stoms.model.ActualFundBudget;
import com.stoms.model.AddOutlay;
import com.stoms.model.Department;
import com.stoms.model.Item;
import com.stoms.model.NationalFundBudget;
import com.stoms.model.NationalFundOutlay;
import com.stoms.model.ProjectType;
import com.stoms.model.SumFundOutlay;
import com.stoms.model.Teacher;
import com.stoms.model.temp.TeacherStatisticsByTypePK;
import com.stoms.utils.JSONTranslation;

public class ColumnSumOutlayService {

	private ItemDAO itemDAO;
	private ProjectTypeDAO projectTypeDAO;
	private AddOutlayDAO addOutlayDAO;
	private NationalFundOutlayDAO nationalFundOutlayDAO;
	private A863outlayDAO a863outlayDAO;
	private SumFundOutlayDAO sumFundOutlayDAO;
	private SocialScienceOutlayDAO socialScienceOutlayDAO;

	public List acquireColumnSumofOutlay(long itemPk)
	{
		List list = new ArrayList();
		Item item = itemDAO.findById(itemPk);
		
		ProjectType thistype = projectTypeDAO.findById(item.getProjectType().getTypePk());

		//根据ProjectType表中BudgetType字段判定此项目的支出表		
		switch (thistype.getBudgetType()){
		case 1:
			list=sumFundOutlayDAO.findColumnSumListByItemPK(itemPk);
			break;
		case 2:
			list=nationalFundOutlayDAO.findColumnSumListByItemPK(itemPk);			
			break;
		case 3:
			list=a863outlayDAO.findColumnSumListByItemPK(itemPk);
			break;
		case 4:
			list=socialScienceOutlayDAO.findColumnSumListByItemPK(itemPk);
			break;
		default:
			break;
		}
		Object[] object = (Object[]) list.get(0);
		List columnSumlist = new ArrayList();
		for (Object object2 : object) {
			columnSumlist.add(object2);
		}
		return columnSumlist;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public ProjectTypeDAO getProjectTypeDAO() {
		return projectTypeDAO;
	}

	public void setProjectTypeDAO(ProjectTypeDAO projectTypeDAO) {
		this.projectTypeDAO = projectTypeDAO;
	}

	public AddOutlayDAO getAddOutlayDAO() {
		return addOutlayDAO;
	}

	public void setAddOutlayDAO(AddOutlayDAO addOutlayDAO) {
		this.addOutlayDAO = addOutlayDAO;
	}

	public NationalFundOutlayDAO getNationalFundOutlayDAO() {
		return nationalFundOutlayDAO;
	}

	public void setNationalFundOutlayDAO(
			NationalFundOutlayDAO nationalFundOutlayDAO) {
		this.nationalFundOutlayDAO = nationalFundOutlayDAO;
	}

	public A863outlayDAO getA863outlayDAO() {
		return a863outlayDAO;
	}

	public void setA863outlayDAO(A863outlayDAO a863outlayDAO) {
		this.a863outlayDAO = a863outlayDAO;
	}

	public SumFundOutlayDAO getSumFundOutlayDAO() {
		return sumFundOutlayDAO;
	}

	public void setSumFundOutlayDAO(SumFundOutlayDAO sumFundOutlayDAO) {
		this.sumFundOutlayDAO = sumFundOutlayDAO;
	}

	public SocialScienceOutlayDAO getSocialScienceOutlayDAO() {
		return socialScienceOutlayDAO;
	}

	public void setSocialScienceOutlayDAO(
			SocialScienceOutlayDAO socialScienceOutlayDAO) {
		this.socialScienceOutlayDAO = socialScienceOutlayDAO;
	}

}
