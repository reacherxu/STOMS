<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>项目打印</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
    <script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JS/admin/projectQuery/itemPrint.js"></script>
	
	<script type="text/javascript">
	 	var itemPK = "<%= request.getParameter("itemPK")%>";
	</script>

	<script language=javascript>
		//打印指定区域内容 
		function preview() {
			bdhtml = window.document.body.innerHTML;
			sprnstr = "<!--startprint-->";
			eprnstr = "<!--endprint-->";
			prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17);
			prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));
			window.document.body.innerHTML = prnhtml;
			window.print();
		}
	</script>
	
	<style type="text/css">
		
		body {
			font-size:20px;
		}
		
		td {
			height:32px;
		}

	</style>
	
  </head>
  
  <body>
   	
   	<div align="center">
				<input name="print" type="button" onClick="preview()" value=" 打 印 ">
	</div>
   	
   	<!--startprint-->
   
   	
	<div style = "width:800px; padding-left:200px; font-family:'宋体',Simsun;">
	
		<table align="center" width="800px">
			<tr>
				<td></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期：<label id="printDate"></label></td>
			</tr>
			<tr>
				<td>系名称：<label id="departmentName"></label></td>
				<td>项目合同号：<label id="contractId"></label></td>
			</tr>
			<tr>
				<td width="400px">项目名称：<label id="itemName"></label></td>
				<td width="400px">项目编号：<label id="itemId"></label></td>
			</tr>
			<tr>
				<td>教师姓名1：<label id="teacherName"></label></td>
				<td>教师姓名2：<label id="otherTeacher"></label></td>
			</tr>
			<tr>
				<td colspan="2">项目时间范围：<label id="startDate"></label>&nbsp;&nbsp; 至 &nbsp;&nbsp;<label id="endDate"></label></td>
			</tr>
			<tr>
				<td colspan="2">是否已结题：<label id="isFinished"></label></td>
			</tr>
			<tr>
				<td></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id="operater"><%=session.getAttribute("adminName") %></label></td>
			</tr>
		</table>
		
	</div>
	
	<!--endprint-->
  </body>
</html>
