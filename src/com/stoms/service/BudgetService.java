package com.stoms.service;

import java.text.DecimalFormat;
import java.util.List;

import com.stoms.dao.BudgetDAO;
import com.stoms.model.Budget;
import com.stoms.utils.JSONTranslation;

public class BudgetService {

	private BudgetDAO budgetDAO;

	private String contractId;
	private String manager;
	private Float studyOutlay;
	private Float studyOutlaySr;
	private Float studyOutlaySrTest;
	private Float studyOutlaySrEnergy;
	private Float studyOutlaySrMeeting;
	private Float studyOutlaySrPublish;
	private Float studyOutlaySrOther;
	private Float studyOutlayEm;
	private Float studyOutlayEmMaterial;
	private Float studyOutlayEmOther;
	private Float studyOutlayEi;
	private Float studyOutlayEiPurchase;
	private Float studyOutlayEiProduce;
	private Float studyOutlayLr;
	private Float studyOutlayColaborate;
	private Float international;
	private Float international1;
	private Float international2;
	private Float service;
	private Float management;
	private Float sum;

	/**
	 * 是否有 合同号
	 * @param contractId
	 * @return
	 */
	public boolean hasContractID(String contractId) {
		
		boolean result = false;

		List<Budget> tmpBudgetList = budgetDAO.findByContractId(contractId);

		if(tmpBudgetList != null && tmpBudgetList.size() > 0) {
			result = true;
		}

		return result;
	}
	
	/**
	 * 根据合同号获取预算表所有信息
	 * @return
	 */
	public String getDataToForm(String contractId) {
		String[] excludes = {};
		Budget tmpBudget = (Budget) budgetDAO.findByContractId(contractId).get(0);
		return JSONTranslation.objectToJson(tmpBudget, excludes);
//		String tmpJson =  JSONTranslation.objectToJson(tmpBudget, excludes);
//		return dealWithBudget(tmpJson);
	}
	/**
	 * 处理JSONTranslation方法中遇到小数会出现机器数的情况
	 * @param tmpJson
	 * @return
	 */
	public String dealWithBudget(String tmpJson) {
		String resultJson = "";
		
		String split[] = tmpJson.split(",");
		for( int i=0; i<split.length; i++ ) {
			if( i == split.length-1) {
				String last[] = split[i].split(":",2);
				last[1] = last[1].substring(0,last[1].length()-1); 
				
				if(last[1].equals("0") || !last[1].matches("[.0-9]*")) {
					resultJson += last[0] + ":" + last[1] ;
				} else {
					float fare = Float.parseFloat(last[1]);
					resultJson += last[0] + ":" + String.format("%.4f", fare) ;
				}
			} else {

				String tmp[] = split[i].split(":",2);
				if(tmp[1].equals("0") || !tmp[1].matches("[.0-9]*")) {
					resultJson += tmp[0] + ":" + tmp[1] + ",";
				} else {
					float fare = Float.parseFloat(tmp[1]);
					resultJson += tmp[0] + ":" + String.format("%.4f", fare) + ",";
				}
			}
		}
		resultJson += "}";
		return resultJson;
	}
	
	//插入时判断是否已经有了
	public boolean addNewBudget(String contractId, String manager,
			Float studyOutlay, Float studyOutlaySr, Float studyOutlaySrTest,
			Float studyOutlaySrEnergy, Float studyOutlaySrMeeting,
			Float studyOutlaySrPublish, Float studyOutlaySrOther,
			Float studyOutlayEm, Float studyOutlayEmMaterial,
			Float studyOutlayEmOther, Float studyOutlayEi,
			Float studyOutlayEiPurchase, Float studyOutlayEiProduce,
			Float studyOutlayLr, Float studyOutlayColaborate,
			Float international, Float international1, Float international2,
			Float service, Float management, Float sum) {
		
		boolean result = false;

		Budget tempBudget = new Budget();

		List<Budget> tmpBudgetList = budgetDAO.findByContractId(contractId);

		//若已存在  则覆盖
		if(tmpBudgetList != null && tmpBudgetList.size() > 0) {
			return this.updateBudget(contractId, manager, studyOutlay, studyOutlaySr, studyOutlaySrTest,
					studyOutlaySrEnergy, studyOutlaySrMeeting, studyOutlaySrPublish, 
					studyOutlaySrOther, studyOutlayEm, studyOutlayEmMaterial, studyOutlayEmOther,
					studyOutlayEi, studyOutlayEiPurchase, studyOutlayEiProduce, studyOutlayLr, 
					studyOutlayColaborate, international, international1, international2, 
					service, management, sum);
		}

		tempBudget = setBudgetValue(tempBudget,contractId, manager,
				studyOutlay,  studyOutlaySr,  studyOutlaySrTest,studyOutlaySrEnergy,
				studyOutlaySrMeeting, studyOutlaySrPublish,  studyOutlaySrOther,
				studyOutlayEm,studyOutlayEmMaterial,studyOutlayEmOther,studyOutlayEi,
				studyOutlayEiPurchase,studyOutlayEiProduce,studyOutlayLr,studyOutlayColaborate,
				international,international1,  international2,service,management,sum);

		budgetDAO.save(tempBudget);

		result = true;

		return result;
	}
	
	public boolean updateBudget(String contractId, String manager,
			Float studyOutlay, Float studyOutlaySr, Float studyOutlaySrTest,
			Float studyOutlaySrEnergy, Float studyOutlaySrMeeting,
			Float studyOutlaySrPublish, Float studyOutlaySrOther,
			Float studyOutlayEm, Float studyOutlayEmMaterial,
			Float studyOutlayEmOther, Float studyOutlayEi,
			Float studyOutlayEiPurchase, Float studyOutlayEiProduce,
			Float studyOutlayLr, Float studyOutlayColaborate,
			Float international, Float international1, Float international2,
			Float service, Float management, Float sum) {
		
		boolean result = false;

		Budget tempBudget;

		List<Budget> tmpBudgetList = budgetDAO.findByContractId(contractId);

		if( tmpBudgetList.size() == 0) {
			return false;
		} else {
			tempBudget = tmpBudgetList.get(0);
		}

		tempBudget = setBudgetValue(tempBudget,contractId, manager,
				studyOutlay,  studyOutlaySr,  studyOutlaySrTest,studyOutlaySrEnergy,
				studyOutlaySrMeeting, studyOutlaySrPublish,  studyOutlaySrOther,
				studyOutlayEm,studyOutlayEmMaterial,studyOutlayEmOther,studyOutlayEi,
				studyOutlayEiPurchase,studyOutlayEiProduce,studyOutlayLr,studyOutlayColaborate,
				international,international1,  international2,service,management,sum);

		budgetDAO.delete(tempBudget);
		budgetDAO.save(tempBudget);

		result = true;

		return result;
	}
	
	/**
	 * 设置Budget的值
	 * 
	 * @return
	 */
	private Budget setBudgetValue(Budget tempBudget,String contractId, String manager,
			Float studyOutlay, Float studyOutlaySr, Float studyOutlaySrTest,
			Float studyOutlaySrEnergy, Float studyOutlaySrMeeting,
			Float studyOutlaySrPublish, Float studyOutlaySrOther,
			Float studyOutlayEm, Float studyOutlayEmMaterial,
			Float studyOutlayEmOther, Float studyOutlayEi,
			Float studyOutlayEiPurchase, Float studyOutlayEiProduce,
			Float studyOutlayLr, Float studyOutlayColaborate,
			Float international, Float international1, Float international2,
			Float service, Float management, Float sum){
		
		
		tempBudget.setContractId(contractId);
		tempBudget.setManager(manager);
		
		tempBudget.setStudyOutlay(studyOutlay);
		tempBudget.setStudyOutlaySr(studyOutlaySr);
		tempBudget.setStudyOutlaySrEnergy(studyOutlaySrEnergy);
		tempBudget.setStudyOutlaySrTest(studyOutlaySrTest);
		tempBudget.setStudyOutlaySrMeeting(studyOutlaySrMeeting);
		tempBudget.setStudyOutlaySrPublish(studyOutlaySrPublish);
		tempBudget.setStudyOutlaySrOther(studyOutlaySrOther);
		tempBudget.setStudyOutlayEm(studyOutlayEm);
		tempBudget.setStudyOutlayEmMaterial(studyOutlayEmMaterial);
		tempBudget.setStudyOutlayEmOther(studyOutlayEmOther);
		tempBudget.setStudyOutlayEi(studyOutlayEi);
		tempBudget.setStudyOutlayEiPurchase(studyOutlayEiPurchase);
		tempBudget.setStudyOutlayEiProduce(studyOutlayEiProduce);
		tempBudget.setStudyOutlayLr(studyOutlayLr);
		tempBudget.setStudyOutlayColaborate(studyOutlayColaborate);
		tempBudget.setInternational(international);
		tempBudget.setInternational1(international1);
		tempBudget.setInternational2(international2);
		tempBudget.setService(service);
		tempBudget.setManagement(management);
		tempBudget.setSum(sum);
		return tempBudget;
	}
	//setters&getters
	public BudgetDAO getBudgetDAO() {
		return budgetDAO;
	}

	public void setBudgetDAO(BudgetDAO budgetDAO) {
		this.budgetDAO = budgetDAO;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Float getStudyOutlay() {
		return studyOutlay;
	}

	public void setStudyOutlay(Float studyOutlay) {
		this.studyOutlay = studyOutlay;
	}

	public Float getStudyOutlaySr() {
		return studyOutlaySr;
	}

	public void setStudyOutlaySr(Float studyOutlaySr) {
		this.studyOutlaySr = studyOutlaySr;
	}

	public Float getStudyOutlaySrTest() {
		return studyOutlaySrTest;
	}

	public void setStudyOutlaySrTest(Float studyOutlaySrTest) {
		this.studyOutlaySrTest = studyOutlaySrTest;
	}

	public Float getStudyOutlaySrEnergy() {
		return studyOutlaySrEnergy;
	}

	public void setStudyOutlaySrEnergy(Float studyOutlaySrEnergy) {
		this.studyOutlaySrEnergy = studyOutlaySrEnergy;
	}

	public Float getStudyOutlaySrMeeting() {
		return studyOutlaySrMeeting;
	}

	public void setStudyOutlaySrMeeting(Float studyOutlaySrMeeting) {
		this.studyOutlaySrMeeting = studyOutlaySrMeeting;
	}

	public Float getStudyOutlaySrPublish() {
		return studyOutlaySrPublish;
	}

	public void setStudyOutlaySrPublish(Float studyOutlaySrPublish) {
		this.studyOutlaySrPublish = studyOutlaySrPublish;
	}

	public Float getStudyOutlaySrOther() {
		return studyOutlaySrOther;
	}

	public void setStudyOutlaySrOther(Float studyOutlaySrOther) {
		this.studyOutlaySrOther = studyOutlaySrOther;
	}

	public Float getStudyOutlayEm() {
		return studyOutlayEm;
	}

	public void setStudyOutlayEm(Float studyOutlayEm) {
		this.studyOutlayEm = studyOutlayEm;
	}

	public Float getStudyOutlayEmMaterial() {
		return studyOutlayEmMaterial;
	}

	public void setStudyOutlayEmMaterial(Float studyOutlayEmMaterial) {
		this.studyOutlayEmMaterial = studyOutlayEmMaterial;
	}

	public Float getStudyOutlayEmOther() {
		return studyOutlayEmOther;
	}

	public void setStudyOutlayEmOther(Float studyOutlayEmOther) {
		this.studyOutlayEmOther = studyOutlayEmOther;
	}

	public Float getStudyOutlayEi() {
		return studyOutlayEi;
	}

	public void setStudyOutlayEi(Float studyOutlayEi) {
		this.studyOutlayEi = studyOutlayEi;
	}

	public Float getStudyOutlayEiPurchase() {
		return studyOutlayEiPurchase;
	}

	public void setStudyOutlayEiPurchase(Float studyOutlayEiPurchase) {
		this.studyOutlayEiPurchase = studyOutlayEiPurchase;
	}

	public Float getStudyOutlayEiProduce() {
		return studyOutlayEiProduce;
	}

	public void setStudyOutlayEiProduce(Float studyOutlayEiProduce) {
		this.studyOutlayEiProduce = studyOutlayEiProduce;
	}

	public Float getStudyOutlayLr() {
		return studyOutlayLr;
	}

	public void setStudyOutlayLr(Float studyOutlayLr) {
		this.studyOutlayLr = studyOutlayLr;
	}

	public Float getStudyOutlayColaborate() {
		return studyOutlayColaborate;
	}

	public void setStudyOutlayColaborate(Float studyOutlayColaborate) {
		this.studyOutlayColaborate = studyOutlayColaborate;
	}

	public Float getInternational() {
		return international;
	}

	public void setInternational(Float international) {
		this.international = international;
	}

	public Float getInternational1() {
		return international1;
	}

	public void setInternational1(Float international1) {
		this.international1 = international1;
	}

	public Float getInternational2() {
		return international2;
	}

	public void setInternational2(Float international2) {
		this.international2 = international2;
	}

	public Float getService() {
		return service;
	}

	public void setService(Float service) {
		this.service = service;
	}

	public Float getManagement() {
		return management;
	}

	public void setManagement(Float management) {
		this.management = management;
	}

	public Float getSum() {
		return sum;
	}

	public void setSum(Float sum) {
		this.sum = sum;
	}

	
	
	
	
}

