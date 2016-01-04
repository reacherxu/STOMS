<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国家基金预算表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 	<link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
    
	<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JS/teacher/projectManagement/nationalFundBudgetView.js"></script>
	
	<script type="text/javascript" src="JS/common/fileUpload.js"></script>
	
	<script type="text/javascript" src="JS/common/PrintAndExcel.js"></script>
	
	
	<style type="text/css">
  	label {
  		width: 148px;
  	}
  	input {
  		width: 100px;
  	}
  	
  	textarea {
  		width: 120px;
  		height: 30px;
  	}
  	
  	</style>
	
	
	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPk")%>";
	</script>
  </head>
  
  <body>
  
    <div align="center" id="table" >
		<table align="center" style = "width:80%;" border="1" cellspacing="0" borderColor="#7EC0EE">
			<caption><h2>国家基金预算表</h2></caption>			
			<tr>
				<td width="55%"><label for = "itemName">项目(课题)名称</label></td>
				<td width="45%" colspan="2"><label id = "itemName"></label></td>
			</tr>
			<tr>
				<td><label for = "teacherName">负责人</label></td>
				<td colspan="2"><label id = "teacherName"></label></td>
			</tr>
			<tr>
				<td><label for = "approveID">批准号</label></td>
				<td  colspan="2"><label id = "approveID"></label></td>
			</tr>
			<tr>
				<td><label for = "dialFundsSum">已拨入经费(总额)</label></td>
				<td colspan="2"><label id = "dialFundsSum"></label></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td width="30%"><b>科目</b></td>
				<td width="30%"><b>预算经费</b></td>
				<td width="40%"><b>说明</b></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>一.研究经费</b></td>
				<td><label id = "studyFund_Budget"></label></td>
				<td><textarea id = "studyFund_Remark"></textarea></td>
			</tr>
			<tr>
				<td>1.科研业务费</td>
				<td><label id = "sumBusiness_Budget"></label></td>
				<td><textarea id = "sumBusiness_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(1)测试/计算/分析费</td>
				<td><label id = "testCost_Budget"></label></td>
				<td><textarea id = "testCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(2)能源/动力费</td>
				<td><label id = "fuelCost_Budget"></label></td>
				<td><textarea id = "fuelCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(3)会议费/差旅费</td>
				<td><label id = "conferenceCost_Budget"></label></td>
				<td><textarea id = "conferenceCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(4)出版物/文献/信息传播事务费</td>
				<td><label id = "publishCost_Budget"></label></td>
				<td><textarea id = "publishCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(5)其他</td>
				<td><label id = "otherBusiness_Budget"></label></td>
				<td><textarea id = "otherBusiness_Remark"></textarea></td>
			</tr>
			<tr>
				<td>2.实验材料费</td>
				<td><label id = "sumMaterial_Budget"></label></td>
				<td><textarea id = "sumMaterial_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(1)原材料/试剂/药品购置费</td>
				<td><label id = "rawMaterial_Budget"></label></td>
				<td><textarea id = "rawMaterial_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(2)其他</td>
				<td><label id = "otherMaterial_Budget"></label></td>
				<td><textarea id = "otherMaterial_Remark"></textarea></td>
			</tr>
			<tr>
				<td>3.仪器设备费</td>
				<td><label id = "sumEquipment_Budget"></label></td>
				<td><textarea id = "sumEquipment_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(1)购置</td>
				<td><label id = "buyEquipment_Budget"></label></td>
				<td><textarea id = "buyEquipment_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(2)试制</td>
				<td><label id = "trialEquipment_Budget"></label></td>
				<td><textarea id = "trialEquipment_Remark"></textarea></td>
			</tr>
			<tr>
				<td>4.实验室改装费</td>
				<td><label id = "laboratory_Budget"></label></td>
				<td><textarea id = "laboratory_Remark"></textarea></td>
			</tr>
			<tr>
				<td>5.协作费</td>
				<td><label id = "cooperation_Budget"></label></td>
				<td><textarea id = "cooperation_Remark"></textarea></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>二.国际合作与交流费</b></td>
				<td><label id = "exchangeSum_Budget"></label></td>
				<td><textarea id = "exchangeSum_Remark"></textarea></td>
			</tr>
			<tr>
				<td>1.项目组成员出国合作交流</td>
				<td><label id = "exchange_Budget"></label></td>
				<td><textarea id = "exchange_Remark"></textarea></td>
			</tr>
			<tr>
				<td>2.境外专家来华合作交流</td>
				<td><label id = "expert_Budget"></label></td>
				<td><textarea id = "expert__Remark"></textarea></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>三.劳务费</b></td>
				<td><label id = "serviceCost_Budget"></label></td>
				<td><textarea id = "serviceCost_Remark"></textarea></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>四.管理费</b></td>
				<td><label id = "manageCost_Budget"></label></td>
				<td><textarea id = "manageCost_Remark"></textarea></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>合计</b></td>
				<td><label id = "sums_Budget"></label></td>
				<td><textarea id = "sums_Remark"></textarea></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>本项目其他经费来源</b></td>
				<td colspan="2"><b>预算经费</b></td>
			</tr>
			<tr>
				<td>国家其他计划资助经费</td>
				<td colspan="2"><label id = "otherPlanFundsBuget"></label></td>
			</tr>
			<tr>
				<td>其他经费资助（含部门匹配）</td>
				<td colspan="2"><label id = "otherSubsidizeBuget"></label></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>其他经费来源合计</b></td>
				<td colspan="2"><label id = "otherSumBuget"></label></td>		
			</tr>
	
		</table>
		</div>
		
		<!-- 上传部分   start -->	
	 	<div style="display: inline; width: 700px; padding-left:10%;">
		<div style="float:left; padding-left:10%;">
		<label>文件列表:</label><label id="uploadOutputResult"></label>
		</div>

		</div>
		<!-- 上传部分   end -->	
		
		<div align="center">
			<input type="button" value="打印表格" onclick="myprint('table')" />
			<input type="button" onclick="myexcel('table');"  value="导入到EXCEL">
		</div>
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
  </body>
</html>
