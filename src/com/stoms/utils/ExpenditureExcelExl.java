package com.stoms.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExpenditureExcelExl {

	private final static String DATE = "凭证日期";
	private final static String TYPE = "证类";
	private final static String	ID = "凭证编号";
	private final static String	ABSTRACT = "摘要";
	private final static String	SUBJECT_ID = "科目编号";
	private final static String	SECTOR = "部门编号";
	private final static String	PROJECT_ID = "项目编号";
	private final static String	ENPENDITURE = "借金额";
	private final static String	LOAN = "贷金额";
	
	public static List<ArrayList<String>> readExl(String sourceFile) throws Exception {
		InputStream fs = new FileInputStream(sourceFile);
		Workbook workBook = Workbook.getWorkbook(fs);

		Sheet sheet = workBook.getSheet(0);
//		System.out.println("共有：" + sheet.getColumns() + " columns");
//		System.out.println("共有：" + sheet.getRows() + " rows");

		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		boolean readFlag = false;
		int index = 0; //读取有效行数
		int idxDate=-1,idxType=-1,idxId=-1,idxAbstract=-1,idxSubject=-1,idxSector=-1,idxProject=-1,idxExpenditure=-1,idxLoan=-1;
		String project = ""; 
		int uselessRow = -1;

		for (int i = 0; i < sheet.getRows(); i++) {
			ArrayList<String> tmpList = new ArrayList<String>();
			for (int j = 0; j < sheet.getColumns(); j++) {
				Cell cell = sheet.getCell(j, i);
				String content = cell.getContents();
				if( !readFlag ) {
					index = i;
					if(  content.contains(DATE) ) {
						idxDate = j;
					} 
					if(  content.contains(TYPE) ) {
						idxType = j;
					} 
					if(  content.contains(ID) ) {
						idxId = j;
					} 
					if(  content.contains(ABSTRACT) ) {
						idxAbstract = j;
					} 
					if(  content.contains(SUBJECT_ID) ) {
						idxSubject = j;
					} 
					if(  content.contains(SECTOR) ) {
						idxSector = j;
					} 
					if(content.contains(PROJECT_ID)) {
						idxProject = j;
					} 
					if(content.contains(ENPENDITURE)) {
						idxExpenditure = j;
					}
					if(content.contains(LOAN)) {
						idxLoan = j;
					}
					if( idxDate >=0 && idxType >=0 && idxId >=0 && idxAbstract >=0 && 
							idxSubject >=0 && idxSector >=0 && idxProject >=0 && idxExpenditure >=0 && idxLoan >=0  )
						readFlag = true;
				}
				if(i == uselessRow)
					continue;
				if( i > index && readFlag == true) { 
					if(content.contains("—")) {
						uselessRow = i; 
						continue;
					}
					if(idxDate == j  || idxType  == j || idxId == j || idxAbstract  == j) {
						tmpList.add(content);
					} else if( j == idxSubject ) {
						tmpList.add(content);
					} else if (idxSector == j) {
						tmpList.add(content);
					} else if( j == idxProject ) {
						if( i == index+1 )
							project = content; //保存全局项目号
						if( !content.matches("^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$") ) 
							tmpList.add(project);
						else
							tmpList.add(content);
					} else if( j == idxExpenditure || idxLoan == j) 
						tmpList.add(content);
				}
			}
			if(tmpList.size() != 0 && tmpList != null)
				list.add(tmpList);
		}

//		for(int i=0;i<list.size();i++) {
//			ArrayList<String> tmp = list.get(i);
//			for(int j=0 ;j < tmp.size();j++) {
//				System.out.print(tmp.get(j)+"\t");
//			}
//			System.out.println();
//		}

		workBook.close();
		fs.close();
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		ExpenditureExcelExl.readExl("data/0204113106.XLS");
	}


}
