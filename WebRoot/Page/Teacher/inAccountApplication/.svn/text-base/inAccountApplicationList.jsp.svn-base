<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>My JSP 'inAccountApplication.jsp' starting page</title>
    
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
	<!-- UI界面JS代码 -->
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/teacher/inAccountApplication/inAccountApplicationList.js"></script>
	
	<script type="text/javascript">
		var itemID = "<%= request.getParameter("itemID")%>";
	</script>
	
  </head>
  
  <body id="dt_example">
  	
  	<div align = "center" style="font-size: 15px">
  		<br>
	  	项目类型：&nbsp;&nbsp;<label id = "itemTypeName"></label>
	  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  	课题编号：&nbsp;&nbsp;<label id = "contractID"></label>
	  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  	项目名称：&nbsp;&nbsp;<label id = "itemName"></label>
  	</div>
  	
  	<div align = "center" >
  	
  		<div style = "width:90%; position: absolute; left:5%; top:60px; z-index:1;" align = "left">
 			<button type="button" id = "addNewInAccountApplicationButton">新添入帐</button>
 		</div>
 		
	  	<div style = "width:95%" align = "left" id="container">
	  		<div class = "demo_jui">
	  			<table id = "inAccountApplicationListTable" cellpadding="0" cellspacing="0" border="0" class="display">
	  			</table>
	  		</div>
	  	</div>
  	</div>
  	
  </body>
</html>
