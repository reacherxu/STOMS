<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>My JSP 'redirectToTeacherMainPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="CSS/page.css">
	
	<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	<script type="text/javascript" src="JS/admin/adminInfo/redirectToTeacherMainPage.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.sha256.min.js"></script>
		
	<style type="text/css">
	
		* {
		margin: 0px;
		padding: 0px;
		}
		
		body {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 12px;
			background-color: #FFFFFF;
			text-align: center;
		}
		
		td {
			height:40px;
		}
	</style>
  </head>
  
  <body>
  <div align = "center">
    <form action="" method = "post">
    	<table width = "40%">
    		<caption><h3>教师信息登记</h3></caption>
    		<tr>
    			<td>教师工号</td>
    			<td><input type="text" name="teacherID" id = "teacherID"/></td>
    		</tr>
    		
    		<tr>
    			<td colspan = "2" align = "center">    
    				<button type="button" onclick = "redirectToTeacherMainPage()">跳转</button>
    				<button type="reset">重置</button>
    			</td>
    		</tr>
    	</table>
    </form>
    </div>
  </body>
</html>
