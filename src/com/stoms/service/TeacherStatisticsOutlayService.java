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
import com.stoms.model.temp.StatisticsDepartmentOutlay;
import com.stoms.model.temp.StatisticsTeacherOutlay;
import com.stoms.model.temp.TeacherStatisticsByTypePK;
import com.stoms.model.temp.TeacherStatisticsSelfOutlay;
import com.stoms.utils.JSONTranslation;

public class TeacherStatisticsOutlayService {

	private ItemDAO itemDAO;
	private ProjectTypeDAO projectTypeDAO;
	private AddOutlayDAO addOutlayDAO;
	private NationalFundOutlayDAO nationalFundOutlayDAO;
	private A863outlayDAO a863outlayDAO;
	private SumFundOutlayDAO sumFundOutlayDAO;
	private SocialScienceOutlayDAO socialScienceOutlayDAO;

	//教师端：经费统计查询
	public List TeacherStatisticOutlay(int isCross,String teacherId,String lowDate,String upperDate)
	{
		double addoutlay = 0;
		double outlay = 0;
		double sumoutlay=0;
		double sumaddoutlay=0;
		List<Item> itemList = itemDAO.findItemlistWithIsCrossAndProjectStatus(isCross,teacherId);
		
//		for (Item item : itemList) {
//			System.out.println(item.getItemName());
//		}
		
		List<TeacherStatisticsSelfOutlay> teacherStatisticsOutlays = new ArrayList<TeacherStatisticsSelfOutlay>();

		for (Item i : itemList) {
			addoutlay = 0;
			outlay = 0;
			sumoutlay=0;
			sumaddoutlay=0;
			List<AddOutlay> addOutlaylist = addOutlayDAO.findByItemId(i.getItemId());
			for (AddOutlay addOutlay : addOutlaylist) {
				sumaddoutlay+=addOutlay.getOutlayValue();
			}
			
			if (sumaddoutlay==0) {
				continue;
			}
			
			addOutlaylist = removeAddOutlayBytimeLimit(addOutlaylist, lowDate, upperDate);
			for (AddOutlay addOutlay : addOutlaylist) {
				addoutlay+=addOutlay.getOutlayValue();
			}
			
			switch (i.getProjectType().getBudgetType()) {
			case 1:
				List<SumFundOutlay> sumFundOutlaylist= sumFundOutlayDAO.findByItemId(i.getItemId());
				for (SumFundOutlay sumFundOutlay : sumFundOutlaylist) {
					sumoutlay+=sumFundOutlay.getSumCost();
				}
				sumFundOutlaylist=removeSumFundOutlayBytimeLimit(sumFundOutlaylist, lowDate, upperDate);
				for (SumFundOutlay sumFundOutlay : sumFundOutlaylist) {
					outlay+=sumFundOutlay.getSumCost();
				}
				break;
			case 2:
				List<NationalFundOutlay> nationalFundOutlaylist= nationalFundOutlayDAO.findByItemId(i.getItemId());
				for (NationalFundOutlay nationalFundOutlay : nationalFundOutlaylist) {
					sumoutlay+=nationalFundOutlay.getSums();
				}
				nationalFundOutlaylist=removeNationalFundOutlayBytimeLimit(nationalFundOutlaylist, lowDate, upperDate);
				for (NationalFundOutlay nationalFundOutlay : nationalFundOutlaylist) {
					outlay+=nationalFundOutlay.getSums();
				}
				break;
			case 3:
				List<A863outlay> a863outlaylist = a863outlayDAO.findByItemId(i.getItemId());
				for (A863outlay a863outlay : a863outlaylist) {
					sumoutlay+=a863outlay.getCostSum();
				}
				a863outlaylist=removeA863outlayBytimeLimit(a863outlaylist, lowDate, upperDate);
				for (A863outlay a863outlay : a863outlaylist) {
					outlay+=a863outlay.getCostSum();
				}
				break;
			case 4:
				List<SocialScienceOutlay> socialScienceOutlaylist = socialScienceOutlayDAO.findByItemId(i.getItemId());
				for (SocialScienceOutlay socialScienceOutlay : socialScienceOutlaylist) {
					sumoutlay+=socialScienceOutlay.getCostSum();
				}
				socialScienceOutlaylist=removeSocialScienceOutlayBytimeLimit(socialScienceOutlaylist, lowDate, upperDate);
				for (SocialScienceOutlay socialScienceOutlay : socialScienceOutlaylist) {
					outlay+=socialScienceOutlay.getCostSum();
				}
				break;
			default:
				break;
			}
			teacherStatisticsOutlays.add(
					new TeacherStatisticsSelfOutlay(
							i.getItemId(), 
							i.getContractId(),
							i.getItemName(), 
							outlay, 
							addoutlay,
							sumoutlay,
							sumaddoutlay)
					);			
		}
		
		return teacherStatisticsOutlays;
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
	 
	//筛选SumFundOutlay时间
	private List<SumFundOutlay> removeSumFundOutlayBytimeLimit(List<SumFundOutlay> sumFundOutlay, String lowDate,
			String upperDate) {
		List<SumFundOutlay> delList1 = new ArrayList<SumFundOutlay>();
		List<SumFundOutlay> delList2 = new ArrayList<SumFundOutlay>();
		if (lowDate != null && !lowDate.equals("")) {
			for (SumFundOutlay s : sumFundOutlay) {
				if (s.getOutlayTime().compareTo(lowDate) < 0) {
					delList1.add(s);
				}
			}
		}
		sumFundOutlay.removeAll(delList1);

		if (upperDate != null && !upperDate.equals("")) {
			for (SumFundOutlay s : sumFundOutlay) {
				if (s.getOutlayTime().compareTo(upperDate) > 0) {
					delList2.add(s);
				}
			}
		}
		sumFundOutlay.removeAll(delList2);
		return sumFundOutlay;
	}
	
	//筛选NationalFundOutlay时间
	private List<NationalFundOutlay> removeNationalFundOutlayBytimeLimit(List<NationalFundOutlay> nationalFundOutlay, String lowDate,
			String upperDate) {
		List<NationalFundOutlay> delList1 = new ArrayList<NationalFundOutlay>();
		List<NationalFundOutlay> delList2 = new ArrayList<NationalFundOutlay>();
		if (lowDate != null && !lowDate.equals("")) {
			for (NationalFundOutlay n : nationalFundOutlay) {
				if (n.getOutlayTime().compareTo(lowDate) < 0) {
					delList1.add(n);
				}
			}
		}
		nationalFundOutlay.removeAll(delList1);

		if (upperDate != null && !upperDate.equals("")) {
			for (NationalFundOutlay n : nationalFundOutlay) {
				if (n.getOutlayTime().compareTo(upperDate) > 0) {
					delList2.add(n);
				}
			}
		}
		nationalFundOutlay.removeAll(delList2);
		return nationalFundOutlay;
	}
	
	//筛选A863outlay时间
	private List<A863outlay> removeA863outlayBytimeLimit(List<A863outlay> a863outlay, String lowDate,
			String upperDate) {
		List<A863outlay> delList1 = new ArrayList<A863outlay>();
		List<A863outlay> delList2 = new ArrayList<A863outlay>();
		if (lowDate != null && !lowDate.equals("")) {
			for (A863outlay a : a863outlay) {
				if (a.getOutlayTime().compareTo(lowDate) < 0) {
					delList1.add(a);
				}
			}
		}
		a863outlay.removeAll(delList1);

		if (upperDate != null && !upperDate.equals("")) {
			for (A863outlay a : a863outlay) {
				if (a.getOutlayTime().compareTo(upperDate) > 0) {
					delList2.add(a);
				}
			}
		}
		a863outlay.removeAll(delList2);
		return a863outlay;
	}
	
	//筛选SocialScienceOutlay时间
	private List<SocialScienceOutlay> removeSocialScienceOutlayBytimeLimit(List<SocialScienceOutlay> socialScienceOutlay, String lowDate,
			String upperDate) {
		List<SocialScienceOutlay> delList1 = new ArrayList<SocialScienceOutlay>();
		List<SocialScienceOutlay> delList2 = new ArrayList<SocialScienceOutlay>();
		if (lowDate != null && !lowDate.equals("")) {
			for (SocialScienceOutlay a : socialScienceOutlay) {
				if (a.getOutlayTime().compareTo(lowDate) < 0) {
					delList1.add(a);
				}
			}
		}
		socialScienceOutlay.removeAll(delList1);

		if (upperDate != null && !upperDate.equals("")) {
			for (SocialScienceOutlay a : socialScienceOutlay) {
				if (a.getOutlayTime().compareTo(upperDate) > 0) {
					delList2.add(a);
				}
			}
		}
		socialScienceOutlay.removeAll(delList2);
		return socialScienceOutlay;
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
