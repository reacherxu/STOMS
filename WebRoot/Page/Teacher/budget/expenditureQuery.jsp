<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'expenditureQuery.jsp' starting page</title>
    
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
	<script type="text/javascript" src="JS/teacher/budget/expenditureQuery.js"></script>
  
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
  <div><br><br></div>
    <div align = "center">
    <form action="" method = "post">
    	<table width = "40%">
    		<caption><h3>支出查询</h3></caption>
    		<tr>
    			<td>选择项目：</td>
    			<td>
					<select id="project" style = "height:20px; width:240px">
					<option value="null"></option>
					</select>
				</td>
    		</tr>
    	</table>
    	<button type="button" onclick = "expenditureQuery()">查询</button>
    </form>
    </div>
  </body>
</html>
