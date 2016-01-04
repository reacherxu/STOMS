package com.stoms.service;

import java.util.ArrayList;
import java.util.List;

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
import com.stoms.model.SocialScienceOutlay;
import com.stoms.model.SumFundOutlay;
import com.stoms.model.Teacher;
import com.stoms.model.temp.TeacherStatisticsByTypePK;
import com.stoms.utils.JSONTranslation;

public class TeacherStatisticsService {

	private ItemDAO itemDAO;
	private ProjectTypeDAO projectTypeDAO;
	private AddOutlayDAO addOutlayDAO;
	private NationalFundOutlayDAO nationalFundOutlayDAO;
	private A863outlayDAO a863outlayDAO;
	private SumFundOutlayDAO sumFundOutlayDAO;
	private SocialScienceOutlayDAO socialScienceOutlayDAO;

	public List acquireTeacherStatisticByIsCross(int isCross,String teacherId,String lowYear,String upperYear)
	{
		double addoutlaySum = 0;
		double outlaySum = 0;
		List<Item> itemList = itemDAO.findbyTeacherIDandCreatIDWithIsCross(isCross,teacherId);
		
//		for (Item item : itemList) {
//			System.out.println(item.getItemName());
//		}
		itemList = removeBytimeLimit(itemList,lowYear,upperYear);
		
//		for (Item item : itemList) {
//			System.out.println(item.getItemName());
//		}
		
		List<TeacherStatisticsByTypePK> teacherStatisticsByTypePKs = new ArrayList<TeacherStatisticsByTypePK>();
		for (Item i : itemList) {
			addoutlaySum = 0;
			outlaySum = 0;
			List<AddOutlay> addOutlaylist = addOutlayDAO.findByItemId(i.getItemId());
			for (AddOutlay addOutlay : addOutlaylist) {
				addoutlaySum+=addOutlay.getOutlayValue();
			}
			
			switch (i.getProjectType().getBudgetType()) {
			case 1:
				List<SumFundOutlay> sumFundOutlaylist= sumFundOutlayDAO.findByItemId(i.getItemId());
				for (SumFundOutlay sumFundOutlay : sumFundOutlaylist) {
					outlaySum+=sumFundOutlay.getSumCost();
				}
				break;
			case 2:
				List<NationalFundOutlay> nationalFundOutlaylist= nationalFundOutlayDAO.findByItemId(i.getItemId());
				for (NationalFundOutlay nationalFundOutlay : nationalFundOutlaylist) {
					outlaySum+=nationalFundOutlay.getSums();
				}
				break;
			case 3:
				List<A863outlay> a863outlaylist = a863outlayDAO.findByItemId(i.getItemId());
				for (A863outlay a863outlay : a863outlaylist) {
					outlaySum+=a863outlay.getCostSum();
				}
			case 4:
				List<SocialScienceOutlay> socialScienceOutlaylist = socialScienceOutlayDAO.findByItemId(i.getItemId());
				for (SocialScienceOutlay socialScienceOutlay : socialScienceOutlaylist) {
					outlaySum+=socialScienceOutlay.getCostSum();
				}
				break;
			default:
				break;
			}
			teacherStatisticsByTypePKs.add(
					new TeacherStatisticsByTypePK(
							i.getItemId(), 
							i.getItemName(), 
							outlaySum, 
							addoutlaySum)
					);			
		}
		
		addoutlaySum = 0;
		outlaySum=0;
		double balanceSum = 0;
		for (TeacherStatisticsByTypePK teacherStatisticsByTypePK : teacherStatisticsByTypePKs) {
			addoutlaySum+=teacherStatisticsByTypePK.getAddOutlay();
			outlaySum+=teacherStatisticsByTypePK.getOutlay();
			balanceSum+=teacherStatisticsByTypePK.getBalance();
		}

		teacherStatisticsByTypePKs.add(
				new TeacherStatisticsByTypePK(
						"NO ID", 
						"Sum", 
						outlaySum, 
						addoutlaySum,
						balanceSum)
				);			
		return teacherStatisticsByTypePKs;
	}

	private List<Item> removeBytimeLimit(List<Item> itemList,String lowYear,String upperYear ) {
		List<Item> delList1 = new ArrayList<Item>();
		List<Item> delList2 = new ArrayList<Item>();
		if (lowYear!=null&&!lowYear.equals("")) {
			for (Item item : itemList) {
				if (item.getApplyYear()!=null&&item.getApplyYear().compareTo(lowYear)<0) {
					delList1.add(item);
				}
			}
		}
		itemList.removeAll(delList1);
		
		if (upperYear!=null&&!upperYear.equals("")) {
			for (Item item : itemList) {
				if (item.getApplyYear()!=null&&item.getApplyYear().compareTo(upperYear)>0) {
					delList2.add(item);
				}
			}			
		}
		itemList.removeAll(delList2);
		return itemList;
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
