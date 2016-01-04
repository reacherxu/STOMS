<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>社科基金支出表</title>
    
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
	
	
	<script type="text/javascript" src="JS/teacher/outlayManagement/socialScienceFundOutlay.js"></script>
  
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
	   var itemPK = "<%= request.getParameter("itemPK")%>";
	   var pageType = "<%= request.getParameter("pageType")%>";
	   var outlayPK = "<%= request.getParameter("outlayPK")%>";
	</script>
  	
  </head>
  
    </head>
    <body>
    	<div align = "center">
	    	<table style="width: 90%;" >
	    		<caption><h2>社科基金支出表</h2></caption>
    			<tr>
    				<td>项目名称:&nbsp;&nbsp;<label id = "itemName"></label></td>
    				<td>课题编号:&nbsp;&nbsp;<label id = "contractId"></label></td>
    				<td>项目负责人:&nbsp;&nbsp;<label id = "teacherName"></label></td>
    				<td align = "right"><label>金额单位：万元</label></td>
    			</tr>
	    	</table>
	    	
	        <form id = "socialScienceFundOutlayForm">
	        	<table align = "center" style="width: 90%;"  border="1" cellspacing="0"  borderColor="#7EC0EE" id = "socialScienceFundOutlayTable">
	        		
		        	<tr>
						<td  width=200px><h4>预算科目名称</h4></td>
						<td><h4>预算情况</h4></td>
						<td><h4>现有支出总额</h4></td>
						<td><h4>预算余额</h4></td>
						<td><h4>实际支出</h4></td>
						<td><h4>说明</h4></td>
					</tr>
					<tr>
						<td>资料费</td>
						<td><label id = "materialCost_budget"></label></td>
						<td><label id = "materialCost_accumulation"></label></td>
						<td><label id = "materialCost_balance"></label></td>
						<td><input type="text" id ="materialCost_currentOutlay" /></td>
						<td><textarea id = "materialCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>数据采集费</td>
						<td><label id = "dataCost_budget"></label></td>
						<td><label id = "dataCost_accumulation"></label></td>
						<td><label id = "dataCost_balance"></label></td>
						<td><input type="text" id ="dataCost_currentOutlay" /></td>
						<td><textarea id = "dataCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>差旅费</td>
						<td><label id = "travelCost_budget"></label></td>
						<td><label id = "travelCost_accumulation"></label></td>
						<td><label id = "travelCost_balance"></label></td>
						<td><input type="text" id ="travelCost_currentOutlay" /></td>
						<td><textarea id = "travelCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>会议费</td>
						<td><label id = "conferenceCost_budget"></label></td>
						<td><label id = "conferenceCost_accumulation"></label></td>
						<td><label id = "conferenceCost_balance"></label></td>
						<td><input type="text" id ="conferenceCost_currentOutlay" /></td>
						<td><textarea id = "conferenceCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>国际合作与交流费</td>
						<td><label id = "exchangeCost_budget"></label></td>
						<td><label id = "exchangeCost_accumulation"></label></td>
						<td><label id = "exchangeCost_balance"></label></td>
						<td><input type="text" id ="exchangeCost_currentOutlay" /></td>
						<td><textarea id = "exchangeCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>设备费</td>
						<td><label id = "equipmentCost_budget"></label></td>
						<td><label id = "equipmentCost_accumulation"></label></td>
						<td><label id = "equipmentCost_balance"></label></td>
						<td><input type="text" id ="equipmentCost_currentOutlay" /></td>
						<td><textarea id = "equipmentCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>专家咨询费</td>
						<td><label id = "consultCost_budget"></label></td>
						<td><label id = "consultCost_accumulation"></label></td>
						<td><label id = "consultCost_balance"></label></td>
						<td><input type="text" id ="consultCost_currentOutlay" /></td>
						<td><textarea id = "consultCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>劳务费</td>
						<td><label id = "serviceCost_budget"></label></td>
						<td><label id = "serviceCost_accumulation"></label></td>
						<td><label id = "serviceCost_balance"></label></td>
						<td><input type="text" id ="serviceCost_currentOutlay" /></td>
						<td><textarea id = "serviceCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>印刷费</td>
						<td><label id = "printCost_budget"></label></td>
						<td><label id = "printCost_accumulation"></label></td>
						<td><label id = "printCost_balance"></label></td>
						<td><input type="text" id ="printCost_currentOutlay" /></td>
						<td><textarea id = "printCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>管理费</td>
						<td><label id = "manageCost_budget"></label></td>
						<td><label id = "manageCost_accumulation"></label></td>
						<td><label id = "manageCost_balance"></label></td>
						<td><input type="text" id ="manageCost_currentOutlay" /></td>
						<td><textarea id = "manageCost_remark"></textarea></td>
					</tr>
					<tr>
						<td>其他支出</td>
						<td><label id = "otherCost_budget"></label></td>
						<td><label id = "otherCost_accumulation"></label></td>
						<td><label id = "otherCost_balance"></label></td>
						<td><input type="text" id ="otherCost_currentOutlay" /></td>
						<td><textarea id = "otherCost_remark"></textarea></td>
					</tr>
	        	</table>
				<div align = "center">
					<br/><br/>
					<button type = "button" id = "socialScienceFundOutlaySubmitButton">提交</button>
					<button type = "reset" id = "socialScienceFundOutlayResetButton">重置</button>
				</div>
	        </form>
    	</div>
  </body>
</html>
