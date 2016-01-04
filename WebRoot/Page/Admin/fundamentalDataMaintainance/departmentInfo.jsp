<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>院系信息维护</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="shortcut icon" type="image/ico" href="JqueryLib/dataTable/images/favicon.ico" />
	<link href="JqueryLib/dataTable/css/demo_page.css" rel="stylesheet" type="text/css"/>
	<link href="JqueryLib/dataTable/css/demo_table.css" rel="stylesheet" type="text/css"/>
	<link href="CSS/idealForms/idealForms-theme-sapphire.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="CSS/validationEngine/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
    <link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	<!-- dataTables控件JS代码 -->
	<script type="text/javascript" src="JqueryLib/dataTable/js/jquery.dataTables.js"></script>
	<!-- 表单验证JS代码 -->
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	<!-- UI界面JS代码 -->
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/admin/fundamentalDataMaintainance/departmentInfo.js"></script>
  </head>
  
  <body id="dt_example">
  
  	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
  	<div align = "center" id="container">
  		
  		<div id="createNewDepartmentDialog" title="添加院系" align = "center" style = "display:none;">
			<form id = "createNewDepartmentForm" method = "post">
				<table>
					<tr>
						<td>
							<label for = "departmentId">编号</label>
						</td>
						<td>
							<input type="text" class="validate[required, custom[number]]" id="departmentId" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "departmentName">院系名称</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="departmentName" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "departmentType">类型</label>
						</td>
						<td>
							<select id="departmentType" class="validate[required]">
					            <option value="">选择院系类型</option>
					            <option value="文科">文科</option>
					            <option value="理科">理科</option>
			            	</select>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "assistanceName">秘书姓名</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="assistanceName" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "assistanceTel">秘书电话</label>
						</td>
						<td>
							<input type="text" class="validate[custom[number]]" id="assistanceTel" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "assistanceMobile">秘书手机</label>
						</td>
						<td>
							<input type="text" class="validate[required, custom[number]]" id="assistanceMobile" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "assistanceEmail">秘书Email</label>
						</td>
						<td>
							<input type="text" class="validate[custom[email]]" id="assistanceEmail" />
						</td>
					</tr>
				</table>
				<br/>
				<div>
					<button type="submit" id = "assureCreatingDepartmentButton">添加</button>
	  				<button type="button" id = "cancleCreatingDepartmentButton">取消</button>
				</div>
			</form>
		</div>
		
		<div id="modifyDepartmentDialog" title="修改院系" align = "center" style = "display:none;">
			<form id = "modifyDepartmentForm" method = "post">
				<table>
					<tr>
						<td>
							<label for = "modifyDepartmentId">编号</label>
						</td>
						<td>
							<input type="text" class="validate[required, custom[number]]" id="modifyDepartmentId" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "modifyDepartmentName">院系名称</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="modifyDepartmentName" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "modifyDepartmentType">类型</label>
						</td>
						<td>
							<select id="modifyDepartmentType" class="validate[required]">
					            <option value="">选择院系类型</option>
					            <option value="文科">文科</option>
					            <option value="理科">理科</option>
			            	</select>
						</td>
					</tr>
					<tr>
						<td>
							<label for = "modifyAssistanceName">秘书姓名</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="modifyAssistanceName" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "modifyAssistanceTel">秘书电话</label>
						</td>
						<td>
							<input type="text" class="validate[custom[number]]" id="modifyAssistanceTel" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "modifyAssistanceMobile">秘书手机</label>
						</td>
						<td>
							<input type="text" class="validate[required, custom[number]]" id="modifyAssistanceMobile" />
						</td>
					</tr>
					<tr>
						<td>
							<label for = "modifyAssistanceEmail">秘书Email</label>
						</td>
						<td>
							<input type="text" class="validate[custom[email]]" id="modifyAssistanceEmail" />
						</td>
					</tr>
				</table>
				<br/>
				<div>
					<button type="submit" id = "assureModifyingDepartmentButton">修改</button>
	  				<button type="button" id = "cancleModifyingDepartmentButton">取消</button>
				</div>
			</form>
		</div>
  		<div style = "width:90%;" id = "demo">
  			<table id = "departmentMaintainanceTable" cellpadding="0" cellspacing="0" border="0" class="display">
  			</table>
  		</div>
  		<br/>
  		<div>
  			<button type="button" id = "addDepartmentButton">增加</button>
  			<button type="button" id = "deleteDepartmentButton">删除</button>
  			<button type="button" id = "modifyDepartmentButton">修改</button>
  		</div>
  		
  	</div>
    
  </body>
</html>
