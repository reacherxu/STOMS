<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String tmp = (String)session.getAttribute("curr_teacherID");
	if(tmp == null) {
%>
	<jsp:forward page="../../teacherLogin.jsp"></jsp:forward>
<%
	}
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

		<link rel="stylesheet" type="text/css" href="CSS/page.css">
		<link rel="stylesheet" type="text/css" href="JqueryLib/ddsmoothmenu/ddsmoothmenu.css">
		<link rel="stylesheet" type="text/css" href="JqueryLib/ddsmoothmenu/ddsmoothmenu-v.css">
		
		<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
		<script type="text/javascript" src="JS/common/util.js"></script>
		<script type="text/javascript" src="JS/common/teacherMainPage.js"></script>
		<script type="text/javascript" src="JqueryLib/ddsmoothmenu/ddsmoothmenu.js"></script>
		
		<script type="text/javascript">
			var userType = "<%=session.getAttribute("userType")%>";
			var userName = "<%=session.getAttribute("teacherName")%>";
			var lastLoginIP = "<%=session.getAttribute("lastLoginIP")%>";
			var path = "<%=path%>";
		</script>
		
	</head>

	<body class = "bodyBackGround">
		<div align="center">
			<div style = "width:960px;">
	
				<div id="header" style = "width:960px; height:105px;background:url(Resource/Image/header.jpg) repeat-x;">
				</div>
				
				<div id="menu" style = "width:960px;height:35px;" class = "ddsmoothmenu">
					
						<ul>
							<li><a style="cursor: pointer">我的项目</a></li>
							<li><a style="cursor: pointer">经费统计</a>
								<ul>
									<li><a>支出查询</a></li>
									<li><a>支出统计</a></li>
								</ul>
							</li>
							<li><a style="cursor: pointer">用户信息</a>
								<ul>
									<li><a style="cursor: pointer">个人资料</a></li>
									<li><a style="cursor: pointer">密码修改</a></li>
									<li><a style="cursor: pointer">授权管理</a></li>
								</ul>
							</li>
						</ul>
					
				</div>
				
				<div style = "width:960px;height:30px;">
					<div style="float:left;">
						当前位置：<label id = "teacherPagePathWayLabel"></label>
					</div>
					<div style = "float:right;">
						<label>用户名:&nbsp;</label><label id = "currentUserName"></label>    &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; 
						<label>上次登录IP:&nbsp;</label><label id = "currentUserLastLoginIP"></label> &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
						<button type = "button" onclick = "logout()" style = "background-image:url(Resource/Image/logout.bmp); width:49px; height:20px;
									 background-color: Transparent; border-style: none; cursor: pointer;"></button>
					</div>
				</div>
	
				<div style = "width:960px;height:700px;">
					<iframe  id="contentIFrame" frameborder="0" src="Page/Teacher/projectManagement/projectRegistrationList.jsp" height="100%" width="100%"></iframe>
				</div>
	
				<div id="footer" style = "width:960px;height:40px; background-color:#99CCFF;">
					<br>Copyright@南京大学科技处 
				</div>
			</div>
		</div>
	</body>
</html>
