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
	
	<script type="text/javascript" src="JS/admin/outlayStatisticsQuery/inAccountQuery.js"></script>
	
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
  			<caption style = "height:40px;"><h4>入账经费查询</h4></caption>

  			<tr>
  			<td>
  			&nbsp;
  			项目名称<input type="text" id = "itemName" style = "width: 120px;"/>
  			&nbsp;&nbsp;&nbsp;&nbsp;
  			项目负责人<input type="text" id = "teacherName" style = "width: 120px;"/>
  			&nbsp;&nbsp;&nbsp;&nbsp;
  			经费卡号<input type="text" id = "cardID" style = "width: 120px;"/>
  			&nbsp;&nbsp;&nbsp;&nbsp;
  			项目代码<input type="text" id = "itemID" style = "width: 120px;"/>
  			</td>
  			</tr>
  			
  			<tr>
  			<td>
  			&nbsp;
  			合同编号<input type="text" id = "contractID" style = "width: 120px;"/>
  			&nbsp;&nbsp;&nbsp;
  			来款单位<input type="text" id = "inAccountDepartment" style = "width: 120px;"/>
  			
  			&nbsp;&nbsp;&nbsp;
  			<input id="invoiceCheck" type="checkbox"/>是否开发票
  			
  			&nbsp;&nbsp;&nbsp;
  			<label for = "iscross">项目类型&nbsp;&nbsp;</label>
  			<select id = "iscross" style = "width:60px;">  
  				<option value="-1">所&nbsp;有</option>
  				<option value="1">横&nbsp;向</option>
  				<option value="0">纵&nbsp;向</option>
  			</select>
  			
  			</td>
  			</tr>
  			
  			<tr>
					<td>
					&nbsp;
					<label>项目时间范围&nbsp;</label>
					<input type="text" id = "itemStartDate"  style = "width: 100px;"/>
					&nbsp;到&nbsp;
					<input type="text" id = "itemEndDate"   style = "width: 100px;"/>
					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					<label>入账时间范围&nbsp;</label>
					<input type="text" id = "inAccountStartDate" style = "width: 100px;"/>
					&nbsp;到&nbsp;
					<input type="text" id = "inAccountEndDate" style = "width: 100px;"/>
					
	            	</td>
				</tr>
				
  			<jsp:include page="/Page/Admin/projectQuery/queryInputModule.jsp"/>
  			
  				<tr>
	    			<td align = "center" colspan = "2">
	    				<button type="button" onclick = "inAccountQuery()">查询</button>
	    				<button type="reset">重置</button>
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
