<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>科技处经费管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="CSS/page.css">
	<link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.sha256.min.js"></script>
	
	
	
	
  </head>

  <body>
  	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
    <%
	Object obj = session.getAttribute("curr_adminID");
	if(obj==null){
	%>
	<script type="text/javascript">
		openGeneralMessageDialogThenGoBack("你没有登录管理员账户，请登录！");
		//window.location.href = 'teacherLogin.jsp';
		setTimeout("window.location.href = 'teacherLogin.jsp';",3000);
	</script>
	<%
		
		//response.sendRedirect("teacherLogin.jsp");
	}else{
		
		
	}
	%>
  </body>
</html>
