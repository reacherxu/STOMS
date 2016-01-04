<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>社科基金预算表</title>
    
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
	
	<script type="text/javascript" src="JS/teacher/projectManagement/socialScienceFundBudgetView.js"></script>
  
  	<script type="text/javascript" src="JS/common/fileUpload.js"></script>
	
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
	</script>
  	
  </head>
  
    </head>
    <body>
    
  		<div align="center">
  		
  			<div style = "width:90%;">
	  			<h2>社科基金预算表</h2>
	  			<br>
	  			<div>
	  				<table style = "width:100%;">
	  					<tr>
	  						<td>课题名称：<label id = "itemName"></label></td>
	  						<td>课题编号：<label id = "contractID"></label></td>
	  						<td>负责人：<label id = "teacherName"></label></td>
	  						<td>经费卡号：<label id = "cardID"></label></td>
	  					</tr>
	  				</table>
	  			</div>
	  			
	  			<div>
	  				<div style="float:right;">
	  					单位：万元
	  				</div>
	  			</div>
	  			
  				<br><br>
  				
  				
	  			<div>
			       <form id = "socialScienceFundBudgetForm">
				        <table align = "center" style = "width:100%;" border="1" cellspacing="0" borderColor="#7EC0EE" id = "socialScienceFundBudgetTable">
							<tr bgColor=#e2e4ff>
								<td rowspan="2" valign="middle">科目名称</td>
								<td rowspan="2" id = "tableHeaderTD">批复预算数</td>
							</tr>
							<tr>
								<td id = "organizationNameTD"></td>
							</tr>
							
							<tr>
								<td >资料费</td>
								<td id = "materialCostTD"><label id = "materialCost_Sum"></label></td>
							</tr>
							<tr>
								<td>数据采集费</td>
								<td id = "dataCostTD"><label id = "dataCost_Sum"></label></td>
							</tr>
							<tr>
								<td>差旅费</td>
								<td id = "travelCostTD"><label id = "travelCost_Sum"></label></td>
							</tr>
							<tr>
								<td>会议费</td>
								<td id = "conferenceCostTD"><label id = "conferenceCost_Sum"></label></td>
							</tr>
							<tr>
								<td>国际合作与交流费</td>
								<td id = "exchangeCostTD"><label id = "exchangeCost_Sum"></label></td>
							</tr>
							<tr>
								<td>设备费</td>
								<td id = "equipmentCostTD"><label id = "equipmentCost_Sum"></label></td>
								
							</tr>
							<tr>
								<td>专家咨询费</td>
								<td id = "consultCostTD"><label id = "consultCost_Sum"></label></td>
							</tr>
							<tr>
								<td>劳务费</td>
								<td id = "serviceCostTD"><label id = "serviceCost_Sum"></label></td>
							</tr>
							<tr>
								<td>印刷费</td>
								<td id = "printCostTD"><label id = "printCost_Sum"></label></td>
							</tr>
							<tr>
								<td>管理费</td>
								<td id = "manageCostTD"><label id = "manageCost_Sum"></label></td>
							</tr>
							<tr>
								<td>其他支出</td>
								<td id = "otherCostTD"><label id = "otherCost_Sum"></label></td>
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
		
		
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
  </body>
</html>
