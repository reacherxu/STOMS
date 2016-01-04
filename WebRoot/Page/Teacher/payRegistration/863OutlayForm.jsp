<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国家科技计划项目863/973支出表</title>
    
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
	
	
	<script type="text/javascript" src="JS/teacher/outlayManagement/863OutlayForm.js"></script>
  
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
    <body >
   		<div align="center" style = "width:100%;">
   		
	    	<table style="width: 90%;">
	    		<caption><h2>国家科技计划项目863/973支出表</h2></caption>
	   			<tr>
	   				<td>项目名称</td>
	   				<td colspan="4"><label id = "itemName"></label></td>
	   			</tr>
	   			<tr>
	   				<td>课题编号</td>
	   				<td><label id = "contractId"></label></td>
	   				<td><label >项目负责人</label></td>
	   				<td><label id = "teacherName"></label></td>
	   				<td><label>金额单位：万元</label></td>
	   			</tr>
	    	</table>
	    	
	        <form id = "nation863OutlayForm" style="width: 90%;">
		        <table align="center" style = "width:90%;"  border="1" cellspacing="0"  borderColor="#7EC0EE"id = "a863OutlayFormTalbe">
		        	<tr bgColor=#e2e4ff>
						<td  width=200px><h4>预算科目名称</h4></td>
						<td><h4>预算情况</h4></td>
						<td><h4>现有支出总额</h4></td>
						<td><h4>预算余额</h4></td>
						<td><h4>实际支出</h4></td>
						<td><h4>说明</h4></td>
					</tr>
					<tr bgColor=#F0FFF0>
						<td>一.经费支出</td>
						<td><label id = "outGoings_ActualFundBudget"></label></td>
						<td><label id = "outGoings_Current"></label></td>
						<td><label id = "outGoings_Balance"></label></td>
						<td><input type="text" id ="outGoings_RealOutGoings" ></td>
						<td><textarea id = "outGoings_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;（一）直接费用</td>
						<td><label id = "directCost_ActualFundBudget" ></label></td>
						<td><label id = "directCost_Current" ></label></td>
						<td><label id = "directCost_Balance"></label></td>
						<td><input type="text" id ="directCost_RealOutGoings" ></td>
						<td><textarea id = "directCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp; &nbsp; 1.设备费</td>
						<td><label id = "equipmentCost_ActualFundBudget" ></label></td>
						<td><label id = "equipmentCost_Current" ></label></td>
						<td><label id = "equipmentCost_Balance"></label></td>
						<td><input type="text" id ="equipmentCost_RealOutGoings" ></td>
						<td><textarea id = "equipmentCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp; (1)购置设备费</td>
						<td><label id = "buyCost_ActualFundBudget"  ></label></td>
						<td><label id = "buyCost_Current" ></label></td>
						<td><label id = "buyCost_Balance"></label></td>
						<td><input type="text" id ="buyCost_RealOutGoings" ></td>
						<td><textarea id = "buyCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp; (2)试制设备费</td>
						<td><label id = "tryToMakeCost_ActualFundBudget" ></label></td>
						<td><label id = "tryToMakeCost_Current" ></label></td>
						<td><label id = "tryToMakeCost_Balance"></label></td>
						<td><input type="text" id ="tryToMakeCost_RealOutGoings" ></td>
						<td><textarea id = "tryToMakeCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp; (3)设备改造与租赁费</td>
						<td><label id = "reformLeaseCost_ActualFundBudget" ></label></td>
						<td><label id = "reformLeaseCost_Current" ></label></td>
						<td><label id = "reformLeaseCost_Balance"></label></td>
						<td><input type="text" id ="reformLeaseCost_RealOutGoings" ></td>
						<td><textarea id = "reformLeaseCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 2.材料费</td>
						<td><label id = "materialCost_ActualFundBudget" ></label></td>
						<td><label id = "materialCost_Current" ></label></td>
						<td><label id = "materialCost_Balance"></label></td>
						<td><input type="text" id ="materialCost_RealOutGoings" ></td>
						<td><textarea id = "materialCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 3.测试化验加工费</td>
						<td><label id = "testCost_ActualFundBudget" ></label></td>
						<td><label id = "testCost_Current" ></label></td>
						<td><label id = "testCost_Balance"></label></td>
						<td><input type="text" id ="testCost_RealOutGoings" ></td>
						<td><textarea id = "testCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 4.燃料动力费</td>
						<td><label id = "fuelCost_ActualFundBudget"></label></td>
						<td><label id = "fuelCost_Current" ></label></td>
						<td><label id = "fuelCost_Balance"></label></td>
						<td><input type="text" id ="fuelCost_RealOutGoings" ></td>
						<td><textarea id = "fuelCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 5.差旅费</td>
						<td><label id = "travelCost_ActualFundBudget" ></label></td>
						<td><label id = "travelCost_Current" ></label></td>
						<td><label id = "travelCost_Balance"></label></td>
						<td><input type="text" id ="travelCost_RealOutGoings" ></td>
						<td><textarea id = "travelCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 6.会议费</td>
						<td><label id = "conferenceCost_ActualFundBudget" ></label></td>
						<td><label id = "conferenceCost_Current" ></label></td>
						<td><label id = "conferenceCost_Balance"></label></td>
						<td><input type="text" id ="conferenceCost_RealOutGoings" ></td>
						<td><textarea id = "conferenceCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 7.国际合作与交流费</td>
						<td><label id = "internationalCost_ActualFundBudget" ></label></td>
						<td><label id = "internationalCost_Current" ></label></td>
						<td><label id = "internationalCost_Balance"></label></td>
						<td><input type="text" id ="internationalCost_RealOutGoings" ></td>
						<td><textarea id = "internationalCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 8.出版/文献/信息传播/知识产权事务</td>
						<td><label id = "publishCost_ActualFundBudget" ></label></td>
						<td><label id = "publishCost_Current" ></label></td>
						<td><label id = "publishCost_Balance"></label></td>
						<td><input type="text" id ="publishCost_RealOutGoings" ></td>
						<td><textarea id = "publishCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 9.劳务费</td>
						<td><label id = "labourCost_ActualFundBudget" ></label></td>
						<td><label id = "labourCost_Current" ></label></td>
						<td><label id = "labourCost_Balance"></label></td>
						<td><input type="text" id ="labourCost_RealOutGoings" ></td>
						<td><textarea id = "labourCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 10.咨询费</td>
						<td><label id = "consultationCost_ActualFundBudget" ></label></td>
						<td><label id = "consultationCost_Current" ></label></td>
						<td><label id = "consultationCost_Balance"></label></td>
						<td><input type="text" id ="consultationCost_RealOutGoings" ></td>
						<td><textarea id = "consultationCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 11.基本建设费</td>
						<td><label id = "constructionCost_ActualFundBudget" ></label></td>
						<td><label id = "constructionCost_Current" ></label></td>
						<td><label id = "constructionCost_Balance"></label></td>
						<td><input type="text" id ="constructionCost_RealOutGoings" ></td>
						<td><textarea id = "constructionCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 12.其他支出</td>
						<td><label id = "otherCost_ActualFundBudget" ></label></td>
						<td><label id = "otherCost_Current" ></label></td>
						<td><label id = "otherCost_Balance"></label></td>
						<td><input type="text" id ="otherCost_RealOutGoings" ></td>
						<td><textarea id = "otherCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;（二）间接费用</td>
						<td><label id = "indirectCost_ActualFundBudget" ></label></td>
						<td><label id = "indirectCost_Current" ></label></td>
						<td><label id = "indirectCost_Balance"></label></td>
						<td><input type="text" id ="indirectCost_RealOutGoings" ></td>
						<td><textarea id = "indirectCost_Remark"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp; 其中：绩效支出</td>
						<td><label id = "achievementsCost_ActualFundBudget" ></label></td>
						<td><label id = "achievementsCost_Current" ></label></td>
						<td><label id = "achievementsCost_Balance"></label></td>
						<td><input type="text" id ="achievementsCost_RealOutGoings" ></td>
						<td><textarea id = "achievementsCost_Remark"></textarea></td>
					</tr>
		        	</table>
		        	
					<div align = "center">
						<br/><br/>
						<button type = "button" id = "nation863OutlaySubmitButton">提交</button>
						<button type = "button" onclick = "resetForm()" id = "nation863OutlayResetButton">重置</button>
					</div>
	        </form>
        </div>
        
        <div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
  </body>
</html>
