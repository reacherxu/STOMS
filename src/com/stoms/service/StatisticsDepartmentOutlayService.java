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
import com.stoms.model.temp.StatisticsCampusOutlay;
import com.stoms.model.temp.StatisticsDepartmentOutlay;
import com.stoms.model.temp.TeacherStatisticsByTypePK;
import com.stoms.utils.JSONTranslation;

public class StatisticsDepartmentOutlayService {

	private ItemDAO itemDAO;
	private ProjectTypeDAO projectTypeDAO;
	private AddOutlayDAO addOutlayDAO;
	private NationalFundOutlayDAO nationalFundOutlayDAO;
	private A863outlayDAO a863outlayDAO;
	private SumFundOutlayDAO sumFundOutlayDAO;
	private String countName;
	private DepartmentDAO departmentDAO;
	private List<Item> delItemList = new ArrayList<Item>();

	public List ManageDepartmentOutlay(int isCross, String departmentType,
			String lowDate, String upperDate, int[] departmentpks) {
		double addoutlaySum = 0;
		double outlaySum = 0;


		List<StatisticsDepartmentOutlay> statisticsDepartmentOutlays = new ArrayList<StatisticsDepartmentOutlay>();
		for (int j = 0; j < departmentpks.length; j++) {
			addoutlaySum = 0;
			outlaySum = 0;
			List outlays = addOutlayDAO.findStatisticsDepartment(isCross, departmentType, departmentpks[j]);
			
			List delList = new ArrayList();
			String departmentName = "";
			if (outlays.size()==0) {
				Department department = departmentDAO.findById(departmentpks[j]);
				StatisticsDepartmentOutlay statisticsDepartmentOutlay = new StatisticsDepartmentOutlay(department.getDepartmentName(), outlaySum, addoutlaySum);
				statisticsDepartmentOutlays.add(statisticsDepartmentOutlay);
				continue;
			}
			
			else {
				Object[] object1 = (Object[]) outlays.get(0);
				departmentName = (String) object1[3];
				
			}
			
			
			if (lowDate != null && !"".equals(lowDate)) {
				for (int i = 0; i < outlays.size(); i++)
				{
					Object[] object = (Object[]) outlays.get(i);
					String outlaytime = (String ) object[2];
					if (outlaytime ==null||"".equals(outlaytime)) {
						delList.add(object);
					}
					if (outlaytime.compareTo(lowDate)<0) {
						delList.add(object);
					}
				}
				
			}
			
			outlays.removeAll(delList);
			delList.clear();
			
			if (upperDate != null && !"".equals(upperDate)) {
				for (int i = 0; i < outlays.size(); i++)
				{
					Object[] object = (Object[]) outlays.get(i);
					String outlaytime = (String ) object[2];
					if (outlaytime ==null||"".equals(outlaytime)) {
						delList.add(object);
					}
					if (outlaytime.compareTo(upperDate)>0) {
						delList.add(object);
					}
				}
				
			}
			outlays.removeAll(delList);
			
			
			for (int i = 0; i < outlays.size(); i++)
			{
				Object[] object = (Object[]) outlays.get(i);
				addoutlaySum += (Double)object[0];
				outlaySum += (Double)object[1];

			}
			StatisticsDepartmentOutlay statisticsDepartmentOutlay = new StatisticsDepartmentOutlay(departmentName, outlaySum, addoutlaySum);
			statisticsDepartmentOutlays.add(statisticsDepartmentOutlay);
			
		}
		System.out.println(statisticsDepartmentOutlays.size());
		return statisticsDepartmentOutlays;
	}

	//筛选addoutlay时间
	private List<AddOutlay> removeAddOutlayBytimeLimit(List<AddOutlay> addOutlaylist, String lowDate,
			String upperDate) {
		List<AddOutlay> delList1 = new ArrayList<AddOutlay>();
		List<AddOutlay> delList2 = new ArrayList<AddOutlay>();
		if (lowDate != null && !lowDate.equals("")) {
			for (AddOutlay addOutlay : addOutlaylist) {
				if (addOutlay.getOutlayTime().compareTo(lowDate) < 0) {
					delList1.add(addOutlay);
				}
			}
		}
		addOutlaylist.removeAll(delList1);

		if (upperDate != null && !upperDate.equals("") ) {
			for (AddOutlay addOutlay : addOutlaylist) {
				if (addOutlay.getOutlayTime().compareTo(upperDate) > 0) {
					delList2.add(addOutlay);
				}
			}
		}
		addOutlaylist.removeAll(delList2);
		return addOutlaylist;
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

	public String getCountName() {
		return countName;
	}

	public void setCountName(String countName) {
		this.countName = countName;
	}

	public List<Item> getDelItemList() {
		return delItemList;
	}

	public void setDelItemList(List<Item> delItemList) {
		this.delItemList = delItemList;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	
	
}
