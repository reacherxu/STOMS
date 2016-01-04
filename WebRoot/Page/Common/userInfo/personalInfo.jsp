<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>My JSP 'personalInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
	<link href="JqueryLib/css/tabPage/tabPage.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.sha256.min.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.tabs.js"></script>
	
	<script type="text/javascript" src="JS/common/userInfo/personalInfo.js"></script>
	
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
	
	.tdLabal {
		width:120px;
	}
	
	.tdContent {
		width:300px;
	}
	
	.demo .ui-widget-header { border: 1px solid #eeeeee/*{borderColorHeader}*/; background: #ffffff/*{bgColorHeader}*/ /*{bgImgUrlHeader}*/ 50%/*{bgHeaderXPos}*/ 50%/*{bgHeaderYPos}*/ repeat-x/*{bgHeaderRepeat}*/; color: #222222/*{fcHeader}*/; font-weight: bold; }
	.demo .ui-widget-header a { color: #222222/*{fcHeader}*/; }
	.demo .ui-widget-content { border: 0px solid #ffffff/*{borderColorContent}*/; background: #ffffff/*{bgColorContent}*/ /*{bgImgUrlContent}*/ 50%/*{bgContentXPos}*/ 50%/*{bgContentYPos}*/ repeat-x/*{bgContentRepeat}*/; color: #222222/*{fcContent}*/; }
	.demo .ui-widget-content a { color: #222222/*{fcContent}*/; }
	
	#teacherInfoTab button {
		font-size: 12px;
		cursor: pointer;
	}
	</style>
  </head>
  
  <body class = "demo">
  	
  	<div id = "teacherInfoTab">
  	
	  	<ul style = "line-height: 1.0;"> 
			<li><a href="#personalInfoDIV">个人资料</a></li> 
			<li><a href="#passwordChangingDIV">密码修改</a></li>
			<li><a href="#authorizationManagementDIV">授权管理</a></li>
		</ul> 
		
	    <div align = "center" id = "personalInfoDIV">	
	    	<form method = "post" id = "teacherInfoForm">
		    	<table>		    		
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
	    
	    <div align = "center" id = "passwordChangingDIV">	    
		    <form method = "post">
		    	<table>
		    		
		    		<tr>
		    			<td>当前密码</td>
		    			<td><input type="password" id = "currentPassord"/></td>
		    		</tr>
		    		<tr>
		    			<td>新密码</td>
		    			<td><input type="password" id = "newPassord"/></td>
		    		</tr>
		    		<tr>
		    			<td>确认新密码</td>
		    			<td><input type="password" id="confirmPassord"/></td>
		    		</tr>
		    		<tr>
		    			<td colspan = "2" align = "center">    
		    				<button type="button" onclick = "modifyTeacherPassord()">保存</button>
		    				<button type="reset">重置</button>
		    			</td>
		    		</tr>
		    	</table>
		    </form>
	    </div>
	    
	    <div align = "center" id = "authorizationManagementDIV">
		    <form method = "post">
		    	<table>
		    		
		    		<tr>
		    			<td>姓名</td>
		    			<td><input type="text" id = "authorizedTeacherName"/></td>
		    		</tr>
		    		<tr>
		    			<td>工号</td>
		    			<td><input type="text" id = "authorizedTeacherID"/></td>
		    		</tr>
		    		
		    		<tr>
		    			<td colspan = "2" align = "center">
		    				<button type="button" onclick = "authorizationManage()">保存</button>
		    				<button type="reset">重置</button>
		    			</td>
		    		</tr>
		    	</table>
		    </form>
	    </div>
    
    </div>
  </body>
</html>
