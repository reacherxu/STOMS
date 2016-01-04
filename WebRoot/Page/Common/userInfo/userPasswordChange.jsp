<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>修改密码</title>
    
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
	<script type="text/javascript" src="JS/common/userInfo/userPasswordChange.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.sha256.min.js"></script>
		
	<style type="text/css">
	
		td {
			height:30px;
		}
		
		.tdLabal {
			width:80px;
		}
		
		.tdContent {
			width:200px;
		}
	</style>
  </head>
  
  <body>
 
  <div>
  		<br><br>
  </div>
  	
  <div align = "center">
    <form method = "post">
    	<table>
    		<caption><h3>密码修改</h3></caption>
    		
    		<tr>
    			<td class = "tdLabal">当前密码</td>
    			<td class = "tdContent"><input type="password" id = "currentPassord"/></td>
    		</tr>
    		<tr>
    			<td class = "tdLabal">新密码</td>
    			<td class = "tdContent"><input type="password" id = "newPassord"/></td>
    		</tr>
    		<tr>
    			<td class = "tdLabal">确认新密码</td>
    			<td class = "tdContent"><input type="password" id="confirmPassord"/></td>
    		</tr>
    		<tr>
    			<td colspan = "2" align = "center" style="padding-top:15px;">    
    				<button type="button" onclick = "modifyTeacherPassord()">保存</button>
    				<button type="reset">重置</button>
    			</td>
    		</tr>
    	</table>
    </form>
    </div>
  </body>
</html>
