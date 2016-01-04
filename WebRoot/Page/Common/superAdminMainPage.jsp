<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String tmp = (String)session.getAttribute("curr_superAdminID");
	if(tmp == null) {
%>
	<jsp:forward page="../../teacherLogin.jsp"></jsp:forward>
<%
	}
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>"></base>

		<title>STOMS super admin</title>
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
		
		<script type="text/javascript" src="JS/common/superAdminMainPage.js"></script>
		
		<script type="text/javascript">
			var userName = "<%=session.getAttribute("superAdminName")%>";
			var lastLoginIP = "<%=session.getAttribute("lastSuperAdminLoginIP")%>";
			var path = "<%=path%>";
		</script>
		
		
		<style type = "text/css">
		
			#menu li a {
				cursor: pointer;
			}
		</style>
	</head>

	<body class = "bodyBackGround">

		<div align="center">
			<div style = "width:960px;">
	
				<div id="header" style = "width:960px; height:105px;background:url(Resource/Image/header.jpg) repeat-x;">
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
					<iframe  id="contentIFrame" frameborder="0" src="Page/Admin/fundamentalDataMaintainance/adminListView.jsp" height="700px" width="960px"></iframe>
				</div>
	
				<div id="footer" style = "width:960px;height:40px; background-color:#99CCFF;">
					<br>Copyright@南京大学科技处 
				</div>
			</div>
		</div>
	</body>
</html>
