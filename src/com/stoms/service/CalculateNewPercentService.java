package com.stoms.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stoms.dao.A863njubudgetDAO;
import com.stoms.dao.ActualFundBudgetDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.dao.NationalFundBudgetDAO;
import com.stoms.dao.PforNewDAO;
import com.stoms.dao.SocialScienceNjubudgetDAO;
import com.stoms.model.A863njubudget;
import com.stoms.model.ActualFundBudget;
import com.stoms.model.Item;
import com.stoms.model.NationalFundBudget;
import com.stoms.model.PforNew;
import com.stoms.model.SocialScienceNjubudget;

public class CalculateNewPercentService {
	private ActualFundBudgetDAO actualFundBudgetDAO;
	private A863njubudgetDAO a863njubudgetDAO;
	private NationalFundBudgetDAO nationalFundBudgetDAO;
	private SocialScienceNjubudgetDAO socialScienceNjubudgetDAO;
	private ItemDAO itemDAO;
	private PforNewDAO pforNewDAO;

	public String savePNewFour(String itemId) {
		
		List<Item> itemList=itemDAO.findByItemId(itemId);
		if (itemList.size()==0) {
			return "error";
		}
		Item item = itemList.get(0);
		
		Double travelCost=0.0,exchange=0.0,equipment=0.0,conference=0.0;
		switch (item.getProjectType().getBudgetType()) {
		case 1:
			List<ActualFundBudget> actualFundBudgets=actualFundBudgetDAO.findByItemId(itemId);	
			if (actualFundBudgets.size()!=0) {
				ActualFundBudget actualFundBudget = actualFundBudgets.get(0);
				travelCost=actualFundBudget.getTravelCost()/actualFundBudget.getSumCost();
				exchange=0.0;
				equipment=actualFundBudget.getEquipmentCost()/actualFundBudget.getSumCost();
				conference=actualFundBudget.getConferenceCost()/actualFundBudget.getSumCost();	
			}
			break;
		case 2:
			List<NationalFundBudget> nationalFundBudgets=nationalFundBudgetDAO.findByItemId(itemId);	
			if (nationalFundBudgets.size()!=0) {
				NationalFundBudget nationalFundBudget=nationalFundBudgets.get(0);
				travelCost=nationalFundBudget.getConferenceCost()/nationalFundBudget.getSums();
				exchange=nationalFundBudget.getExchangeSum()/nationalFundBudget.getSums();
				equipment=nationalFundBudget.getSumEquipment()/nationalFundBudget.getSums();
				conference=travelCost;	
			}
			break;
		case 3:
			List<A863njubudget> a863njubudgets=a863njubudgetDAO.findByItemId(itemId);
			if (a863njubudgets.size()!=0) {
				A863njubudget a863njubudget=a863njubudgets.get(0);
				travelCost=a863njubudget.getTravelCost()/a863njubudget.getFundSum();
				exchange=a863njubudget.getExchangeCost()/a863njubudget.getFundSum();
				equipment=a863njubudget.getEquipmentCost()/a863njubudget.getFundSum();
				conference=a863njubudget.getConferenceCost()/a863njubudget.getFundSum();
			}
		case 4:
			List<SocialScienceNjubudget> socialScienceNjubudgets=socialScienceNjubudgetDAO.findByItemId(itemId);
			if (socialScienceNjubudgets.size()!=0) {
				SocialScienceNjubudget socialScienceNjubudget=socialScienceNjubudgets.get(0);
				travelCost=socialScienceNjubudget.getTravelCost()/socialScienceNjubudget.getCostSum();
				exchange=socialScienceNjubudget.getExchangeCost()/socialScienceNjubudget.getCostSum();
				equipment=socialScienceNjubudget.getEquipmentCost()/socialScienceNjubudget.getCostSum();
				conference=socialScienceNjubudget.getConferenceCost()/socialScienceNjubudget.getCostSum();
			}
		default:
			break;
		}


		PforNew pforNew =new PforNew();
		pforNew.setItemId(itemId);
		pforNew.setPconference(conference);
		pforNew.setPequipment(equipment);
		pforNew.setPexchange(exchange);
		pforNew.setPtravelCost(travelCost);
		
		pforNewDAO.save(pforNew);
		
		return "success";

	}
	
	
	public String savePNewFour(Long	itemPk) {
		
		Item item=itemDAO.findById(itemPk);
		
		Double travelCost=0.0,exchange=0.0,equipment=0.0,conference=0.0;
		switch (item.getProjectType().getBudgetType()) {
		case 1:
			List<ActualFundBudget> actualFundBudgets=actualFundBudgetDAO.findByItemPk(itemPk);
			if (actualFundBudgets.size()!=0) {
				ActualFundBudget actualFundBudget = actualFundBudgets.get(0);
				travelCost=actualFundBudget.getTravelCost()/actualFundBudget.getSumCost();
				exchange=0.0;
				equipment=actualFundBudget.getEquipmentCost()/actualFundBudget.getSumCost();
				conference=actualFundBudget.getConferenceCost()/actualFundBudget.getSumCost();	
			}
			break;
		case 2:
			List<NationalFundBudget> nationalFundBudgets=nationalFundBudgetDAO.findByItemPk(itemPk);	
			if (nationalFundBudgets.size()!=0) {
				NationalFundBudget nationalFundBudget=nationalFundBudgets.get(0);
				travelCost=nationalFundBudget.getConferenceCost()/nationalFundBudget.getSums();
				exchange=nationalFundBudget.getExchangeSum()/nationalFundBudget.getSums();
				equipment=nationalFundBudget.getSumEquipment()/nationalFundBudget.getSums();
				conference=travelCost;	
			}
			break;
		case 3:
			List<A863njubudget> a863njubudgets=a863njubudgetDAO.findByItemPk(itemPk);	
			if (a863njubudgets.size()!=0) {
				A863njubudget a863njubudget=a863njubudgets.get(0);
				travelCost=a863njubudget.getTravelCost()/a863njubudget.getFundSum();
				exchange=a863njubudget.getExchangeCost()/a863njubudget.getFundSum();
				equipment=a863njubudget.getEquipmentCost()/a863njubudget.getFundSum();
				conference=a863njubudget.getConferenceCost()/a863njubudget.getFundSum();
			}
		case 4:
			List<SocialScienceNjubudget> socialScienceNjubudgets=socialScienceNjubudgetDAO.findByItemPk(itemPk);
			if (socialScienceNjubudgets.size()!=0) {
				SocialScienceNjubudget socialScienceNjubudget=socialScienceNjubudgets.get(0);
				travelCost=socialScienceNjubudget.getTravelCost()/socialScienceNjubudget.getCostSum();
				exchange=socialScienceNjubudget.getExchangeCost()/socialScienceNjubudget.getCostSum();
				equipment=socialScienceNjubudget.getEquipmentCost()/socialScienceNjubudget.getCostSum();
				conference=socialScienceNjubudget.getConferenceCost()/socialScienceNjubudget.getCostSum();
			}
		default:
			break;
		}


		PforNew pforNew =new PforNew();
		pforNew.setItemId(item.getItemId());
		pforNew.setPconference(parseDoubleP2(conference));
		pforNew.setPequipment(parseDoubleP2(equipment));
		pforNew.setPexchange(parseDoubleP2(exchange));
		pforNew.setPtravelCost(parseDoubleP2(travelCost));
		pforNewDAO.save(pforNew);
		
		return "success";

	}

	private Double parseDoubleP2(Double d)
	{
		String s1 = d+"";

		String s2= s1.substring(0, s1.indexOf(".")+4>s1.length()?s1.length():s1.indexOf(".")+4);
		return Double.parseDouble(s2);
	}
	
	public ActualFundBudgetDAO getActualFundBudgetDAO() {
		return actualFundBudgetDAO;
	}

	public void setActualFundBudgetDAO(ActualFundBudgetDAO actualFundBudgetDAO) {
		this.actualFundBudgetDAO = actualFundBudgetDAO;
	}

	public A863njubudgetDAO getA863njubudgetDAO() {
		return a863njubudgetDAO;
	}

	public void setA863njubudgetDAO(A863njubudgetDAO a863njubudgetDAO) {
		this.a863njubudgetDAO = a863njubudgetDAO;
	}

	public NationalFundBudgetDAO getNationalFundBudgetDAO() {
		return nationalFundBudgetDAO;
	}

	public void setNationalFundBudgetDAO(NationalFundBudgetDAO nationalFundBudgetDAO) {
		this.nationalFundBudgetDAO = nationalFundBudgetDAO;
	}

	public SocialScienceNjubudgetDAO getSocialScienceNjubudgetDAO() {
		return socialScienceNjubudgetDAO;
	}

	public void setSocialScienceNjubudgetDAO(
			SocialScienceNjubudgetDAO socialScienceNjubudgetDAO) {
		this.socialScienceNjubudgetDAO = socialScienceNjubudgetDAO;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public PforNewDAO getPforNewDAO() {
		return pforNewDAO;
	}

	public void setPforNewDAO(PforNewDAO pforNewDAO) {
		this.pforNewDAO = pforNewDAO;
	}


}
