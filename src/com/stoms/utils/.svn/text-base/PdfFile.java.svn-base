package com.stoms.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.struts2.ServletActionContext;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.stoms.dao.DepartmentDAO;
import com.stoms.model.AddOutlay;
import com.stoms.model.Department;
  
public class PdfFile{     
  
	AddOutlay addoutlay;
	public PdfFile() {
		super();
		this.addoutlay = new AddOutlay();
	}
	/**
	 * 获取指定页 1,2,5页的内容   并保存文件
	 * @param f
	 * @throws Exception
	 */
    public void getContent(File f,String uploadPath) throws Exception { 
    	BufferedWriter writer = null;
    	
        PDFParser p = new PDFParser(new FileInputStream(f));     
        p.parse();  
        
        PDDocument pdd = p.getPDDocument();  
        PDFTextStripper stripper = new PDFTextStripper(); 
        //写第1页  
        writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf1_page1"));
        stripper.setStartPage(1);
        stripper.setEndPage(1);
        stripper.writeText(pdd, writer);
        writer.flush();
        writer.close();
        //写第2页  
        writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf1_page2"));
        stripper.setStartPage( 2 );
        stripper.setEndPage(2);
        stripper.writeText(pdd, writer);
        writer.flush();
        writer.close();
        //写第5页
        writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf1_page5"));
        stripper.setStartPage( 5 );
        stripper.setEndPage(5);
        stripper.writeText(pdd, writer);
        writer.flush();
        writer.close();
//        String c = stripper.getText(pdd);   
        
        pdd.close();     
//        return c;     
    }   
    /**
     * 指定的第1页当中的内容
     */
    public void getPage1(String uploadPath) throws Exception {
    	BufferedReader reader = new BufferedReader(new FileReader(uploadPath+"/pdf1_page1"));
    	BufferedWriter writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf1_page1_content"));
    	
    	String line = null;
    	while( (line = reader.readLine()) != null ) {
    		if(line.contains("受理编号")){
    			line=line.substring(line.indexOf("受理编号")+4, line.length());
    			if(line.trim().length() == 0){
    				continue;
    			}else{
    				System.out.println("start------------------");
    				System.out.println("合同编号："+line);
        			addoutlay.setContractId(line.trim());
        			writer.write("合同编号："+line);
        			writer.newLine();
        			break;
    			}
    		}
//    		System.out.println("line:"+line);
    		if( line.contains("国家自然科学基金委员会")) {
//    			String contractId = line.split("\\s")[1];
//    			System.out.println(contractId);
//    			addoutlay.setContractId(contractId);
//    			writer.write("受理编号: "+contractId);
//    			writer.newLine();
    			line = reader.readLine();
    			System.out.println("start------------------");
    			System.out.println("合同编号："+line);
    			addoutlay.setContractId(line.trim());
    			writer.write("合同编号："+line);
    			writer.newLine();
    		}
    	}
    	reader.close();
    	writer.flush();
        writer.close();
    }
    /**
     * 指定的第二页当中的内容
     * 		若页面的相对行数固定   可以直接获取对应的行数！！
     */
    public void getPage2(String uploadPath) throws Exception {
    	BufferedReader reader = new BufferedReader(new FileReader(uploadPath+"/pdf1_page2"));
    	BufferedWriter writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf1_page2_content"));
    	
    	String line = null;
    	while( (line = reader.readLine()) != null ) {
    		if( line.contains("姓") && line.contains("名")) {
    			if(line.contains("性别")){
    				String name = line.substring(line.indexOf("名")+1,line.indexOf("性别")).trim();
    				System.out.println("----姓名:"+name);
        			addoutlay.setTeacherName(name);
        			writer.write("---姓名 "+name);
    			}else{
    				line = reader.readLine();
        			String name = line.trim();
        			System.out.println("----姓名:"+name);
        			addoutlay.setTeacherName(name);
        			writer.write("---姓名 "+name);
    			}
    			writer.newLine();
    		} else if(line.contains("工") && line.contains("作") && line.contains("单") && line.contains("位")) {
    			String workspace = line.split("\\s",2)[1];
    			String departmentName = "";
    			if(workspace.contains("-")){
    				departmentName = (workspace.split("-")[1]).trim();
    			}else if(workspace.contains("/")){
    				departmentName = (workspace.split("/")[1]).trim();
    			}else{
    				departmentName = "";
    			}
    			System.out.println("----工作单位:"+departmentName);
    			addoutlay.setDepartmentName(departmentName);
    			writer.write("---工作单位 "+departmentName);
    			writer.newLine();
    		} else if(line.contains("项目名称")) {
    			line=line.substring(line.indexOf("项目名称")+4, line.length());
    			if(line.trim().length() == 0){
    				line = reader.readLine();
        			String project = line.trim();
        			System.out.println("----项目名称:"+project);
        			addoutlay.setItemName(project);
        			writer.write("---项目名称 "+project);
    			}else{
    				System.out.println("---项目名称："+line);
        			addoutlay.setItemName(line.trim());
        			writer.write("---项目名称："+line);
    			}
    			writer.newLine();
    		} else if(line.contains("研究期限")) {
//    			String period = line.split("\\s",2)[1];
//    			System.out.println(period);
//    			String period2[] = period.split("\\s");
////    			for(String s:period2){
////    				System.out.println("~~:"+s);
////    			}
//    			String startDate = period2[1]+"-"+dealMonth(period2[3])+"-01";
//    			String endDate = period2[7]+"-"+dealMonth(period2[9])+"-01";
//    			addoutlay.setInvoiceTitle(startDate);//
//    			addoutlay.setInvoiceDetail(endDate);//
//    			writer.write("研究期限 "+period);
//    			writer.newLine();
    			if(line.contains("—")){
	    			String qian = line.substring(line.indexOf("研究期限")+4, line.indexOf("月"));
	    			String hou = line.substring(line.lastIndexOf("—"),line.length());
	    			
	    			String startDateYear = qian.substring(qian.indexOf("限")+1,qian.indexOf("年"));
	    			String startDateMonth = qian.substring(qian.indexOf("年")+1,qian.length());
	    			String startDate = startDateYear.trim()+"-"+dealMonth(startDateMonth.trim())+"-01";
	    			
	    			String endDateYear = hou.substring(hou.indexOf("—")+1,hou.indexOf("年"));
	    			String endDateMonth = hou.substring(hou.indexOf("年")+1,hou.indexOf("月"));
	    			String endDate = endDateYear.trim()+"-"+dealMonth(endDateMonth.trim())+"-01";
	    			
	    			System.out.println("----3:"+startDate);
	    			System.out.println("----4:"+endDate);
	    			addoutlay.setInvoiceTitle(startDate);//invoiceTitle存开始日期
	    			addoutlay.setInvoiceDetail(endDate);//invocieDetail存结束日期
	    			writer.write("---项目开始时间："+startDate);
	    			writer.write("---项目结束时间："+endDate);
    			}else if(line.contains("--")){
    				String qian = line.substring(line.indexOf("研究期限")+4, line.indexOf("月"));
	    			String hou = line.substring(line.lastIndexOf("--"),line.length());
	    			
	    			String startDateYear = qian.substring(qian.indexOf("限")+1,qian.indexOf("年"));
	    			String startDateMonth = qian.substring(qian.indexOf("年")+1,qian.length());
	    			String startDate = startDateYear.trim()+"-"+dealMonth(startDateMonth.trim())+"-01";
	    			
	    			String endDateYear = hou.substring(hou.indexOf("--")+2,hou.indexOf("年"));
	    			String endDateMonth = hou.substring(hou.indexOf("年")+1,hou.indexOf("月"));
	    			String endDate = endDateYear.trim()+"-"+dealMonth(endDateMonth.trim())+"-01";
	    			
	    			System.out.println("----3:"+startDate);
	    			System.out.println("----4:"+endDate);
	    			addoutlay.setInvoiceTitle(startDate);//invoiceTitle存开始日期
	    			addoutlay.setInvoiceDetail(endDate);//invocieDetail存结束日期
	    			writer.write("---项目开始时间："+startDate);
	    			writer.write("---项目结束时间："+endDate);
    			}
    			writer.newLine();
    		} else if(line.contains("申请经费")) {
    			String expenditure = line.substring(line.indexOf("申请经费")+4, line.indexOf("万元"));
    			System.out.println("----申请经费:"+expenditure.trim());
    			addoutlay.setOutlayValue(Double.parseDouble(expenditure.trim()));
    			writer.write("---申请经费 "+expenditure);
    			writer.newLine();
    		}
    	}
    	reader.close();
    	writer.flush();
        writer.close();
    }

    public String dealMonth(String s){
    	String s1="";
    	if(s.length()==1 && Integer.parseInt(s)<10){
        	s1="0"+s;
    	}else{
    		s1=s;
    	}
    	
    	return s1;
    }
    /**
     * 指定的第五页当中的内容
     */
    public void getPage5(String uploadPath) throws Exception {
    	BufferedReader reader = new BufferedReader(new FileReader(uploadPath+"/pdf1_page5"));
    	BufferedWriter writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf1_page5_content"));
    	
    	String line = null;
    	boolean start = false;//确定开始写经费
    	while( (line = reader.readLine()) != null ) {
    		if(line.contains("研究经费")) 
    			start = true;
    		else if(line.contains("与本项目相关的"))
    			start = false;
    		if(start) {  //colomn1 与column2之间有2个空格  而column2与column3之间只有一个空格！！
    			String tmp[] = line.split("  ",2);
    			for(int i=0;i<tmp.length;i++)
    				tmp[i] = tmp[i].trim();
    			if(tmp.length == 1) { //后面什么也没有的情况
    				System.out.println("~~~A:"+tmp[0]);
    				writer.write(tmp[0]);
    				writer.newLine();
    			} else if(tmp.length == 2) { 
    				if(tmp[1].contains("计  25.0000")) {
        				System.out.println("~~~B:"+tmp[0] + " " +tmp[1] );
        				writer.write(tmp[0] + " " +tmp[1] );
        				writer.newLine();
    				} else {
    					if(tmp[1].contains("项目组成员出国合作交"))
    						System.out.println("~~~C:");
    					String expenditure = tmp[1].split(" ")[0];
    					writer.write(tmp[0] + " " +expenditure );
    					writer.newLine();
    				}
    			}
    		}
    	}
    	reader.close();
    	writer.flush();
        writer.close();
    }
    
    public static void main(String args[]) throws Exception{
    	new PdfFile().getData("d:/STOMS_FileData_temp/", "GuoJia.pdf");
    }
    
    public AddOutlay getData(String uploadPath,String filePath) throws Exception {
    	//String uploadPath = "E://JSP//workspace//.metadata//.plugins//com.genuitec.eclipse.easie.tomcat.myeclipse//tomcat//webapps//STOMS//upload";
		File file = new File(uploadPath+"/"+filePath);
		getContent(file,uploadPath);
		getPage1(uploadPath);
		getPage2(uploadPath);
		//getPage5(uploadPath);
		return addoutlay;
	}
	public AddOutlay getAddoutlay() {
		return addoutlay;
	}
	public void setAddoutlay(AddOutlay addoutlay) {
		this.addoutlay = addoutlay;
	}
}