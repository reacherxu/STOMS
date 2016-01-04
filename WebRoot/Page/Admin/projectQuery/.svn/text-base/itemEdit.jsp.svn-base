<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>编辑项目信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
	<link href="CSS/idealForms/idealForms-theme-sapphire.css" rel="stylesheet" type="text/css" media="screen"/>
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
	
	<script type="text/javascript" src="JS/admin/projectQuery/itemEdit.js"></script>
	
	
	
	<script type="text/javascript">
		var itemPK = "<%= request.getParameter("itemPK")%>";
		var isModifyPage = "<%= request.getParameter("isModifyPage")%>"; 
		var itemID = "<%= request.getParameter("itemID")%>";
	</script>
	
  </head>
  
  	<div align = "center" id="container">
  		
  		<div id="createNewDepartmentDialog" title="编辑项目信息" align = "center">
  			<div align = "left">
	   	&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);"><img src="Resource/Image/returnBack.jpg"  alt="返回上一页" title = "返回上一页"
	   			style = "width:43px; height:35px; background-color: transparent; border-style: none; cursor: pointer;"/></a>
	</div>
			<form id = "editItemForm" method = "post">
				<table>
					<tr>
						<td>
							<label>项目代码:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" class="validate[option, custom[number]]" id="itemid" />
						</td>
						<td>
							<label>项目名称:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="itemname" />
						</td>
						<td>
							<label>合同号:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="contractid" />
						</td>
					</tr>
					<tr>
						<td>
							<label>负责人姓名:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="teachername" />
						</td>
						<td>
							<label>其他负责人:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id=otherteacher />
						</td>
						<td>
							<label>项目类型代码:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="typeid" />
						</td>
					</tr>
					<tr>
						<td>
							<label>院系代码:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="departmentid" onchange="adjustDepartment()" />
						</td>
						<td>
							<label>院系名称:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="departmentname" />
						</td>
						<td>
							<label>院系类型:&nbsp;&nbsp;</label>
						</td>
						<td>
							<select id = "departmenttype">  
							<option value="">所&nbsp;有</option>
							<option value="文科">文&nbsp;科</option>
							<option value="理科">理&nbsp;科</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>
							<label>经费卡号:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="cardid" />
						</td>
						<td>
							<label>项目金额:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="itemvalue" />
						</td>
						<td>
							<label>汇出金额:&nbsp;&nbsp;</label>
						</td>
						<td>
							<input type="text" id="remitvalue" />
						</td>
					</tr>
					<tr>
						<td>
							<label>开始时间:&nbsp;&nbsp;</label>
		            	</td>
		            	<td>
							<input type="text" id = "startDate"/>
		            	</td>
		            	<td>
							<label>结束时间:&nbsp;&nbsp;</label>
		            	</td>
		            	<td>
							<input type="text" id = "endDate"/>
		            	</td>
		            	<td>
							<label>是否结题:&nbsp;&nbsp;</label>
						</td>
						<td>
							<select id = "isFinished">  
							<option value="">所&nbsp;有</option>
							<option value="1">已结题</option>
							<option value="0">进行中</option>
						</select>
						</td>
					</tr>
				</table>
				<br/>
				<div>
					<button type="button" id = "assureButton">添加</button>
					<button type="button" id = "deleteButton">删除</button>
					<button type="button" id = "printButton">打印</button>
				</div>
			</form>
			
		</div>
		</div>
  	
  </body>
</html>
