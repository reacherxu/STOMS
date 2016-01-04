<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>入账申请</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/idealForms/idealForms-theme-sapphire.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="CSS/validationEngine/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
    <link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/editable-select/jquery.editable-select.css" rel="stylesheet" type="text/css"/>
    
    <script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	<!--
	<script type="text/javascript" src="JqueryLib/editable-select/jquery.editable-select.js"></script>
	-->
	<script type="text/javascript" src="JqueryLib/SetEditComb.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/teacher/inAccountApplication/inAccountApplication.js"></script>
	
	<script type="text/javascript">
		var addOutlayPK = "<%= request.getParameter("addOutlayPK")%>";
	   	var itemID = "<%= request.getParameter("itemID")%>";
	</script>
	
	
	
	<style type="text/css">
	
		tr td:first {
			width:30%;
		}
		
		body {
			text-align:left;
		}
	</style>
	
	
  </head>
  
  <body>
   	
   	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
  	
  	<div>
  		<br><br>
  	</div>
  	
   	<div align = "center">
	   	<form id = "inAccountApplicationForm" method="post">
			<table align="center" style="width: 80%;">
					<caption style = "height:40px;">
						<h3>
							入账申请
						</h3>
					</caption>
				<tr>
						<td>
							项目名称:&nbsp; &nbsp;
							<label id="itemName"></label>
						</td>
						<td>
							课题编号:&nbsp; &nbsp;
							<label id="contractID"></label>
						</td>
					</tr>

					<tr>
						<td>
							项目负责人:&nbsp; &nbsp;
							<label id="teacherName"></label>
						</td>
						<td>
							其他负责人:&nbsp; &nbsp;
							<label id="otherTeacherName"></label>
						</td>
					</tr>
				<tr>
				<td> 选择入账类型：
						<select id="inAccountType" style = "height:20px; width:220px">
						</select>
				</td>
				</tr>
				<tr>
					<td>来款单位:&nbsp; &nbsp;
						<select id="inAccountDepartment" style = "width:180px;">
							<option></option>
							<option>教育部</option>
							<option>工业与信息化部</option>
							<option>国防科工委</option>
						</select>
					</td>
					<td>银行流水账号（ID号）:&nbsp; &nbsp;
						<input type="text"  id = "bankID"/>
						&nbsp;&nbsp;<a href = "http://ndcw.nju.edu.cn/cx3/baobiao/yhtzcx.aspx" target = "_blank">银行台账查询</a>
					</td>
				</tr>
				
				<tr>
					<td>
						间接经费卡:&nbsp; &nbsp;
						<label id="indirectID"></label>
					</td>
					<td>经费卡卡号:&nbsp; &nbsp;
						<select id="cardID" style = "width:170px;">
							<option value ="">请选择经费卡号</option>
						</select>
						<button type = "button" id = "createNewCardIDButton" onclick ="createNewCardIDButtonResponse()">开新卡</button>
					</td>
				</tr>
				
				<tr>
					<td>来款金额:&nbsp; &nbsp;
					<input type="text"  class="validate[required, custom[number]]" id = "outlayValue" onchange = "addoutInputWidgetOnchangeResponse()"/>&nbsp;&nbsp;元</td>
			
					<td>汇出金额:&nbsp; &nbsp;
					<input type="text"  class="validate[required, custom[number]]" id = "remitValue" onchange = "addoutInputWidgetOnchangeResponse()"/>&nbsp;&nbsp;元</td>
				</tr>
				
				<tr>
					<td>直接费用:&nbsp; &nbsp;
					<input type="text"  class="validate[required, custom[number]]" id = "DirectValue" onchange = "addDirectIndirectOnchangeResponse()"/>&nbsp;&nbsp;元</td>
			
					<td>间接费用:&nbsp; &nbsp;
					<input type="text"  class="validate[required, custom[number]]" id = "IndirectValue" onchange = "addDirectIndirectOnchangeResponse()"/>&nbsp;&nbsp;元</td>
				</tr>
				<tr>
					<td>绩效支出:&nbsp; &nbsp;
					<input type="text"  class="validate[required, custom[number]]" id = "Performance" onchange = "addDirectIndirectOnchangeResponse()"/>&nbsp;&nbsp;元</td>
			
					<td>设备购置费:&nbsp; &nbsp;
					<input type="text"  class="validate[required, custom[number]]" id = "Equipment" onchange = "addDirectIndirectOnchangeResponse()"/>&nbsp;&nbsp;元</td>
				</tr>
				
				<tr>
					<td>管理费1:&nbsp; &nbsp;
					<label id = "Manage"></label>&nbsp;&nbsp;元</td>
			
					<td>课题绩效支出:&nbsp; &nbsp;
					<label  id = "Performance2" ></label>&nbsp;&nbsp;元</td>
				</tr>
				<tr>
					<td>院系公共支出:&nbsp; &nbsp;
					<label id = "DepartmentPublic" ></label>&nbsp;&nbsp;元</td>
			
					<td>课题统筹支出:&nbsp; &nbsp;
					<label  id = "CoProject" ></label>&nbsp;&nbsp;元</td>
				</tr>
				
				
				<tr>
					<td colspan="2"><input type = "checkbox" id = "invoiceCheck"/>&nbsp;&nbsp;开据发票</td>
				</tr>
				
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发票抬头:&nbsp; &nbsp;
					<input type="text"  class="validate[required]" id = "invoiceTitle" disabled/></td>
				</tr>
				
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开票内容:&nbsp; &nbsp;
						<select id="invoiceDetail" style = "width:200px;" disabled>
							<option></option>
							<option>科研协作费</option>
							<option>课题费</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td ><input type = "checkbox" id = "taxCheck"/>&nbsp;&nbsp;税金</td>
					
				</tr>
				
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金1
						<label id = "tax1ProportionLabel"  style="font-size:70%;"></label>:&nbsp; &nbsp;
						<input type="text"  class="validate[required]" id = "tax1" disabled/>&nbsp;&nbsp;元</td>
				</tr>
				
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金2
						<label id = "tax2ProportionLabel"  style="font-size:70%;"></label>:&nbsp; &nbsp;
						<input type="text"  class="validate[required]" id = "tax2" disabled/>&nbsp;&nbsp;元</td>
				</tr>
				
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金3
						<label id = "tax3ProportionLabel"  style="font-size:70%;"></label>:&nbsp; &nbsp;
						<input type="text"  class="validate[required]" id = "tax3" disabled/>&nbsp;&nbsp;元</td>
				</tr>
				
			</table>
		</form>
		
		
		<!-- 上传部分   start -->	
	 	<div style = "width:80%;" align = "left">
	 		<br>
	 		
	 		<div>
		 		<div style = "float:left;">
					<form>
						<div style="width: 100px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
						<span id="spanButtonPlaceHolder"></span>
						</div>
					</form>
				</div>
				
				<div style = "float:left;">
					&nbsp;&nbsp;
				</div>
				
				<div style = "float:left; border: solid 1px #7FAAFF; background-color: #C5D9FF; width:100px; height:20px;" align="center">
					
					<label style=" cursor:pointer;" onclick="deleteItemPic()">删除所有附件</label> 
				</div>
			
			</div>
			
			<div>
				<br><br>
				<label>文件列表:</label>
				
				<div style = "padding-left: 50px;">
					<label id="uploadOutputResult"></label>
				</div>
			</div>
			
			<div id="divFileProgressContainer"></div>
		
		</div>
		<!-- 上传部分   end -->	
		
		<div align = "center">
				<br/><br/>
				<button type = "button" id = "inAccountApplicationSaveButton" onclick = "inAccountApplicationSaveResponse()">保存</button>
				<button type = "button" id = "inAccountApplicationSubmitButton">提交</button>
				<button type = "button" onclick = "resetInAccountApplicationForm()">重置</button>
		</div>
	</div>
	
	<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
			</div>
		
  </body>
</html>
