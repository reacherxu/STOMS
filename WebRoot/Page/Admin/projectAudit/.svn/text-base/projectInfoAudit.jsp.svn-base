<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>项目审核</title>
    
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
    
	<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/admin/projectAudit/projectInfoAudit.js"></script>
	
	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPK")%>";
	</script>
  </head>
  
  <body>
   	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
   
		<table align="center" style = "width:100%;">
			<caption><h2>项目信息</h2></caption>
			<tr>
				<td class = "leftLabel"><label>课题编号</label></td>
				<td class = "rightContent"><label id = "contractID"/></td>
				<td class = "leftLabel"><label>项目名称</label></td>
				<td class = "rightContent"><label id = "itemName"/></td>
			</tr>
			
			<tr>
				<td class = "leftLabel"><label>项目类型</label></td>
				<td class = "rightContent"><label id = "itemType"/></td>
				<td class = "leftLabel"><label for = "isCross">是否横向项目</label></td>
				<td class = "rightContent"><label id = "isCross"/></td>
			</tr>
			
			<tr>
				<td class = "leftLabel"><label>负责教师姓名</label></td>
				<td class = "rightContent"><label id = "teacherName"/></td>
				<td class = "leftLabel"><label>负责教师工号</label></td>
				<td class = "rightContent"><label id = "teacherID"/></td>
			</tr>
			
			<tr>
				<td class = "leftLabel"><label>所在院系</label></td>
				<td class = "rightContent"><label id = "departmentName"/></td>
				<td class = "leftLabel"><label>院系类型</label></td>
				<td class = "rightContent"><label id = "departmentType"/></td>
			</tr>
			
			<tr>
				<td class = "leftLabel"><label>合同金额</label></td>
				<td class = "rightContent"><label id = "itemValue"/></td>
				<td class = "leftLabel"><label>经费卡号</label></td>
				<td class = "rightContent"><label id = "cardID"/></td>
			</tr>
			
			<tr>
				<td class = "leftLabel"><label>项目开始时间</label></td>
				<td class = "rightContent"><label id = "timeLower"/></td>
				<td class = "leftLabel"><label>项目截止时间</label></td>
				<td class = "rightContent"><label id = "timeUpper"/></td>
			</tr>
			<tr>
				<td class = "leftLabel"><label>审核年度</label></td>
				<td class = "rightContent"><label id = "applyYear"></label>&nbsp;年</td>
				<td class = "leftLabel"><label>预算信息</label></td>
				<td class = "rightContent"><button type = "button" onclick = "budgetDetailInfoView()">预算信息</button></td>
				
			</tr>
			
		</table>
		
		<div align = "center">
			<br/><br/>
			<button  id = "projectAuditApproveButton">审核通过</button>
			<button  id = "projectAuditRejectButton">审核不通过</button>
		</div>
		<div align = "right">
			<br/><br/>
			<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
		
  </body>
</html>
