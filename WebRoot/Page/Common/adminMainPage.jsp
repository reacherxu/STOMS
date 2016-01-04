<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	//String tmp = (String)session.getAttribute("curr_adminID");
	//if(tmp == null) {
%>
	
<%
	//}
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		
		<script type="text/javascript" src="JqueryLib/ddsmoothmenu/ddsmoothmenu.js"></script>
		
		<script type="text/javascript" src="JS/common/adminMainPage.js"></script>
		
		<script type="text/javascript">
			var userName = "<%=session.getAttribute("adminName")%>";
			var lastLoginIP = "<%=session.getAttribute("lastAdminLoginIP")%>";
			var path = "<%=path%>";
		</script>
		
		
		<style type = "text/css">
		
			#menu li a {
				cursor: pointer;
			}
		</style>
	</head>
	<body class = "bodyBackGround">
		<%@include file="/adminSessionCheck.jsp"%>
		<div align="center">
			<div style = "width:960px;">
	
				<div id="header" style = "width:960px; height:105px;background:url(Resource/Image/header.jpg) repeat-x;">
				</div>
	
				<div id="menu" style = "width:960px;height:35px;" class = "ddsmoothmenu">
					
						<ul>
							<li><a>项目信息查询</a></li>
							<li><a>入账经费查询</a></li>
							<li><a>基础数据</a>
								<ul>
									<li><a>院系信息</a></li>
									<li><a>教师信息</a></li>
									<li><a>项目类型</a></li>
								</ul>
							</li>
							<li><a>用户信息</a>
								<ul>
									<li><a>个人信息</a></li>
									<li><a>密码修改</a></li>
								</ul>
							</li>
							<li><a>增加经费</a>
							</li>
							<li><a>经费统计</a>
								<ul>
									<li><a>支出查询</a></li>
									<li><a>支出统计</a></li>
									<li><a>修改映射</a></li>
								</ul>
							</li>
						</ul>
					
				</div>
				
				<div style = "width:960px;height:30px;">
					<div style="float:left;">
						当前位置：<label id = "adminPagePathWayLabel"></label>
					</div>
					<div style = "float:right;">
						<label>用户名:&nbsp;</label><label id = "currentUserName"></label>    &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; 
						<label>上次登录IP:&nbsp;</label><label id = "currentUserLastLoginIP"></label> &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
						<button type = "button" onclick = "logout()" style = "background-image:url(Resource/Image/logout.bmp); width:49px; height:20px;
									 background-color: Transparent; border-style: none; cursor: pointer;"></button>
					</div>
				</div>
				
				<div id="content"  style="width:960px; heitht:700px; background-color:#FFFFFF;">
					<iframe  id="contentIFrame" frameborder="0" src="" height="700px" width="960px"></iframe>
				</div>
	
				<div id="footer" style = "width:960px;height:40px; background-color:#99CCFF;">
					<br>Copyright@南京大学科技处 
				</div>
			</div>
		</div>
	</body>
</html>
