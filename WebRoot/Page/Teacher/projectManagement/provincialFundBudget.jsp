<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>省基金预算表</title>
    
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
	
	<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
		
	<!-- 表单验证JS代码 -->
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/teacher/projectManagement/provincialFundBudget.js"></script>
    
	<script type="text/javascript" src="JS/common/fileUpload.js"></script>
	<script type="text/javascript" src="JS/common/swfupload.js"></script>
	
	<script type="text/javascript">
		var swfu;
		window.onload = function () {
			swfu = new SWFUpload({
				// Backend Settings
				upload_url: "<%=path%>/fileUpload.action",
				post_params: { "itemPK" : "<%= request.getParameter("itemPk")%>"  },

				// File Upload Settings
				file_size_limit : "4 MB",	// 4MB
				file_types : "*.jpg;*.gif;*.png;*.jpeg;*.bmp*",
				file_types_description : "All Files",
				file_upload_limit : "0",
				
				// Event Handler Settings - these functions as defined in Handlers.js
				//  The handlers are not part of SWFUpload but are part of my website and control how
				//  my website reacts to the SWFUpload events.
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,

				// Button Settings
				button_image_url : "/STOMS/Resource/Image/SmallSpyGlassWithTransperancy_17x18.png",
				button_placeholder_id : "spanButtonPlaceHolder",
				button_width: 100,
				button_height: 18,
				button_text : '<span class="button">选择上传文件</span>',
				button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; }',
				button_text_top_padding: 0,
				button_text_left_padding: 18,
				button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
				button_cursor: SWFUpload.CURSOR.HAND,
				
				// Flash Settings
				flash_url : "swf/swfupload.swf",

				custom_settings : {
					upload_target : "divFileProgressContainer"
				},
				
				// Debug Settings
				debug: false
			});
		};
	</script>

	
	<style type="text/css">
	 	label {
	  		width: 148px;
	  	}
	  	input {
	  		width: 100px;
	  	}
  	</style>
  	
	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPk")%>";
	</script>

  </head>
  
  <body>
  
   <%@include file="/Page/Common/generalMessageDialog.jsp"%>
   <%@include file="/Page/Common/generalAssureDialog.jsp"%>
   
  
  
   <form id = "provincialFundBudgetForm" >
   	<div align="center"  >
		<table  align = "center" style="width: 70%"  border="1" cellspacing="0" borderColor="#7EC0EE"  >
			<caption><h2>省基金预算表</h2></caption>			 
			<tr>
				<td><label for = "itemName">项目(课题)名称</label></td>
				<td><label id = "itemName"></label></td>
			</tr>
			<tr>
				<td><label for = "contractID">课题编号</label></td>
				<td><label id = "contractID"></label></td>
			</tr>
			<tr>	
				<td><label for = "teacherName">项目负责人</label></td>
				<td><label id = "teacherName"></label></td>
			</tr>
			<tr bgColor="#F0FFF0">
				<td><b>项目总经费</b></td>
				<td><label id = "actualFundTotal"></label></td>
			</tr>
			<tr>
				<td>国家拨款</td>
				<td><input type="text" id = "actualFundNationFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>省科技厅拨款</td>
				<td><input type="text"  id = "actualFundAgencyFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>市县拨款</td>
				<td><input type="text"  id = "actualFundCountyFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>部门拨款</td>
				<td><input type="text"  id = "actualFundDepartmentFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>自筹(含贷款)</td>
				<td><input type="text"  id = "actualFundSelfFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>其他</td>
				<td><input type="text"  id = "actualFundOtherFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr bgColor="#E2E4FF">
				<td width="26%"><b>项目</b></td>
				<td width="18%"><b>预算情况</b></td>
			</tr>
			<tr>
				<td>(1)人员费</td>
				<td><input type="text" id="actualFundBudgetStaffCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(2)设备费</td>
				<td><input type="text" id="actualFundBudgetEquipmentCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(3)能源费</td>
				<td><input type="text" id="actualFundBudgetFuelCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(4)材料费</td>
				<td><input type="text" id="actualFundBudgetMaterialCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(5)试验外协费</td>
				<td><input type="text" id="actualFundBudgetTestCost" class = "validate[custom[number]]m"/></td>
			</tr>
			<tr>
				<td>(6)差旅费</td>
				<td><input type="text" id="actualFundBudgetTravelCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(7)会议费</td>
				<td><input type="text" id="actualFundBudgetConferenceCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(8)出版费</td>
				<td><input type="text" id="actualFundBudgetPublishCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(9)管理费</td>
				<td><input type="text" id="actualFundBudgetManageCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(10)其他费用</td>
				<td><input type="text" id="actualFundBudgetOtherCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr bgColor="#F0FFF0">
				<td><b>合计</b></td>
				<td><label id = "actualFundBudgetTotal"></label></td>
			</tr>
		</table>
		</div>
		</form>
		
	<!-- 上传部分   start -->	
	 	<div style="display: inline; width: 700px;">
	 	
		<form>
		<div style="float:left;width: 100px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
		<span id="spanButtonPlaceHolder"></span>
		</div>
		</form>
		
		<div style="float:left;">
		<label>文件列表:</label><label id="uploadOutputResult"></label>
		<label style="border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px; cursor:pointer;"
		onclick="deleteItemPic()">删除所有附件</label>
		</div>
		
		<div id="divFileProgressContainer"></div>
		
		
		</div>
	<!-- 上传部分   end -->	

		<div align = "center">
			<br/><br/>
			<button type = "button" id = "provincialFundSubmitButton">保存</button>
			<button type = "button" id = "resetButton" onclick = "resetForm()">重置</button>
		</div>
	
  </body>
</html>
