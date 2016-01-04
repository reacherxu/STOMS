<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国家基金预算表</title>
    
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
    
	<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/teacher/projectManagement/nationalFundBudget.js"></script>
	
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
				file_types : ".jpg;*.gif;*.png;*.jpeg;*.bmp",
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
  	
  	textarea {
  		width: 120px;
  		height: 30px;
  	}
  	
  	</style>
	
	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPk")%>";
	</script>
	
  </head>
  
  <body>
     	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
     	
   
  
   <form id = "nationalFundBudgetForm" >
	<div align="center"  >
		<table align="center" style = "width:80%;" border="1" cellspacing="0" borderColor="#7EC0EE">
			<caption><h2>国家基金预算表</h2></caption>			
			<tr>
				<td width="55%"><label for = "itemName">项目(课题)名称</label></td>
				<td width="45%" colspan="2"><label id = "itemName"></label></td>
			</tr>
			<tr>
				<td><label for = "teacherName">项目(课题)负责人</label></td>
				<td colspan="2"><label id = "teacherName"></label></td>
			</tr>
			<tr>
				<td><label for = "approveID">批准号</label></td>
				<td colspan="2"><input type="text"  class="validate[required]" id = "approveID"/></td>
			</tr>
			<tr>
				<td><label for = "dialFundsSum">已拨入经费(总额)</label></td>
				<td colspan="2"><input type="text"  class="validate[required, custom[number]]" id = "dialFundsSum"/></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td width="30%"><b>科目</b></td>
				<td width="30%"><b>预算经费</b></td>
				<td width="40%"><b>说明</b></td>
			</tr>
			<tr>
				<td bgColor=#F0FFF0><b>一.研究经费</b></td>
				<td><label id = "studyFund_Budget"></label></td>
				<td><textarea id = "studyFund_Remark"></textarea></td>
			</tr>
			<tr>
				<td>1.科研业务费</td>
				<td><label id = "sumBusiness_Budget"></label></td>
				<td><textarea id = "sumBusiness_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(1)测试/计算/分析费</td>
				<td><input type="text" id = "testCost_Budget" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><textarea id = "testCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(2)能源/动力费</td>
				<td><input type="text" id = "fuelCost_Budget" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><textarea id = "fuelCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(3)会议费/差旅费</td>
				<td><input type="text" id = "conferenceCost_Budget" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><textarea id = "conferenceCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(4)出版物/文献/信息传播事务费</td>
				<td><input type="text" id = "publishCost_Budget" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><textarea id = "publishCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(5)其他</td>
				<td><input type="text" id = "otherBusiness_Budget" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><textarea id = "otherBusiness_Remark"></textarea></td>
			</tr>
			<tr>
				<td>2.实验材料费</td>
				<td><label id = "sumMaterial_Budget"></label></td>
				<td><textarea id = "sumMaterial_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(1)原材料/试剂/药品购置费</td>
				<td><input type="text" id = "rawMaterial_Budget" class="validate[custom[number]]" onchange = "experimentMaterialSum()"/></td>
				<td><textarea id = "rawMaterial_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(2)其他</td>
				<td><input type="text" id = "otherMaterial_Budget" class="validate[custom[number]]" onchange = "experimentMaterialSum()"/></td>
				<td><textarea id = "otherMaterial_Remark"></textarea></td>
			</tr>
			<tr>
				<td>3.仪器设备费</td>
				<td><label id = "sumEquipment_Budget"></label></td>
				<td><textarea id = "sumEquipment_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(1)购置</td>
				<td><input type="text" id = "buyEquipment_Budget" class="validate[custom[number]]" onchange = "experimentEquipmentSum()"/></td>
				<td><textarea id = "buyEquipment_Remark"></textarea></td>
			</tr>
			<tr>
				<td>(2)试制</td>
				<td><input type="text" id = "trialEquipment_Budget" class="validate[custom[number]]" onchange = "experimentEquipmentSum()"/></td>
				<td><textarea id = "trialEquipment_Remark"></textarea></td>
			</tr>
			<tr>
				<td>4.实验室改装费</td>
				<td><input type="text" id = "laboratory_Budget" class="validate[custom[number]]" onchange = "researchFundSum()"/></td>
				<td><textarea id = "laboratory_Remark"></textarea></td>
			</tr>
			<tr>
				<td>5.协作费</td>
				<td><input type="text" id = "cooperation_Budget" class="validate[custom[number]]" onchange = "researchFundSum()"/></td>
				<td><textarea id = "cooperation_Remark"></textarea></td>
			</tr>
			<tr>
				<td bgColor=#F0FFF0><b>二.国际合作与交流费</b></td>
				<td><label id = "exchangeSum_Budget"></label></td>
				<td><textarea id = "exchangeSum_Remark"></textarea></td>
			</tr>
			<tr>
				<td>1.项目组成员出国合作交流</td>
				<td><input type="text" id = "exchange_Budget" class="validate[custom[number]]" onchange = "internatialExchangeSum()"/></td>
				<td><textarea id = "exchange_Remark"></textarea></td>
			</tr>
			<tr>
				<td>2.境外专家来华合作交流</td>
				<td><input type="text" id = "expert_Budget" class="validate[custom[number]]" onchange = "internatialExchangeSum()"/></td>
				<td><textarea id = "expert_Remark"></textarea></td>
			</tr>
			<tr>
				<td bgColor=#F0FFF0><b>三.劳务费</b></td>
				<td><input type="text" id = "serviceCost_Budget" class="validate[custom[number]]" onchange = "itemFundSum()"/></td>
				<td><textarea id = "serviceCost_Remark"></textarea></td>
			</tr>
			<tr>
				<td bgColor=#F0FFF0><b>四.管理费</b></td>
				<td><input type="text" id = "manageCost_Budget" class="validate[custom[number]]" onchange = "itemFundSum()"/></td>
				<td><textarea id = "manageCost_Remark"></textarea></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>合计</b></td>
				<td><label id = "sums_Budget"></label></td>
				<td><textarea id = "sums_Remark"></textarea></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>本项目其他经费来源</b></td>
				<td colspan="2"><b>预算经费</b></td>
			</tr>
			<tr>
				<td>国家其他计划资助经费</td>
				<td colspan="2"><input type="text" id = "otherPlanFundsBuget" class="validate[custom[number]]" onchange = "otherItemFundSum()"/></td>
			</tr>
			<tr>
				<td>其他经费资助（含部门匹配）</td>
				<td colspan="2"><input type="text" id = "otherSubsidizeBuget" class="validate[custom[number]]" onchange = "otherItemFundSum()"/></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>其他经费来源合计</b></td>
				<td colspan="2"><label id = "otherSumBuget"></label></td>		
			</tr>
	
		</table>
		</div>
		
		<div style="padding-left:10%;">
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
		</div>
		
		<div align = "center">
			<br/><br/>
			<button type = "button" id = "nationalFundBudgetSavaButton">保存</button>
			<button type = "button" onclick = "resetForm()">重置</button>
		</div>
		
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
		
	</form>
  </body>
</html>
