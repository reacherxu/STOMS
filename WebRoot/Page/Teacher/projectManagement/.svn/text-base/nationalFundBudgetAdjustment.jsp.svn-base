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
	
	<script type="text/javascript" src="JS/teacher/projectManagement/nationalFundBudgetAdjustment.js"></script>
	
	
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
				file_types : "*.*",
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
	   var itemPK = "<%= request.getParameter("itemPK")%>";
	    var nationalFundAdjustPk = "<%= request.getParameter("nationalFundAdjustPk")%>";
	</script>
	
  </head>
  
  <body>
   	
   	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
  	
  	
  	
   <form id = "nationalFundBudgetAdjustForm" >
		<div align="center"  >
		<table align="center" style = "width:90%;"  border="1" cellspacing="0"  borderColor="#7EC0EE">
			<caption><h2>国家基金预算表</h2></caption>			
			<tr>
				<td><label for = "itemName">项目(课题)名称</label></td>
				<td colspan="5"><label id = "itemName"></label></td>
			</tr>
			<tr>
				<td><label for = "teacherName">项目(课题)负责人</label></td>
				<td><label id = "teacherName"></label></td>
				<td><label for = "approveID">批准号</label></td>
				<td colspan="2"><label id = "approveID"></label></td>
			</tr>
			<tr>
				<td><label for = "dialFundsSum">已拨入经费(总额)</label></td>
				<td colspan="3"><input type="text"  style = "width:50%;" class="validate[required, custom[number]]" id = "dialFundsSum"/></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td width="40%"><b>科目</b></td>
				<td width="20%"><b>预算经费</b></td>
				<td width="20%"><b>调整经费</b></td>
				<td width="20%"><b>预算总经费</b></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>一.研究经费</b></td>
				<td><label id = "studyFund_Budget"></label></td>
				<td><label id = "studyFund_Adjust"></label></td>
				<td><label id = "studyFund_BudgetSum"></label></td>
			<tr>
				<td>1.科研业务费</td>
				<td><label id = "sumBusiness_Budget"></label></td>
				<td><label id = "sumBusiness_Adjust"></label></td>
				<td><label id = "sumBusiness_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(1)测试/计算/分析费</td>
				<td><label id = "testCost_Budget"></label></td>
				<td><input type="text" id = "testCost_Adjust" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><label id = "testCost_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(2)能源/动力费</td>
				<td><label id = "fuelCost_Budget"></label></td>
				<td><input type="text" id = "fuelCost_Adjust" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><label id = "fuelCost_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(3)会议费/差旅费</td>
				<td><label id = "conferenceCost_Budget"></label></td>
				<td><input type="text" id = "conferenceCost_Adjust" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><label id = "conferenceCost_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(4)出版物/文献/信息传播事务费</td>
				<td><label id = "publishCost_Budget"></label></td>
				<td><input type="text" id = "publishCost_Adjust" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><label id = "publishCost_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(5)其他</td>
				<td><label id = "otherBusiness_Budget"></label></td>
				<td><input type="text" id = "otherBusiness_Adjust" class="validate[custom[number]]" onchange = "reserchBusinessSum()"/></td>
				<td><label id = "otherBusiness_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>2.实验材料费</td>
				<td><label id = "sumMaterial_Budget"></label></td>				
				<td><label id = "sumMaterial_Adjust"></label></td>
				<td><label id = "sumMaterial_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(1)原材料/试剂/药品购置费</td>
				<td><label id = "rawMaterial_Budget"></label></td>
				<td><input type="text" id = "rawMaterial_Adjust" class="validate[custom[number]]" onchange = "experimentMaterialSum()"/></td>
				<td><label id = "rawMaterial_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(2)其他</td>
				<td><label id = "otherMaterial_Budget"></label></td>
				<td><input type="text" id = "otherMaterial_Adjust" class="validate[custom[number]]" onchange = "experimentMaterialSum()"/></td>
				<td><label id = "otherMaterial_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>3.仪器设备费</td>
				<td><label id = "sumEquipment_Budget"></label></td>
				<td><label id = "sumEquipment_Adjust"></label></td>
				<td><label id = "sumEquipment_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(1)购置</td>
				<td><label id = "buyEquipment_Budget"></label></td>
				<td><input type="text" id = "buyEquipment_Adjust" class="validate[custom[number]]" onchange = "experimentEquipmentSum()"/></td>
				<td><label id = "buyEquipment_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(2)试制</td>
				<td><label id = "trialEquipment_Budget"></label></td>
				<td><input type="text" id = "trialEquipment_Adjust" class="validate[custom[number]]" onchange = "experimentEquipmentSum()"/></td>
				<td><label id = "trialEquipment_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>4.实验室改装费</td>
				<td><label id = "laboratory_Budget"></label></td>
				<td><input type="text" id = "laboratory_Adjust" class="validate[custom[number]]" onchange = "researchFundSum()"/></td>
				<td><label id = "laboratory_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>5.协作费</td>
				<td><label id = "cooperation_Budget"></label></td>
				<td><input type="text" id = "cooperation_Adjust" class="validate[custom[number]]" onchange = "researchFundSum()"/></td>
				<td><label id = "cooperation_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>二.国际合作与交流费</b></td>
				<td><label id = "exchangeSum_Budget"></label></td>
				<td><label id = "exchangeSum_Adjust"></label></td>
				<td><label id = "exchangeSum_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>1.项目组成员出国合作交流</td>
				<td><label id = "exchange_Budget"></label></td>
				<td><input type="text" id = "exchange_Adjust" class="validate[custom[number]]" onchange = "internatialExchangeSum()"/></td>
				<td><label id = "exchange_BudgetSum"></label></td>
			<tr>
				<td>2.境外专家来华合作交流</td>
				<td><label id = "expert_Budget"></label></td>
				<td><input type="text" id = "expert_Adjust" class="validate[custom[number]]" onchange = "internatialExchangeSum()"/></td>
				<td><label id = "expert_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>三.劳务费</b></td>
				<td><label id = "serviceCost_Budget"></label></td>
				<td><input type="text" id = "serviceCost_Adjust" class="validate[custom[number]]" onchange = "itemFundSum()"/></td>
				<td><label id = "serviceCost_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>四.管理费</b></td>
				<td><label id = "manageCost_Budget"></label></td>
				<td><input type="text" id = "manageCost_Adjust" class="validate[custom[number]]" onchange = "itemFundSum()"/></td>
				<td><label id = "manageCost_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>合计</b></td>
				<td><label id = "sums_Budget"></label></td>
				<td><label id = "sums_Adjust"></label></td>
				<td><label id = "sums_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>已拨入经费结余</td>
				<td colspan="3"><label style = "width:100%;" id = "dialFundsLast"></label></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>本项目其他经费来源</b></td>
				<td colspan="1">预算经费</td>
				<td colspan="2">经费支出</td>
			</tr>
			<tr>
				<td>国家其他计划资助经费</td>
				<td colspan="1"><input  style = "width:90%;" type="text" id = "otherPlanFundsBuget" class="validate[custom[number]]" onchange = "otherItemFundSum()"/></td>
				<td colspan="2"><input style = "width:60%;" type="text" id = "otherPlanFundsOutlay"/></td>
			</tr>
			<tr>
				<td>其他经费资助（含部门匹配）</td>
				<td colspan="1"><input  style = "width:90%;" type="text" id = "otherSubsidizeBuget" class="validate[custom[number]]" onchange = "otherItemFundSum()"/></td>
				<td colspan="2"><input style = "width:60%;" type="text" id = "otherSubsidizeOutlay"/></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>其他经费来源合计</b></td>
				<td colspan="1"><label style = "width:90%;" id = "otherSumBuget"></label></td>
				<td colspan="2"><label style = "width:60%;" id = "otherSumOutlay"></label></td>			
			</tr>	
			<tr>		
			<td colspan="4"><b>调整时间 &nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" class="validate[required] text-input datepicker"  id = "ntime"/></td>
			</tr>
		</table>
		</div>
		<div style="padding-left:5%;">
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
			<button type = "button" id = "nationalFundBudgetAdjustmentSavaButton">保存</button>
			<button type = "submit" id = "nationalFundBudgetAdjustmentSubmitButton">提交</button>
			<button type = "button" onclick = "resetForm()">重置</button>
		</div>
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
		
	</form>
  </body>
</html>
