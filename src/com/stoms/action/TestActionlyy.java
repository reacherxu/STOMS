package com.stoms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.Item;
import com.stoms.model.temp.ManagerOutlayQuery;
import com.stoms.model.temp.StatisticsCampusOutlay;
import com.stoms.model.temp.StatisticsDepartmentOutlay;
import com.stoms.model.temp.StatisticsItemByManager;
import com.stoms.model.temp.StatisticsTeacherOutlay;
import com.stoms.model.temp.TeacherStatisticsByTypePK;
import com.stoms.model.temp.TeacherStatisticsSelfOutlay;
import com.stoms.service.A863DetailBudgetService;
import com.stoms.service.AddOutlayService;
import com.stoms.service.CalculateNewPercentService;
import com.stoms.service.ColumnSumOutlayService;
import com.stoms.service.ItemService;
import com.stoms.service.StatisticsCampusOutlayService;
import com.stoms.service.StatisticsDepartmentOutlayService;
import com.stoms.service.StatisticsTeacherOutlayService;
import com.stoms.service.TeacherService;
import com.stoms.service.TeacherStatisticsOutlayService;
import com.stoms.service.TeacherStatisticsService;
import com.sun.jndi.url.ldaps.ldapsURLContextFactory;

public class TestActionlyy extends ActionSupport{
	private String jsonResult;
	private boolean actionStatus;

	private ItemService itemService;
	private TeacherStatisticsService teacherStatisticsService;
	private ColumnSumOutlayService columnSumOutlayService;
	private StatisticsCampusOutlayService statisticsCampusOutlayService;
	private StatisticsTeacherOutlayService statisticsTeacherOutlayService;
	private TeacherStatisticsOutlayService teacherStatisticsOutlayService;
	private AddOutlayService addOutlayService;
	private A863DetailBudgetService a863DetailBudgetService;
	private CalculateNewPercentService calculateNewPercentService;
	private TeacherService teacherService;
	
	
	public String testOperation() {
		
		addOutlayService.test6();
//		itemService.test5();
//		itemService.test6();
//		List list =  teacherService.acquireAllAdminInfo();
//		System.out.println(list.size());
//		addOutlayService.test3();
//		addOutlayService.test4();
//		itemService.test1();
//		String aString;
//		aString=calculateNewPercentService.savePNewFour(Long.parseLong("11"));
//
//		int[] a = {};
//		List list=addOutlayService.acquireManagerOutlay("", "", "", "", "", "", 1, -1, "", "", "", "", a, a);
		
//		itemService.test();
		//		Long a = (long) 1;
//		List list=a863DetailBudgetService.acquireCooperationDetailBudget(a, 1);
//		System.out.println(list.size());
//		
//		String string=a863DetailBudgetService.saveSumBudget(a);
//		System.out.println(string);
//		List<TeacherStatisticsByTypePK> list=teacherStatisticsService.acquireTeacherStatisticByIsCross(-1, "00", "", "");
//		itemService.test3();
//		itemService.test2();
//		int[] a = {1,9,13};
//		List<Item> list=itemService.acquireItemInfo(a, -1, "", "", null);
//		System.out.println(list.size());
//		for (Item item : list) {
//			System.out.println(item.getItemName());
//		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getItemName());
//		}
//		List<TeacherStatisticsSelfOutlay> list=teacherStatisticsOutlayService.TeacherStatisticOutlay(-1, "00", "", "");
//		for (TeacherStatisticsSelfOutlay teacherStatisticsByTypePK : list) {
//			System.out.print(teacherStatisticsByTypePK.getItemId());
//			System.out.print("|");
//			System.out.print(teacherStatisticsByTypePK.getItemName());
//			System.out.print("|");
//			System.out.print(teacherStatisticsByTypePK.getAddOutlay());
//			System.out.print("|");
//			System.out.print(teacherStatisticsByTypePK.getOutlay());
//			System.out.print("|");
//			System.out.print(teacherStatisticsByTypePK.getSumaddoutlay());
//			System.out.print("|");
//			System.out.print(teacherStatisticsByTypePK.getSumoutlay());
//			System.out.print("|");
//			System.out.println(teacherStatisticsByTypePK.getSumbalance());
//		}
//		int[] a = {1,9,13};
//		List<StatisticsCampusOutlay> list=statisticsCampusOutlayService.StatisticsCampusOutlayStatisticsCampusOutlay(-1, "", "", a);
//		for (StatisticsCampusOutlay statisticsItemByManager : list) {
//			System.out.print(statisticsItemByManager.getGroupName());
//			System.out.print("|");
//			System.out.print(statisticsItemByManager.getAddOutlay());
//			System.out.print("|");
//			System.out.println(statisticsItemByManager.getOutlay());
//		}
		
		
//		List<StatisticsItemByManager> list=itemService.acquireStatisticsItem(null, -1, "", "", null);
//		for (StatisticsItemByManager statisticsItemByManager : list) {
//			System.out.print(statisticsItemByManager.getProjectStatus());
//			System.out.print("|");
//			System.out.println(statisticsItemByManager.getItemCount());
//		}
		
//		List<ManagerOutlayQuery> list = new ArrayList<ManagerOutlayQuery>();
//		list=addOutlayService.acquireManagerOutlay("te","ea","331001",
//				"331001","","教育",0,
//				-1,"2012-01-01","2012-01-27","2012-03-19",
//				"2012-04-01",null,null);
//		
//		System.out.println(list.size());
		
		
//		List<StatisticsTeacherOutlay> l = statisticsTeacherOutlayService.ManageTeacherOutlay(-1, "所有", "", "", null, "ea");
//		for (StatisticsTeacherOutlay statisticsTeacherOutlay : l) {
//			System.out.print(statisticsTeacherOutlay.getTeacherId());
//			System.out.print("|");
//			System.out.print(statisticsTeacherOutlay.getTeacherName());
//			System.out.print("|");
//			System.out.print(statisticsTeacherOutlay.getDepartmentName());
//			System.out.print("|");
//			System.out.print(statisticsTeacherOutlay.getAddOutlay());
//			System.out.print("|");
//			System.out.print(statisticsTeacherOutlay.getOutlay());
//			System.out.print("|");
//			System.out.println(statisticsTeacherOutlay.getBalance());
//		}
		
		this.actionStatus = true;
		this.jsonResult = "";
		return "success";
		
	}
	







	public TeacherStatisticsOutlayService getTeacherStatisticsOutlayService() {
		return teacherStatisticsOutlayService;
	}








	public void setTeacherStatisticsOutlayService(
			TeacherStatisticsOutlayService teacherStatisticsOutlayService) {
		this.teacherStatisticsOutlayService = teacherStatisticsOutlayService;
	}








	public StatisticsTeacherOutlayService getStatisticsTeacherOutlayService() {
		return statisticsTeacherOutlayService;
	}








	public void setStatisticsTeacherOutlayService(
			StatisticsTeacherOutlayService statisticsTeacherOutlayService) {
		this.statisticsTeacherOutlayService = statisticsTeacherOutlayService;
	}








	public TeacherStatisticsService getTeacherStatisticsService() {
		return teacherStatisticsService;
	}





	public void setTeacherStatisticsService(
			TeacherStatisticsService teacherStatisticsService) {
		this.teacherStatisticsService = teacherStatisticsService;
	}





	public ItemService getItemService() {
		return itemService;
	}





	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}





	public String getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	public boolean isActionStatus() {
		return actionStatus;
	}
	public void setActionStatus(boolean actionStatus) {
		this.actionStatus = actionStatus;
	}





	public ColumnSumOutlayService getColumnSumOutlayService() {
		return columnSumOutlayService;
	}





	public void setColumnSumOutlayService(
			ColumnSumOutlayService columnSumOutlayService) {
		this.columnSumOutlayService = columnSumOutlayService;
	}





	public StatisticsCampusOutlayService getStatisticsCampusOutlayService() {
		return statisticsCampusOutlayService;
	}





	public void setStatisticsCampusOutlayService(
			StatisticsCampusOutlayService statisticsCampusOutlayService) {
		this.statisticsCampusOutlayService = statisticsCampusOutlayService;
	}








	public AddOutlayService getAddOutlayService() {
		return addOutlayService;
	}








	public void setAddOutlayService(AddOutlayService addOutlayService) {
		this.addOutlayService = addOutlayService;
	}








	public A863DetailBudgetService getA863DetailBudgetService() {
		return a863DetailBudgetService;
	}








	public void setA863DetailBudgetService(
			A863DetailBudgetService a863DetailBudgetService) {
		this.a863DetailBudgetService = a863DetailBudgetService;
	}








	public CalculateNewPercentService getCalculateNewPercentService() {
		return calculateNewPercentService;
	}








	public void setCalculateNewPercentService(
			CalculateNewPercentService calculateNewPercentService) {
		this.calculateNewPercentService = calculateNewPercentService;
	}








	public TeacherService getTeacherService() {
		return teacherService;
	}








	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}


	
	
}
