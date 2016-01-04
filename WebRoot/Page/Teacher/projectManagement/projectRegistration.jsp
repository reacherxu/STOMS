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
    <link href="JqueryLib/css/datepickerCss/datepicker_demo.css" rel="stylesheet" type="text/css"/>
    
	<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/teacher/projectManagement/projectRegistration.js"></script>
	
	<style type="text/css">
		.ui-datepicker table td{
			height:20px;
		}
		
	</style>
	
	
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
	</script>
  </head>
  
  <body class = "demo">
  	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
  	
  	
    <form id = "projectRegistrationForm" method="post">
    <div>
  		<br><br>
  	</div>
  	
    	
		<table align="center" style = "width:100%;">
			<caption><h2>项目信息</h2></caption>
			<tr>
				<td class = "leftLabel"><label for = "itemName">项目名称</label></td>
				<td colspan="4" align="left"><input type="text"  class="validate[required]" id = "itemName" style= "width:31%;"/></td>
			</tr>
			<tr>
				<td class = "leftLabel"><label for = "itemType">项目类型</label></td>
				<td class = "rightContent" colspan="3">
					<select id = "departmentType" class="validate[required]" onchange = "renderRelevantProjectTypes()">
						<option value="">选择文/理科</option>
						<option value="文科">文科</option>
						<option value="理科">理科</option>
					</select>
					<select id="itemType" class="validate[required]">
			            <option value="">请先选文/理科</option>
	            	</select>
            	</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class = "leftLabel"><label for = "contractID">课题编号</label></td>
				<td class = "rightContent">
					<input type="text"  class="validate[required]" id = "contractID"/>
				</td>    
				<td class = "leftLabel"><label for = "isCross">是否横向项目</label></td>
				<td class = "rightContent">
					<label><input type="radio" id = "isCross1" name="isCross" style="width:15%;"
							value = 1 class="validate[required] radio" />是</label>
					<label><input type="radio" id = "isCross2" name="isCross"  style="width:15%;"
							value = 0 class="validate[required] radio" />否</label>
				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class = "leftLabel"><label for = "responsibleTeacher">负责教师</label></td>
				<td class = "rightContent">
					<select id="responsibleTeacher" class="validate[required]">
			            <option value="">选择一个教师</option>
	            	</select>
				</td>
				<td class = "leftLabel">
					<button type = "button" onclick = "renderParticipateTeacher()" >添加参与教师</button>
				</td>
				<td colspan="2"></td>
			</tr>
			<tr id = "departmentTR">
				<td class = "leftLabel"><label for = "departmentID">所在院系</label></td>
				<td class = "rightContent">
					<select id="departmentID" class="validate[required]">
			            <option value="">选择一个院系</option>
	            	</select>
            	</td>
            	<td class = "leftLabel"><label for = "itemValue">合同金额</label></td>
				<td class = "rightContent" colspan="2"><input type="text"  class="validate[required, custom[number]]" id = "itemValue"/>元</td>
				
			</tr>
			<tr>
				<td class = "leftLabel"><label for = "timeLower">项目开始时间</label></td>
				<td class = "rightContent"><input type="text"  class="validate[required] text-input datepicker" id = "timeLower"/></td>
				<td class = "leftLabel"><label for = "timeUpper">项目截止时间</label></td>
				<td class = "rightContent" colspan="2"><input type="text"  class="validate[required] text-input datepicker" id = "timeUpper"/></td>
			</tr>
			<tr>
				<td class = "leftLabel"><label for = "applyYear">审核年度</label></td>
				<td class = "rightContent" colspan="4">
					<select id="applyYear" class="validate[required]">
			            <option value="">选择一个年度</option>
	            	</select>
            	</td>
			</tr>
			<tr>
				<td class = "leftLabel"><label>预算信息</label></td>
				<td class = "rightContent" colspan="4">
					<button id = "budgetInfoButton" type = "button" onclick = "budgetDetailInfo()" disabled = "disabled">预算信息</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label id = "budgetInfoLabel" style = "font-size:12px;"></label>
				</td>
			</tr>
		</table>
		
		<div align = "center">
			<br/><br/>
			<button type = "button" id = "projectRegistrationInfoSaveButton">保存</button>
			<button type = "submit" id = "projectRegistrationInfoSubmitButton">提交</button>
			<button type = "button" onclick = "resetProjectRegistrationForm()">重置</button>
		</div>
		
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
		
	</form>
  </body>
</html>
