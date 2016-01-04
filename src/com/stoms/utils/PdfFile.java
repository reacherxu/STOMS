package com.stoms.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import com.stoms.model.AddOutlay;
  
public class PdfFile{     
  
	AddOutlay addoutlay;
	Map<String,String> budget ;
	
	public PdfFile() {
		super();
		addoutlay = new AddOutlay();
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
        //写第4页  不能判定4,5页谁是  预算
        writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf1_page4"));
        stripper.setStartPage( 4 );
        stripper.setEndPage(5);
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
    				//System.out.println("start------------------");
    				//System.out.println("合同编号："+line);
        			addoutlay.setContractId(line.trim());
        			writer.write("合同编号："+line);
        			writer.newLine();
        			break;
    			}
    		}
//    		//System.out.println("line:"+line);
    		if( line.contains("国家自然科学基金委员会")) {
//    			String contractId = line.split("\\s")[1];
//    			//System.out.println(contractId);
//    			addoutlay.setContractId(contractId);
//    			writer.write("受理编号: "+contractId);
//    			writer.newLine();
    			line = reader.readLine();
    			//System.out.println("start------------------");
    			//System.out.println("合同编号："+line);
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
    				//System.out.println("----姓名:"+name);
        			addoutlay.setTeacherName(name);
        			writer.write("---姓名 "+name);
    			}else{
    				line = reader.readLine();
        			String name = line.trim();
        			//System.out.println("----姓名:"+name);
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
    			//System.out.println("----工作单位:"+departmentName);
    			addoutlay.setDepartmentName(departmentName);
    			writer.write("---工作单位 "+departmentName);
    			writer.newLine();
    		} else if(line.contains("项目名称")) {
    			line=line.substring(line.indexOf("项目名称")+4, line.length());
    			if(line.trim().length() == 0){
    				line = reader.readLine();
        			String project = line.trim();
        			//System.out.println("----项目名称:"+project);
        			addoutlay.setItemName(project);
        			writer.write("---项目名称 "+project);
    			}else{
    				//System.out.println("---项目名称："+line);
        			addoutlay.setItemName(line.trim());
        			writer.write("---项目名称："+line);
    			}
    			writer.newLine();
    		} else if(line.contains("研究期限")) {
//    			String period = line.split("\\s",2)[1];
//    			//System.out.println(period);
//    			String period2[] = period.split("\\s");
////    			for(String s:period2){
////    				//System.out.println("~~:"+s);
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
	    			
	    			//System.out.println("----3:"+startDate);
	    			//System.out.println("----4:"+endDate);
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
	    			
	    			//System.out.println("----3:"+startDate);
	    			//System.out.println("----4:"+endDate);
	    			addoutlay.setInvoiceTitle(startDate);//invoiceTitle存开始日期
	    			addoutlay.setInvoiceDetail(endDate);//invocieDetail存结束日期
	    			writer.write("---项目开始时间："+startDate);
	    			writer.write("---项目结束时间："+endDate);
    			}
    			writer.newLine();
    		} else if(line.contains("申请经费")) {
    			String expenditure = line.substring(line.indexOf("申请经费")+4, line.indexOf("万元"));
    			//System.out.println("----申请经费:"+expenditure.trim());
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
     * 判断项目那些是要统计的经费
     * @param line
     * @return
     */
    public static boolean judgeRow(String line) {
    	boolean result = false;
    	line = line.trim();
    	if(line.startsWith("（") || line.startsWith("(")) {
    		String second = line.substring(1).trim();
    		if(second.substring(0, 1).matches("\\d")) {
    			String third = second.substring(1).trim();
    			if(third.startsWith("）") || third.startsWith(")")) {
    				result = true;
    			}
    		}
    	} else {
    		result = false;
    	}
    	return result;
    }
    
    public static String[] seperateNum(String line) {
		String result[] = new String[2];
		result[0] = "";
		result[1] = "";
		
		String tmp[] = line.split("\\s") ;
		for(int i=0;i<tmp.length;i++) {
			tmp[i] = tmp[i].trim();
		}
		for(int i=0;i<tmp.length;i++) {
			tmp[i] = tmp[i].trim();
			if(tmp[i].matches("^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$") && i>= 1) {
				result[1] = tmp[i];
				break; //后面的不要了
			} else {
				result[0] += tmp[i];
			}
		}
		return result;
	}
    /**
     * 指定的第五页当中的内容
     */
    public void getPage5(String uploadPath) throws Exception {
    	BufferedReader reader = new BufferedReader(new FileReader(uploadPath+"/pdf1_page5"));
    	if(reader.readLine().contains("国家自然科学基金申请书")) {  //预读一行  判定是不是预算页
    		reader.close();
    		reader = new BufferedReader(new FileReader(uploadPath+"/pdf1_page5"));
    	} else {
    		reader.close();
    		reader = new BufferedReader(new FileReader(uploadPath+"/pdf1_page4"));
    	}
    	BufferedWriter writer = new BufferedWriter(new FileWriter(uploadPath+"/pdf1_page5_content"));
    	
    	String line = null;
    	boolean start = false;//确定开始写经费
    	while( (line = reader.readLine()) != null ) {
    		if(line.contains("研究经费")) 
    			start = true;
    		else if(line.contains("与本项目相关的"))
    			start = false;
    		if(start) {  
    			if(line.length() < 3)
    				continue;
    			if(line.substring(0,1).matches("[\\d一二三四合]") || judgeRow(line) ) {
    				if( !line.contains("研究经费") &&
    						!line.contains("科研业务费") &&
    						!line.contains("测试") &&
    						!line.contains("能源") &&
    						!line.contains("会议费") &&
    						!line.contains("出版物") &&
    						!line.contains("其他") &&
    						!line.contains("实验材料费") &&
    						!line.contains("实验室材料费") &&
    						!line.contains("原材料") &&
    						!line.contains("仪器设备费") &&
    						!line.contains("购置") &&
    						!line.contains("试制") &&
    						!line.contains("实验室改装费") &&
    						!line.contains("协作") && 
    						!line.contains("国际合作与交流费") &&
    						!line.contains("项目组成员出国合作交流") &&
    						!line.contains("境外专家来华合作交流") &&
    						!line.contains("劳务费") &&
    						!line.contains("管理费") &&
    						!line.contains("合") )
    						continue; //不能解决的情况
    				String tmp[] = seperateNum(line);
    				System.out.println(tmp[0]+"\t"+tmp[1]);
    				writer.write(tmp[0] + "\t" +tmp[1]);
    				writer.newLine();
    			}
    		}
    	}
    	reader.close();
    	writer.flush();
        writer.close();
        
        int lineCount = 1;
        reader = new BufferedReader(new FileReader(uploadPath+"/pdf1_page5_content"));
    	while( (line = reader.readLine()) != null ) {
    		String fare = line.split("\t",2)[1];
    		if(fare == null)
    			fare = "";
			switch (lineCount) {
			case 1:
				addoutlay.setStudyOutlay(fare);
				break;
			case 2:
				addoutlay.setStudyOutlay_sr(fare);
				break;
			case 3:
				addoutlay.setStudyOutlay_sr_test(fare);
				break;
			case 4:
				addoutlay.setStudyOutlay_sr_energy(fare);
				break;
			case 5:
				addoutlay.setStudyOutlay_sr_meeting(fare);
				break;
			case 6:
				addoutlay.setStudyOutlay_sr_publish(fare);
				break;
			case 7:
				addoutlay.setStudyOutlay_sr_other(fare);
				break;
			case 8:
				addoutlay.setStudyOutlay_em(fare);
				break;
			case 9:
				addoutlay.setStudyOutlay_em_material(fare);
				break;
			case 10:
				addoutlay.setStudyOutlay_em_other(fare);
				break;
			case 11:
				addoutlay.setStudyOutlay_ei(fare);
				break;
			case 12:
				addoutlay.setStudyOutlay_ei_purchase(fare);
				break;
			case 13:
				addoutlay.setStudyOutlay_ei_produce(fare);
				break;
			case 14:
				addoutlay.setStudyOutlay_lr(fare);
				break;
			case 15:
				addoutlay.setStudyOutlay_colaborate(fare);
				break;
			case 16:
				addoutlay.setInternational(fare);
				break;
			case 17:
				addoutlay.setInternational_1(fare);
				break;
			case 18:
				addoutlay.setInternational_2(fare);
				break;
			case 19:
				addoutlay.setService(fare);
				break;
			case 20:
				addoutlay.setManagement(fare);
				break;
			case 21:
				addoutlay.setSum(fare);
				break;
			}
			lineCount ++;
    	}
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
		getPage5(uploadPath);
		return addoutlay;
	}
	public AddOutlay getAddoutlay() {
		return addoutlay;
	}
	public void setAddoutlay(AddOutlay addoutlay) {
		this.addoutlay = addoutlay;
	}
}