<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>用户信息</title>
    
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
	<script type="text/javascript" src="JS/common/userInfo/userInfo.js"></script>
	
	<style type="text/css">
	
		td {
			height:40px;
		}
		
		.tdLabal {
			width:100px;
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
	    	<form method = "post" id = "teacherInfoForm">
		    	<table>
		    		<caption><h3>个人资料</h3></caption>
		    		<tr>
		    			<td class = "tdLabal">姓名</td><td class = "tdContent"><label id = "name"></label></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">工号</td><td class = "tdContent"><label id = "teacherID"></label></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">院系</td><td class = "tdContent"><label id = "department"></label></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">职称</td><td class = "tdContent"><label id = "titleName"></label></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">间接经费卡</td><td class = "tdContent"><label id = "indirectID"></label></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">手机</td><td class = "tdContent"><input type="text" name="mobile" id="mobile"/></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">电话</td><td class = "tdContent"><input type="text" name="tel" id="tel"/></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">Email</td><td class = "tdContent"><input type="text" name="email" id="email"/></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">上次登录时间</td><td class = "tdContent"><label id = "lastLoginTime"></label></td>
		    		</tr>
		    		<tr>
		    			<td class = "tdLabal">上次登录IP</td><td class = "tdContent"><label id = "lastLoginIP"></label></td>
		    		</tr>
		    		<tr>
		    			<td align = "center" colspan = "2">
		    				<button type="button" onclick = "saveTeacherInfo()">保存</button>
		    				<button type="reset">重置</button>
		    			</td>
		    		</tr>
		    	</table>
	    	</form>
	    </div>
  </body>
</html>
