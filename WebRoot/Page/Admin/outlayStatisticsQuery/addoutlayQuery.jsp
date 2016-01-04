<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>入账经费查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
	<link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/css/datepickerCss/datepicker_demo.css" rel="stylesheet" type="text/css"/>
    
    <link rel="shortcut icon" type="image/ico" href="JqueryLib/dataTable/images/favicon.ico" />
    <link href="JqueryLib/dataTable/css/demo_page.css" rel="stylesheet" type="text/css"/>
	<link href="JqueryLib/dataTable/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/dataTable/css/smoothness/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<!-- dataTables控件JS代码 -->
	<script type="text/javascript" src="JqueryLib/dataTable/js/jquery.dataTables.js"></script>
	
	<!-- UI界面JS代码 -->
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/admin/outlayStatisticsQuery/addoutlayQuery.js"></script>
	
	<style type="text/css">
	
		a {
		    color: #0063DC;
		    cursor: pointer;
		    text-decoration: none;
		}
		
		a:hover {
			text-decoration: underline;
		}
		
		.ui-datepicker table td{
			height:20px;
		}
		
		.grayALink {
			color: #808080;
		}
		
		#scienceItemTypeTable td {
			width:165px;
			height:20px;
		}
		
		#artsItemTypeDIV td {
			width:165px;
			height:20px;
		}
		
		#departmentTable td {
			width:100px;
			height:20px;
		}
		
		.ui-accordion .ui-accordion-content {
		    border-top: 0 none;
		    display: none;
		    margin-bottom: 2px;
		    margin-top: -2px;
		    overflow: auto;
		    padding: 0.5em 1em;
		    position: relative;
		    top: 1px;
		}
		
	</style>
	
  </head>
  
  <body>
  	<div align = "center">
  		<form method = "post" style = "width:95%;">
  			<table style = "width:100%;">
  			<caption style = "height:40px;"><h4>经费信息查询</h4></caption>

  			<tr>
					<td align="right">
						<label for = "itemid">项目代码:&nbsp;&nbsp;</label>
	            	</td>
	            	<td>
						<input type="text" id = "itemid"/>
	            	</td>
	            	<td align="right">
						<label for = "itemvalue">项目金额:&nbsp;&nbsp;</label>
	            	</td>
	            	<td>
						<input type="text" id = "itemvalue"/>
	            	</td>
	            	<td align="right">
						<label for = "remitvalue">汇出金额:&nbsp;&nbsp;</label>
	            	</td>
	            	<td>
						<input type="text" id = "remitvalue"/>
	            	</td>
	            	<td align="right">
						<label for = "iscross">项目类型:&nbsp;&nbsp;</label>
	            	</td>
	            	<td>
						<select id = "iscross">  
							<option value="2">所&nbsp;有</option>
							<option value="1">横&nbsp;向</option>
							<option value="0">纵&nbsp;向</option>
						</select>
	            	</td>
				</tr>
				<tr>
					<td align="right">
						<label for = "outlaydepartment">来款单位:&nbsp;&nbsp;</label>
	            	</td>
	            	<td>
						<input type="text" id = "outlaydepartment"/>
	            	</td>
					<td align="right">
						<label for = "teachername">负责人姓名:&nbsp;&nbsp;</label>
	            	</td>
	            	<td>
						<input type="text" id = "teachername"/>
	            	</td>
	            	<td align="right">
						<label for = "departmentid">院系代码:&nbsp;&nbsp;</label>
	            	</td>
	            	<td>
						<input type="text" id = "departmentid"/>
	            	</td>
	            	<td align="right">
						<label for = "departmenttype">院系类别:&nbsp;&nbsp;</label>
	            	</td>
	            	<td>
						<select id = "departmenttype">  
							<option value="">所&nbsp;有</option>
							<option value="文科">文&nbsp;科</option>
							<option value="理科">理&nbsp;科</option>
						</select>
	            	</td>
				</tr>
				<tr>
	            	<td align="right">
						<label>时间范围:&nbsp;&nbsp;</label>
	            	</td>
	            	<td colspan = "7">
						<input type="text" id = "startDate"/>
						&nbsp;&nbsp;&nbsp;&nbsp;到&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" id = "endDate"/>
						*将查询入账时间在该时间段内的入账记录
	            	</td>
				</tr>
  			
  				<tr>
	    			<td align = "center" colspan = "8">
	    				<button type="button" onclick = "inAccountQuery()">查询</button>
	    				<button type="reset">重置</button>
	    				&nbsp;&nbsp;
	    				<input type="button" onclick="exportToExcel();" value="导出EXCEL"> 
	    			</td>
		    	</tr>

		    	<tr>
		    		<div id = "dt_example">
		    			<div align = "center">
		    				<div style = "width:95%" align = "left" id="container">
		    					<div class = "demo_jui">
		    					<table id = "inAccountQueryTable" cellpadding="0" cellspacing="0" border="0" class="display">
								</table>
								</div>
							</div>
						</div>
					</div>
				</tr>
		    	
  			</table>
  		</form>
  	</div>
  	
  </body>
</html>
