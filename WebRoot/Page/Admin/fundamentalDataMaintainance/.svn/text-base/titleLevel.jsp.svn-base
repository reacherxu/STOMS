<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>头衔等级维护</title>
    
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
	
	<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
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
	
	<script type="text/javascript" src="JS/admin/fundamentalDataMaintainance/titleLevel.js"></script>
  </head>
  
  <body id="dt_example">
  
  	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
  	<div id="createNewTitleDialog" title="添加新头衔" align = "center" style = "display:none;">
		<form id = "createNewTitleForm" method = "post">
			<div>
				<label for="titleName">头衔名称</label>
				<input type="text" class="validate[required]" name="titleName" id="titleName" />
			</div>
			<br/>
			<div>
				<button type="submit" id = "assureCreatingTitleButton">添加</button>
  				<button type="button" id = "cancleCreatingTitleButton">取消</button>
			</div>
		</form>
	</div>
	
	<div id="modifyTitleDialog" title="修改头衔" align = "center" style = "display:none;">
		<form id = "modifyTitleForm" method = "post">
			<div>
				<label for="modifyTitleName">头衔名称</label>
				<input type="text" class="validate[required]" name="modifyTitleName" id="modifyTitleName" />
			</div>
			<br/>
			<div>
				<button type="submit" id = "assureModifyingTitleButton">修改</button>
  				<button type="button" id = "cancleModifyingTitleButton">取消</button>
			</div>
		</form>
	</div>
  	
  	<div align = "center" id="container">
  		
  		<div style = "width:80%;" id = "demo">
  			<table id = "titleLevelMaintainanceTable" cellpadding="0" cellspacing="0" border="0" class="display">
  			</table>
  		</div>
  		<br/>
  		<div>
  			<button type="button" id = "addTitleButton">增加</button>
  			<button type="button" id = "deleteTitleButton">删除</button>
  			<button type="button" id = "modifyTitleButton">修改</button>
  		</div>
  		
  	</div>
  </body>
</html>
