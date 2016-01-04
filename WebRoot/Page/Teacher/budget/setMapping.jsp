<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectMapping.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="CSS/page.css">
	
	<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	<script type="text/javascript" src="JS/teacher/budget/setMapping.js"></script>
	
	<script type="text/javascript">
  		var projectId = "<%=request.getParameter("projectId")%>";
  		var teacherId = "<%=session.getAttribute("curr_teacherID")%>";
	</script>
	
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
	.button {
	display: inline-block;
	zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
	*display: inline;
	vertical-align: baseline;
	margin: 0 2px;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .2em 1em .25em;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
	-webkit-border-radius: .5em;
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
}

.button:hover {
	text-decoration: none;
}

.button:active {
	position: relative;
	top: 1px;
}

/* white */
.white {
	color: #606060;
	border: solid 1px #b7b7b7;
	background: #fff;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff),
		to(#ededed) );
	background: -moz-linear-gradient(top, #fff, #ededed);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff',
		endColorstr='#ededed' );
}

.white:hover {
	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff),
		to(#dcdcdc) );
	background: -moz-linear-gradient(top, #fff, #dcdcdc);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff',
		endColorstr='#dcdcdc' );
}

.white:active {
	color: #999;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed),
		to(#fff) );
	background: -moz-linear-gradient(top, #ededed, #fff);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed',
		endColorstr='#ffffff' );
}
	</style>
  </head>
  
<body>
  
  	<div>
  		<br><br>
  	</div>
  	
    <div align = "center">
	    <form method = "post" id = "mappingForm">
		    <table>
		    	<caption><h3>预算分配</h3></caption>
		    	<tr>
					<td>
						<center><h4>预算科目</h4></center>
					</td>
					<td>
						<center><h4>包含支出科目</h4></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left"><h4>一.研究经费</h4>
					</td>
					
					<td>
						<center><input type="hidden" readonly id="research" size="60" onclick="selectItem0(this)"/> </center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">1.科研业务费
					</td>
					
					<td>
						<center><input type="hidden" readonly id = "srbusiness" size="60" onclick="selectItem1(this)"/></center>
					</td>
				</tr>
				<tr>			
					<td>
						<p style="text-align: left">（1）测试/计算/分析费
					</td>
					
					<td>
						<center><input type="text" readonly id = "test" size="60" onclick="selectItem2(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">（2）能源/动力费
					</td>
					
					<td>
						<center><input type="text" readonly id = "energy" size="60" onclick="selectItem3(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">（3）会议费/差旅费
					</td>
					
					<td>
						<center><input type="text" readonly id = "meetings" size="60" onclick="selectItem4(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">（4）出版物/文献/信息传播费
					</td>
					
					<td>
						<center><input type="text" readonly id = "publishments" size="60" onclick="selectItem5(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">（5）其他
					</td>
					
					<td>
						<center><input type="text" readonly id = "other_srbusiness" size="60" onclick="selectItem6(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">2.实验材料费
					</td>
					
					<td>
						<center><input type="hidden" readonly id = "experiment_material" size="60" onclick="selectItem7(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">（1）原材料/试剂/药品购置费
					</td>
					
					<td>
						<center><input type="text" readonly id = "raw_material" size="60" onclick="selectItem8(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">（2）其他
					</td>
					
					<td>
						<center><input type="text" readonly id = "other_material" size="60" onclick="selectItem9(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">3.仪器设备费
					</td>
					
					<td>
						<center><input type="hidden" readonly id = "equipment" size="60" onclick="selectItem10(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">（1）购置
					</td>
					
					<td>
						<center><input type="text" readonly id = "equipment_purchase" size="60" onclick="selectItem11(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">（2）试制
					</td>
					
					<td>
						<center><input type="text" readonly id = "equipment_produce" size="60" onclick="selectItem12(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">4.实验室改装费
					</td>
					
					<td>
						<center><input type="text" readonly id = "lab_reconstruction" size="60" onclick="selectItem13(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">5.协作费
					</td>
					
					<td>
						<center><input type="text" readonly id = "collaboration" size="60" onclick="selectItem14(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left"><h4>二.国际合作与交流费</h4>
					</td>
					
					<td>
						<center><input type="hidden" readonly id = "international_communication" size="60" onclick="selectItem15(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">1.项目组成员出国合作交流
					</td>
					
					<td>
						<center><input type="text" readonly id = "export_communication" size="60" onclick="selectItem16(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left">2.境外专家来华合作交流
					</td>
					
					<td>
						<center><input type="text" readonly id = "import_communication" size="60" onclick="selectItem17(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left"><h4>三.劳务费</h4>
					</td>
					
					<td>
						<center><input type="text" readonly id = "labour" size="60" onclick="selectItem18(this)"/></center>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: left"><h4>四.管理费</h4>
					</td>
					
					<td>
						<center><input type="text" readonly id = "management" size="60" onclick="selectItem19(this)"/></center>
					</td>
				</tr>
		    </table>
		    <table width="585">
		    	<tr>
		    		<td width="136"> <button class="button white" type="button" id = "resetButton" style="width: 100px">恢复默认</button></td>
		    		<td width="137"><button class="button white" type="button" id = "clearButton" style="width: 100px">清空设置</button></td>
		    		<td><button class="button white" type="button" id = "saveButton" style="width: 100px">保存设置</button></td>
		    		<td><button class="button white" type="button" id = "startButton" style="width: 100px">开始统计</button></td>
		    	</tr>
		    </table>
	    </form>
	</div>
  </body>
</html>
