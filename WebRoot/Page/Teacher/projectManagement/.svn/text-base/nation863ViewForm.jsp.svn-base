<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国家科技计划项目<863>概算表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
    
	<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	
	<script type="text/javascript" src="JS/teacher/projectManagement/nation863ViewForm.js"></script>
  
  	<script type="text/javascript" src="JS/common/fileUpload.js"></script>
  	
  	<script type="text/javascript" src="JS/common/PrintAndExcel.js"></script>
	
	
  	<style type="text/css">
  	
  	input {
  		width: 100px;
  		height:80%;
  	}
  	
  	td {
  		height:30px;
  	}
  	
  	</style>
  	
  	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPk")%>";
	   var indexOfBudget = "<%= request.getParameter("indexOfBudget")%>";
	</script>
  	
  </head>
  
    </head>
    <body>
    
  		<div align="center"  id="table" >
  		
  			<div style = "width:90%;" >
	  			<h2>国家科技计划项目预算表</h2>
	  			<br>
	  			<div>
	  				<table style = "width:100%;">
	  					<tr>
	  						<td>课题名称：<label id = "itemName"></label></td>
	  						<td>课题编号：<label id = "contractID"></label></td>
	  						<td>负责人：<label id = "teacherName"></label></td>
	  						<td>内款项码：<label id = "insideID"></label></td>
	  						<td>经费卡号：<label id = "cardID"></label></td>
	  					</tr>
	  				</table>
	  			</div>
	  			
	  			<div>
	  				<div style="float:left;">
	  					预算年度：
	  					<label id="startYear">年</label>
		            	&nbsp;&nbsp;至&nbsp;&nbsp;
		            	<label id="endYear">年</label>
	  				</div>
	  				
	  				<div style="float:right;">
	  					单位：万元
	  				</div>
	  			</div>
	  			
  				<br><br>
  					  				
	  			<div>
			       <form id = "nation863BudgetForm">
				        <table align = "center" style = "width:100%;" border="1" cellspacing="0" borderColor="#7EC0EE" id = "a863BudgetFormTable">
							<tr id = "tableHeaderTR" bgColor=#e2e4ff >
								<td rowspan="2">预算科目名称</td>
							</tr>
							<tr id = "cooperationNameTR">
								
							</tr>
							
							<tr id = "costSumTR" bgColor=#F0FFF0>
								<td>一.经费支出</td>
							</tr>
							<tr  id = "directCostTR">
								<td>&nbsp;（一）直接费用</td>
							</tr>
							<tr id = "equipmentCostTR">
								<td>&nbsp; &nbsp; 1.设备费</td>
							</tr>
							<tr id = "buyEquipmentTR">
								<td>&nbsp;&nbsp;&nbsp;&nbsp; (1)购置设备费</td>
							</tr>
							<tr id = "trialEquipmentTR">
								<td>&nbsp;&nbsp;&nbsp;&nbsp; (2)试制设备费</td>
							</tr>
							<tr id = "transformTR">
								<td>&nbsp;&nbsp;&nbsp;&nbsp; (3)设备改造与租赁费</td>
							</tr>
							<tr id = "materialCostTR">
								<td>&nbsp;&nbsp; 2.材料费</td>
							</tr>
							<tr id = "testCostTR">
								<td>&nbsp;&nbsp; 3.测试化验加工费</td>
							</tr>
							<tr id = "fuelCostTR">
								<td>&nbsp;&nbsp; 4.燃料动力费</td>
							</tr>
							<tr id = "travelCostTR">
								<td>&nbsp;&nbsp; 5.差旅费</td>
							</tr>
							<tr id = "conferenceCostTR">
								<td>&nbsp;&nbsp; 6.会议费</td>
							</tr>
							<tr id = "exchangeCostTR">
								<td>&nbsp;&nbsp; 7.国际合作与交流费</td>
							</tr>
							<tr id = "publishCostTR">
								<td>&nbsp;&nbsp; 8.出版/文献/信息传播/知识产权事务</td>
							</tr>
							<tr id = "serviceCostTR">
								<td>&nbsp;&nbsp; 9.劳务费</td>
							</tr>
							<tr id = "consultCostTR">
								<td>&nbsp;&nbsp; 10.咨询费</td>
							</tr>
							<tr id = "constructionCostTR">
								<td>&nbsp;&nbsp; 11.基本建设费</td>
							</tr>
							<tr id = "otherCostTR">
								<td>&nbsp;&nbsp; 12.其他支出</td>
							</tr>
							<tr id = "indirectCostTR">
								<td>&nbsp;（二）间接费用</td>
							</tr>
							<tr id = "performanceCostTR">
								<td>&nbsp;&nbsp; 其中：绩效支出</td>
							</tr>
							<tr id = "fundSumTR" bgColor=#F0FFF0>
								<td>二.经费来源</td>
							</tr>
							<tr id = "subsidizeSpecialTR">
								<td>&nbsp;(一)申请从专项经费获得的资助</td>
							</tr>
							<tr id = "selfFinanceTR">
								<td>&nbsp;(二)自筹经费来源</td>
							</tr>
							<tr id = "otherFundsSelfTR">
								<td>&nbsp;&nbsp; 1.其他财政拨款</td>
							</tr>
							<tr id = "ownFundsSelfTR">
								<td>&nbsp;&nbsp; 2.单位自有货币资金</td>
							</tr>
							<tr id = "otherSelfTR">
								<td>&nbsp;&nbsp; 3.其他资金</td>
							</tr>
			        	</table>
			        	
			       </form>
		        </div>
	        </div>
        </div>
        
        <!-- 上传部分   start -->	
	 	<div style="display: inline; width: 700px; padding-left:5%;">
		<div style="float:left; padding-left:5%;">
		<label>文件列表:</label><label id="uploadOutputResult"></label>
		</div>

		</div>
		<!-- 上传部分   end -->	
		
		
		<div align="center">
			<button type = "button"  onclick="myprint('table');" >打印表格</button>
			<button type = "button"  onclick="myexcel('table');" >导入到EXCEL</button>
		</div>
	
		
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
  </body>
</html>
