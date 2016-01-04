<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>编辑院系信息</title>
    
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
	<link href="JqueryLib/dataTable/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/dataTable/css/smoothness/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css"/>
    
    <script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	<!-- dataTables控件JS代码 -->
	<script type="text/javascript" src="JqueryLib/dataTable/js/jquery.dataTables.js"></script>
	
	<!-- 表单验证JS代码 -->
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	<link href="CSS/validationEngine/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/admin/fundamentalDataMaintainance/departmentEdit.js"></script>
	
	
	
	<script type="text/javascript">
		var departmentPK = "<%= request.getParameter("departmentPK")%>";
		var IsModifyPage = "<%= request.getParameter("IsModifyPage")%>"; 
	</script>
	
  </head>
  
  	<div align = "center" id="container">
  		
  		<div id="createNewDepartmentDialog" title="编辑院系信息" align = "center">
  			<div align = "left">
	   	&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);"><img src="Resource/Image/returnBack.jpg"  alt="返回上一页" title = "返回上一页"
	   			style = "width:43px; height:35px; background-color: transparent; border-style: none; cursor: pointer;"/></a>
	</div>
			<form id = "createNewDepartmentForm" method = "post">
				<table>
					<tr>
						<td>
							<label>编号</label>
						</td>
						<td>
							<input type="text" class="validate[required, custom[number]]" id="departmentId" />
						</td>
					</tr>
					<tr>
						<td>
							<label>院系名称</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="departmentName" />
						</td>
					</tr>
					<tr>
						<td>
							<label>类型</label>
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
							<label>秘书工号</label>
						</td>
						<td>
							<input type="text" class="validate[option, custom[number]]" id="assistanceId" />
						</td>
					</tr>
					<tr>
						<td>
							<label>科研主任工号</label>
						</td>
						<td>
							<input type="text" class="validate[option, custom[number]]" id="directorId" />
						</td>
					</tr>
					<tr>
						<td>
							<label>秘书电话</label>
						</td>
						<td>
							<input type="text" class="validate[option, custom[number]]" id="assistanceTel" />
						</td>
					</tr>
					<tr>
						<td>
							<label>秘书手机</label>
						</td>
						<td>
							<input type="text" class="validate[option, custom[number]]" id="assistanceMobile" />
						</td>
					</tr>
					<tr>
						<td>
							<label>秘书Email</label>
						</td>
						<td>
							<input type="text" class="validate[option,custom[email]]" id="assistanceEmail" />
						</td>
					</tr>
				</table>
				<br/>
				<div>
					<button type="button" id = "assureButton">添加</button>
	  				<button type="button" id = "cancleButton">取消</button>
				</div>
			</form>
		</div>
		
		</div>


  	

  	
  </body>
</html>
