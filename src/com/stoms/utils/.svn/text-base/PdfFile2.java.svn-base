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
  
public class PdfFile2{     
  
	AddOutlay addoutlay;
	public PdfFile2() {
		super();
		this.addoutlay = new AddOutlay();
	}
	/**
	 * 获取指定页1, 2,5页的内容   并保存文件
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
        writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf_page1"));
        stripper.setStartPage( 1 );
        stripper.setEndPage(1);
        stripper.writeText(pdd, writer);
        writer.flush();
        writer.close();
        //写第7、8页  
        writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf_page78"));
        stripper.setStartPage(7);
        stripper.setEndPage(8);
        stripper.writeText(pdd, writer);
        writer.flush();
        writer.close();
        
        pdd.close();     
//        return c;     
    }   
    /**
     * 指定的第1页当中的内容
     */
    public void getPage1(String uploadPath) throws Exception {
    	BufferedReader reader = new BufferedReader(new FileReader(uploadPath+"/pdf_page1"));
    	BufferedWriter writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf_page1_content"));
    	
    	String line = null;
    	while( (line = reader.readLine()) != null ) {
    		System.out.println(line);
    		if( line.contains("项 目 编 号")) {
    			String[] contractId = line.split("\\s");
    			System.out.println("1:"+contractId[5]);
    			addoutlay.setContractId(contractId[5].trim());
    			writer.write("合同编号："+line);
    			writer.newLine();
    		}else if( line.contains("项 目 名 称")) {
    			String itemname = line+reader.readLine()+reader.readLine();
    			int start = itemname.indexOf("项 目 名 称");
    			int end = itemname.indexOf("项 目 类 别");
    			itemname = itemname.substring(start+7, end);
    			System.out.println("2:"+itemname.trim());
    			addoutlay.setItemName(itemname.trim());
    			writer.write("项目名称："+line);
    			writer.newLine();
    		}else if( line.contains("起 止 年 限")) {
    			String qian = line.substring(6, line.indexOf("月"));
    			String hou = line.substring(line.indexOf("至"),line.length());
    			
    			String startDateYear = qian.substring(qian.indexOf("限")+1,qian.indexOf("年"));
    			String startDateMonth = qian.substring(qian.indexOf("年")+1,qian.length());
    			String startDate = startDateYear.trim()+"-"+dealMonth(startDateMonth.trim())+"-01";
    			
    			String endDateYear = hou.substring(hou.indexOf("至")+1,hou.indexOf("年"));
    			String endDateMonth = hou.substring(hou.indexOf("年")+1,hou.indexOf("月"));
    			String endDate = endDateYear.trim()+"-"+dealMonth(endDateMonth.trim())+"-01";
    			
    			System.out.println("3:"+startDate);
    			System.out.println("4:"+endDate);
    			addoutlay.setInvoiceTitle(startDate);//invoiceTitle存开始日期
    			addoutlay.setInvoiceDetail(endDate);//invocieDetail存结束日期
    			writer.write("项目开始时间："+startDate);
    			writer.write("项目结束时间："+endDate);
    			writer.newLine();
    		}else if( line.contains("项目负责人")) {
    			String teacher = line.substring(line.indexOf("项目负责人")+5,line.indexOf("电话及手机"));
    			System.out.println("5:"+teacher.trim());
    			addoutlay.setTeacherName(teacher.trim());
    			writer.write("入账人姓名："+teacher.trim());
    			writer.newLine();
    			line = reader.readLine();
    			String otherTeacher = line.substring(0,line.indexOf("电话及手机"));
    			if(otherTeacher.trim().length()!=0){
    				System.out.println("5.2:"+otherTeacher.trim());
        			addoutlay.setOtherTeacher(otherTeacher.trim());
        			writer.write("入账人姓名2："+otherTeacher.trim());
        			writer.newLine();
    			}
    		}else if( line.contains("承担单位")) {
    			String departmentName = line.substring(line.indexOf("承担单位")+4,line.length());
    			departmentName = departmentName.substring(departmentName.indexOf("南京大学")+4, departmentName.length());
    			System.out.println("6:"+departmentName.trim());
    			addoutlay.setDepartmentName(departmentName.trim());
    			writer.write("院系："+departmentName.trim());
    			writer.newLine();
    		}
    	}
    	System.out.println("------------------");
    	reader.close();
    	writer.flush();
        writer.close();
    }
   
    public String dealMonth(String s){
    	String s1="";
    	if(Integer.parseInt(s)<10){
    		s1="0"+s;
    	}else{
    		s1=s;
    	}
    	return s1;
    }
    /**
     * 指定的第7、8页当中的内容
     */
    public void getPage78(String uploadPath) throws Exception {
    	BufferedReader reader = new BufferedReader(new FileReader(uploadPath+"/pdf_page78"));
    	BufferedWriter writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf_page78_content"));
    	
    	String line = null;
    	boolean start = false;//确定开始写经费
    	while( (line = reader.readLine()) != null ) {
    		if(line.contains("五、项目经费预算")) 
    			start = true;
    		else if(line.contains("六、其他条款"))
    			start = false;
    		if(start) {  //colomn1 与column2之间有2个空格  而column2与column3之间只有一个空格！！
    			if(line.contains("合计")){
    				line = reader.readLine();
    				String[] totalValue = line.split("\\s");
    				System.out.println("6--7--:"+Double.parseDouble(totalValue[2].trim())*10000);
    				addoutlay.setOutlayValue(Double.parseDouble(totalValue[2].trim())*10000);
    				writer.write("总金额："+Double.parseDouble(totalValue[2].trim())*10000);
    				writer.newLine();
    			}else if( line.contains("直接费用")) {
        			String[] directFee = line.trim().split("\\s");
        			System.out.println("7:"+Double.parseDouble(directFee[2])*10000);
        			addoutlay.setDirectValue(Double.parseDouble(directFee[2])*10000);
        			writer.write("直接费用："+Double.parseDouble(directFee[2])*10000);
        			writer.newLine();
        		}else if( line.contains("购置设备费")) {
        			String[] equipment = line.trim().split("\\s");
        			System.out.println("8:"+Double.parseDouble(equipment[2])*10000);
        			addoutlay.setEquipment(Double.parseDouble(equipment[2])*10000);
        			writer.write("购置设备费："+Double.parseDouble(equipment[2])*10000);
        			writer.newLine();
        		}else if( line.contains("9、劳务费")) {
        			String[] pay = line.trim().split("\\s");
        			System.out.println("9:"+Double.parseDouble(pay[2])*10000);
        			addoutlay.setPay(Double.parseDouble(pay[2])*10000);
        			writer.write("劳务费："+Double.parseDouble(pay[2])*10000);
        			writer.newLine();
        		}else if( line.contains("专家咨询费")) {
        			String[] consult = line.trim().split("\\s");
        			System.out.println("10:"+Double.parseDouble(consult[2])*10000);
        			addoutlay.setConsult(Double.parseDouble(consult[2])*10000);
        			writer.write("专家咨询费："+Double.parseDouble(consult[2])*10000);
        			writer.newLine();
        		}else if( line.contains("间接费用")) {
        			String[] indirectValue = line.trim().split("\\s");
        			System.out.println("11:"+Double.parseDouble(indirectValue[2])*10000);
        			addoutlay.setIndirectValue(Double.parseDouble(indirectValue[2])*10000);
        			writer.write("间接费用："+Double.parseDouble(indirectValue[2])*10000);
        			writer.newLine();
        		}else if( line.contains("绩效支出")) {
        			String[] performance = line.trim().split("\\s");
        			System.out.println("12:"+Double.parseDouble(performance[2])*10000);
        			addoutlay.setPerformance(Double.parseDouble(performance[2])*10000);
        			writer.write("绩效支出间接费用："+Double.parseDouble(performance[2])*10000);
        			writer.newLine();
        			start = false;
        		}
    		}
    	}
    	reader.close();
    	writer.flush();
        writer.close();
    }
    
    public static void main(String args[]) throws Exception{
    	new PdfFile2().getData("d:/STOMS_FileData_temp/", "sheng.pdf");
    }
    
    public AddOutlay getData(String uploadPath,String filePath) throws Exception {
    	//String uploadPath = "E://JSP//workspace//.metadata//.plugins//com.genuitec.eclipse.easie.tomcat.myeclipse//tomcat//webapps//STOMS//upload";
		File file = new File(uploadPath+"/"+filePath);
		getContent(file,uploadPath);
		getPage1(uploadPath);
		getPage78(uploadPath);
		return addoutlay;
	}
	public AddOutlay getAddoutlay() {
		return addoutlay;
	}
	public void setAddoutlay(AddOutlay addoutlay) {
		this.addoutlay = addoutlay;
	}
}