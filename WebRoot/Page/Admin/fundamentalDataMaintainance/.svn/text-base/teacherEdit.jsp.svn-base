<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>编辑教师信息</title>
    
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
	
	<script type="text/javascript" src="JS/admin/fundamentalDataMaintainance/teacherEdit.js"></script>
	
	
	
	<script type="text/javascript">
		var teacherPK = "<%= request.getParameter("teacherPK")%>";
		var isModifyPage = "<%= request.getParameter("isModifyPage")%>"; 
	</script>
	
  </head>
  
  	<div align = "center" id="container">
  		
  		<div id="createNewDepartmentDialog" title="编辑教师信息" align = "center">
  			<div align = "left">
	   	&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);"><img src="Resource/Image/returnBack.jpg"  alt="返回上一页" title = "返回上一页"
	   			style = "width:43px; height:35px; background-color: transparent; border-style: none; cursor: pointer;"/></a>
	</div>
			<form id = "editTeacherForm" method = "post">
				<table>
					<tr>
						<td>
							<label>教师工号</label>
						</td>
						<td>
							<input type="text" class="validate[required, custom[number]]" id="teacherId" />
						</td>
					</tr>
					<tr>
						<td>
							<label>教师姓名</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="teacherName" />
						</td>
					</tr>
					<tr>
						<td>
							<label>教师职称</label>
						</td>
						<td>
							<select id="title" >
					            <option value="">选择教师职称</option>
			            	</select>
						</td>
					</tr>
					<tr>
						<td>
							<label>院系</label>
						</td>
						<td>
							<select id = "departmentType" onchange = "renderRelevantProjectTypes()">
								<option value="">文/理科</option>
								<option value="文科">文科</option>
								<option value="理科">理科</option>
		
							</select>
							<select id="itemType" class="validate[required]">
					            <option value="">请先选文/理科</option>
			            	</select>
						</td>
					</tr>
					<tr>
						<td>
							<label>教师固话</label>
						</td>
						<td>
							<input type="text" id="tel" />
						</td>
					</tr>
					<tr>
						<td>
							<label>教师手机</label>
						</td>
						<td>
							<input type="text" class="validate[option, custom[number]]" id="mobile" />
						</td>
					</tr>
					<tr>
						<td>
							<label>教师Email</label>
						</td>
						<td>
							<input type="text" class="validate[option, custom[email]]" id="email" />
						</td>
					</tr>
				</table>
				<br/>
				<div>
					<button type="button" id = "assureButton">添加</button>
	  				<button type="button" id = "cancleButton">返回</button>
				</div>
			</form>
		</div>
		
		</div>
  	
  </body>
</html>
