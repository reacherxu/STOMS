package com.stoms.service;

import java.util.ArrayList;
import java.util.List;

import com.stoms.dao.A863outlayDAO;
import com.stoms.dao.AddOutlayDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.dao.NationalFundOutlayDAO;
import com.stoms.dao.ProjectTypeDAO;
import com.stoms.dao.SumFundOutlayDAO;
import com.stoms.model.A863outlay;
import com.stoms.model.AddOutlay;
import com.stoms.model.Item;
import com.stoms.model.NationalFundOutlay;
import com.stoms.model.SumFundOutlay;
import com.stoms.model.temp.AddOutlayCampusStatistics;
import com.stoms.model.temp.StatisticsCampusOutlay;
import com.stoms.model.temp.TeacherStatisticsByTypePK;

public class StatisticsCampusOutlayService {

	private ItemDAO itemDAO;
	private ProjectTypeDAO projectTypeDAO;
	private AddOutlayDAO addOutlayDAO;
	private NationalFundOutlayDAO nationalFundOutlayDAO;
	private A863outlayDAO a863outlayDAO;
	private SumFundOutlayDAO sumFundOutlayDAO;
	private String countName;
	private List<Item> delItemList = new ArrayList<Item>();

	public List StatisticsCampusOutlayStatisticsCampusOutlay(int isCross,String lowDate, String upperDate, int[] typepks) {
		double addoutlaySum = 0;
		double outlaySum = 0;
		
		System.out.println(isCross);
		System.out.println(lowDate);
		System.out.println(upperDate);
		for (int i : typepks) {
			System.out.println(i);
		}
		
		List outlays = addOutlayDAO.findStatisticsCampus(isCross, typepks);
		List delList = new ArrayList();
		
		
		if (lowDate != null && !"".equals(lowDate)) {
			for (int i = 0; i < outlays.size(); i++)
			{
				Object[] object = (Object[]) outlays.get(i);
				String outlaytime = (String ) object[3];
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
				String outlaytime = (String ) object[3];
				if (outlaytime ==null||"".equals(outlaytime)) {
					delList.add(object);
				}
				if (outlaytime.compareTo(upperDate)>0) {
					delList.add(object);
				}
			}
			
		}
		outlays.removeAll(delList);
		
		List<StatisticsCampusOutlay> statisticsCampusOutlaylist = new ArrayList<StatisticsCampusOutlay>();
		
		for (int i = 0; i < outlays.size(); i++)
		{
			Object[] object = (Object[]) outlays.get(i);
			addoutlaySum += (Double)object[1];
			outlaySum += (Double)object[2];

		}
		
		StatisticsCampusOutlay s = new StatisticsCampusOutlay("全校经费统计", outlaySum, addoutlaySum);
		statisticsCampusOutlaylist.add(s);
		
		
		return statisticsCampusOutlaylist;
		
//		List<Item> itemList = itemDAO.findCampusItemlistByManager(isCross, typepks);
//		for (Item i : itemList) {
//			List<AddOutlay> addOutlaylist = addOutlayDAO.findByItemId(i.getItemId());
//			addOutlaylist=removeAddOutlayBytimeLimit(addOutlaylist, lowDate, upperDate);
//			for (AddOutlay addOutlay : addOutlaylist) {
//				addoutlaySum += addOutlay.getOutlayValue();
//				outlaySum+=addOutlay.getRemitValue();
//				}				
//			}
		
		
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

		if (upperDate != null && !upperDate.equals("")) {
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

}
