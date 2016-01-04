<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>编辑院系信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="shortcut icon" type="image/ico" href="JqueryLib/dataTable/images/favicon.ico" />
	<link href="JqueryLib/dataTable/css/demo_page.css" rel="stylesheet" type="text/css"/>
	<link href="JqueryLib/dataTable/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/dataTable/css/smoothness/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css"/>
    
    <script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	<!-- dataTables控件JS代码 -->
	<script type="text/javascript" src="JqueryLib/dataTable/js/jquery.dataTables.js"></script>
	
	<!-- 表单验证JS代码 -->
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	<link href="CSS/validationEngine/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/admin/fundamentalDataMaintainance/projectTypeEdit.js"></script>
	
	
	
	<script type="text/javascript">
		var projectTypePK = "<%= request.getParameter("projectTypePK")%>";
		var isModifyPage = "<%= request.getParameter("isModifyPage")%>"; 
	</script>
	
  </head>
  
  	<div align = "center" id="container">
  		
  		<div id="createNewDepartmentDialog" title="编辑项目类型" align = "center">
  			<div align = "left">
	   	&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);"><img src="Resource/Image/returnBack.jpg"  alt="返回上一页" title = "返回上一页"
	   			style = "width:43px; height:35px; background-color: transparent; border-style: none; cursor: pointer;"/></a>
	</div>
			<form id = "createNewDepartmentForm" method = "post">
				<table>
					<tr>
						<td>
							<label>项目类型ID</label>
						</td>
						<td>
							<input type="text" class="validate[required ]]" id="typeID" />
						</td>
					</tr>
					<tr>
						<td>
							<label>项目类型名称</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="typeName" />
						</td>
					</tr>									
												
				    <tr>
				    
                     <td class="departmentType"><label>文理科</label></td><td class="rightContent">
					<label><input type="radio" class="validate[required] radio" value="1" name="isWenke" id="wenKe"/>文科</label>
					<label><input type="radio" class="validate[required] radio" value="0" name="isWenke" id="liKe"/>理科</label>
					</td>			
					</tr>
					<tr>
						<td>
							<label>管理费1比例</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="pManage" />
						</td>
					</tr>
					<tr>
						<td>
							<label>管理费2比例 </label>
						</td>
						<td>
							<input type="text" class="validate[required, custom[number]]" id="pManage2" />
						</td>
					</tr>
					<tr>
						<td>
							<label>劳务费1比例</label>
						</td>
						<td>
							<input type="text" class="validate[custom[number]]" id="pPay" />
						</td>
					</tr>
					<tr>
						<td>
							<label>劳务费2比例</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="pPay2" />
						</td>
					</tr>
					<tr>
						<td>
							<label>专家咨询费比例</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="pConsult" />
						</td>
					</tr>
					<tr>
						<td>
							<label>业务活动费比例</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="pAct" />
						</td>
					</tr>
					<tr>
						<td>
							<label>改善工作条件费比例</label>
						</td>
						<td>
							<input type="text" class="validate[required]" id="pImprove" />
						</td>
					</tr>
					<tr>
					<td colspan="2"><input type="checkbox" id="pTaxCheck"/>  税金</td>
				</tr>

				
				<tr>
					<td>税金1</td>
					<td><input type="text" id="pTax1"  disabled=""/></td>
				</tr>
				
				<tr>
					<td>税金2</td>
					<td><input type="text" id="pTax2" disabled=""/></td>
				</tr>
				
				<tr>
					<td>税金3</td>
					<td><input type="text" id="pTax3"  disabled=""/></td>
					</tr>
				</table>
				<br/>
				<div>
					<button type="button" id = "assureButton">添加</button>
	  				<button type="button" id = "cancleButton">返回</button>
				</div>
			</form>
		</div>
		
		</div>


  	

  	
  <body>&nbsp; &nbsp; &nbsp; <br></body>
</html>
