package com.stoms.service;

import java.util.ArrayList;
import java.util.List;

import com.stoms.dao.ExpenditureDAO;
import com.stoms.model.Expenditure;

public class ExpenditureService {

	private ExpenditureDAO expenditureDAO;

	public static final String CERTIFICATE_DATE = "certificateDate";
	public static final String TYPE = "type";
	public static final String CERTIFICATE_ID = "certificateId";
	public static final String ABSTRACT_ = "abstract_";
	public static final String SUBJECT_ID = "subjectId";
	public static final String SECTOR = "sector";
	public static final String PROJECT_ID = "projectId";
	public static final String EXPENDITURE = "expenditure";
	public static final String LOAN = "loan";
	
	/**
	 * 根据传入的数据批量插入
	 * 科目  项目  金额
	 * @param expenditure
	 * @return
	 */
	public boolean insert(ArrayList<ArrayList<String>> expenditure) {
		
		ArrayList<String> first = expenditure.get(0);
		
		Expenditure instance = new Expenditure();
		instance.setCertificateDate(first.get(0));
		instance.setType(first.get(1));
		instance.setCertificateId(first.get(2));
		instance.setAbstract_(first.get(3));
		instance.setSubjectId(first.get(4));
		instance.setSector(first.get(5));
		instance.setProjectId(first.get(6));
		instance.setExpenditure(Float.parseFloat(first.get(7)));
		instance.setLoan(Float.parseFloat(first.get(8)));
		
		List tmp = expenditureDAO.findByExample(instance);
		if( tmp.size() > 0  ) {
			return false;
		} else {

			for(int i=0; i<expenditure.size() ; i++) {
				ArrayList<String> tmpList = expenditure.get(i);
				
				String _date = tmpList.get(0);
				String _type = tmpList.get(1);
				String _id = tmpList.get(2);
				String _abstract = tmpList.get(3);
				String _subject = tmpList.get(4);
				String _sector = tmpList.get(5);
				String _project = tmpList.get(6);
				float _expense = Float.parseFloat(tmpList.get(7));
				float _loan = Float.parseFloat(tmpList.get(8));

				Expenditure tmpEx = new Expenditure();
				tmpEx = setExpenditureValue(tmpEx,_date,_type,_id,_abstract,_subject,_sector,_project,_expense,_loan);
				expenditureDAO.save(tmpEx);
			}
		}
		
		return true;
	}

	
	/**
	 * 根据 项目号和 科目号找 支出
	 * @param itemId
	 * @param subject
	 * @return
	 */
	public float findByPro_Sub(String itemId, String subject) {
		Expenditure ex = new Expenditure();
		ex.setProjectId(itemId);
		ex.setSubjectId(subject);
		
		List<Expenditure> listProject = expenditureDAO.findByExample(ex);
		if( listProject.size() == 0 || listProject == null )
			return 0;
		
		float sum = 0;
		for( int i=0; i<listProject.size();i++) 
			sum += listProject.get(i).getExpenditure();
		return sum;
	
	}
	
	public List<Expenditure> getDetail(String projectId, String str) {
		Expenditure instance = new Expenditure();
		instance.setProjectId(projectId);
		instance.setSubjectId(str);
		
		return expenditureDAO.findByExample(instance);
	}
	
	private Expenditure setExpenditureValue(Expenditure tmpEx,String _date,String _type,String _id,
			String _abstract,String _subject,String _sector,String _project,float _expense,float _loan) {
		tmpEx.setCertificateDate(_date);
		tmpEx.setType(_type);
		tmpEx.setCertificateId(_id);
		tmpEx.setAbstract_(_abstract);
		tmpEx.setSubjectId(_subject);
		tmpEx.setSector(_sector);
		tmpEx.setProjectId(_project);
		tmpEx.setExpenditure(_expense);
		tmpEx.setLoan(_loan);
		return tmpEx;
	}

	//getter and setter
	public ExpenditureDAO getExpenditureDAO() {
		return expenditureDAO;
	}
	public void setExpenditureDAO(ExpenditureDAO expenditureDAO) {
		this.expenditureDAO = expenditureDAO;
	}


	public static String getCertificateDate() {
		return CERTIFICATE_DATE;
	}


	public static String getType() {
		return TYPE;
	}


	public static String getCertificateId() {
		return CERTIFICATE_ID;
	}


	public static String getAbstract() {
		return ABSTRACT_;
	}


	public static String getSubjectId() {
		return SUBJECT_ID;
	}


	public static String getSector() {
		return SECTOR;
	}


	public static String getProjectId() {
		return PROJECT_ID;
	}


	public static String getExpenditure() {
		return EXPENDITURE;
	}


	public static String getLoan() {
		return LOAN;
	}


	
	
}

