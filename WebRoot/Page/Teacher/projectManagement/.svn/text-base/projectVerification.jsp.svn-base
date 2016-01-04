<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>项目登记</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/idealForms/idealForms-theme-sapphire.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="CSS/validationEngine/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
    <link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
    
	<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/teacher/projectManagement/projectRegistration.js"></script>
	
	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPK")%>";
	   var itemTypeID = "<%= request.getParameter("itemTypeID")%>";
	</script>
  </head>
  
  <body>
  	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	
    <form id = "projectRegistrationForm" >
		<table align="center" style = "width:100%;">
			<caption><h2>项目确认信息</h2></caption>
			<tr>
				<td class = "leftLabel"><label for = "itemID">项目代码</label></td>
				<td><input type="text"  class="validate[required]" id = "itemID"/></td>
				<td class = "leftLabel"><label for = "itemName">项目名称</label></td>
				<td><input type="text"  class="validate[required]" id = "itemName"/></td>
			</tr>
			<tr>
				<td class = "leftLabel"><label for = "itemType">项目类型</label></td>
				<td class = "rightContent">
					<select id="itemType" class="validate[required]">
			            <option value="">选择一个项目类型</option>
	            	</select>
            	</td>
				<td class = "leftLabel"><label for = "contractID">合同代码</label></td>
				<td><input type="text"  class="validate[required]" id = "contractID"/></td>
			</tr>
			<tr>
				<td class = "leftLabel"><label for = "teacherName">负责教师姓名</label></td>
				<td class = "rightContent"><input type="text"  class="validate[required]" id = "teacherName"/></td>
				
				<td class = "leftLabel"><label for = "isCross">是否横向项目</label></td>
				<td class = "rightContent">
					<label><input type="radio" id = "isCross1" name="isCross" 
							value = 1 class="validate[required] radio" />是</label>
					<label><input type="radio" id = "isCross2" name="isCross"
							value = 0 class="validate[required] radio" />否</label>
				</td>
			
			</tr>
			<tr>
				<td class = "leftLabel"><label for = "departmentID">所在院系</label></td>
				<td class = "rightContent">
					<select id="departmentID" class="validate[required]">
			            <option value="">选择一个院系</option>
	            	</select>
            	</td>
            	
            	<td class = "leftLabel"><label for = "teacherID">负责教师工号</label></td>
				<td class = "rightContent"><input type="text"  class="validate[required]" id = "teacherID"/></td>

			</tr>
			<tr>
				<td class = "leftLabel"><label for = "itemValue">项目总金额</label></td>
				<td class = "rightContent"><input type="text"  class="validate[required]" id = "itemValue"/></td>
				
				<td class = "leftLabel"><label for = "departmentType">院系类型</label></td>
				<td class = "rightContent">
					<label><input type="radio" id = "departmentType1" name="departmentType" 
							value = "文科" class="validate[required] radio" />文科</label>
					<label><input type="radio" id = "departmentType2" name="departmentType"
							value = "理科" class="validate[required] radio" />理科</label>
				</td>
			</tr>
			
			<tr>
				<td class = "leftLabel"><label for = "timeLower">项目开始时间</label></td>
				<td class = "rightContent"><input type="text"  class="validate[required] text-input datepicker" id = "timeLower"/></td>
				
				<td class = "leftLabel"><label for = "remitValue">汇出金额</label></td>
				<td class = "rightContent"><input type="text"  class="validate[required]" id = "remitValue"/></td>
			</tr>
			
			<tr>
				<td class = "leftLabel"><label for = "paidFunds">项目核定上缴资金</label></td>
				<td class = "rightContent"><input type="text"  class="validate[required]" id = "paidFunds"/></td>
				<td class = "leftLabel"><label for = "timeUpper">项目截止时间</label></td>
				<td class = "rightContent">
				<input type="text"  class="validate[required] text-input datepicker" id = "timeUpper"/></td>
			</tr>
			<tr>
			
			<td class = "leftLabel"></td>
			<td class = "rightContent"></td>
			
			<td class = "leftLabel"><label for = "isFinished">项目是否结题</label></td>
				<td class = "rightContent">
					<label><input type="radio" id = "isFinished1" name="isFinished" 
							value = 1 class="validate[required] radio" />是</label>
					<label><input type="radio" id = "isFinished2" name="isFinished"
							value = 0 class="validate[required] radio" />否</label>
				</td>
			</tr>
			
		</table>
		
		<div align = "center">
			<br/><br/>
			<button type = "button" id = "projectVevificationInfoSubmitButton">确认信息并提交</button>
		</div>
		
		
	</form>
  </body>
</html>
