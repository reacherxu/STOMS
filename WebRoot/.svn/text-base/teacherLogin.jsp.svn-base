<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
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
	
	<script type="text/javascript" src="JS/common/userInfo/teacherLogin.js"></script>
	
	<style type="text/css">
	
		
		div.second_Bg
		{
			 background-image: url(Resource/Image/bg_index.jpg);
			 background-repeat: no-repeat;
			 background-position: top center;
			 width:100%;
			 height:100%;
		}
		div.top
		{
			color: white;
			font-family: 黑体;
			font-size: 56;
			padding-top:40px;
		}
		div.pos_abs
		{
			position:relative;
			top:235px;
			left:240px;
			width:339px;
			height:232px;
			MARGIN-RIGHT: auto; 
			MARGIN-LEFT: auto;
		}
		div.pos_links
		{
			position:relative;
			top:500px;
			font-size: 18px;
		}
	  	label {
	  		width: 60px;
	  	}
	  	
	  	input {
	  		width: 200px;
	  	}
	  	
	  	textarea {
	  		width: 120px;
	  		height: 30px;
	  	}
	  	
	  	#teacherLoginForm td {
	  		height:48px;
	  	}
  	
  	</style>
	
  </head>
  
  <script type="text/javascript">
  	
  	var path = "<%=path%>";
  </script>
  	
  <body class = "bodyBackGround">
  
  	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<div class ="second_Bg">
  		
  		<div class = "pos_abs" align="left">
		    <form id = "teacherLoginForm" method="post">
		    		
		    		<table>
		    			<tr>
		    				
		    				<td>
		    					<input type="text" name="teacherId" id = "teacherId" style="height:30px;width:160px;font-size:16px;"/>
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				
		    				<td>
		    					<input type="password" name="password" id = "password" style="height:30px;width:160px;font-size:16px;"/>
		    				</td>
		    			</tr>
		    			<tr>
		    				
		    				<td>
		    					<input type="text" name="authorizedCode" id = "authorizedCode" size="4" style="height:30px;width:80px;font-size:16px;"/>&nbsp;&nbsp;
		    					<img src="authorizedCode.jsp" id = "authorizedCodeImgWidget" alt = "" width="60px" height="20px" border=0  onclick = "authorizedCodeChange();">
		    					&nbsp;&nbsp;<a style = "font-size:12px;" href="javascript:void(0)" onclick="authorizedCodeChange();">换一张</a>
		    				</td>
		    			</tr>
		    		</table>
		    		
			    	<div>
			    		<br><br>
			    		<button type = "button" onclick = "teacherLogin();" id = "teacherLoginButton" style = "background-image:url(Resource/Image/login.jpg); 
			    					width:95px; height:34px; background-color: transparent; border-style: none; cursor: pointer;"></button>
			    	</div>
		    	</form>
	    	</div>
	    	
	    	
	    <div class = "pos_links">
  			<a href = "http://www.most.gov.cn/">科学技术部</a>
  			<a href = "http://www.jgzx.org/">科学技术部科技经费监管服务中心</a>
  			<a href = "http://www.moe.edu.cn/">教育部</a>
  			<a href = "http://www.nsfc.gov.cn/">国家自然科学基金委员会</a>
  			<a href = "http://scit.nju.edu.cn/">南京大学科学技术处</a>
  			<a href = "http://ndcw.nju.edu.cn/">南京大学财务处</a>
  		</div>
    </div>
  </body>
</html>
