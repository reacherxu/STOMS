<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国家科技计划项目<863>概算表</title>
    
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
    
	<script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	
	<script type="text/javascript" src="JS/teacher/projectManagement/nation863BudgetForm.js"></script>
  
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
  	
  	input {
  		width: 100px;
  		height:80%;
  	}
  	
  	td {
  		height:30px;
  	}
  	
  	</style>
  	
  	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPk")%>";
	   var indexOfBudget = "<%= request.getParameter("indexOfBudget")%>";
	</script>
  	
  </head>
  
    </head>
    <body>
    
  		<div align="center">
  		
  			<div style = "width:90%;">
	  			<h2>国家科技计划项目预算表</h2>
	  			<br>
	  			<div>
	  				<table style = "width:100%;">
	  					<tr>
	  						<td>课题名称：<label id = "itemName"></label></td>
	  						<td>课题编号：<label id = "contractID"></label></td>
	  						<td>负责人：<label id = "teacherName"></label></td>
	  						<td>内款项码：<label id = "insideID"></label></td>
	  						<td>经费卡号：<label id = "cardID"></label></td>
	  					</tr>
	  				</table>
	  			</div>
	  			
	  			<div>
	  				<div style="float:left;">
	  					预算年度：
	  					<select id="startYear" style = "width:80px;"></select>
		            	&nbsp;&nbsp;至&nbsp;&nbsp;
		            	<select id="endYear" style = "width:80px;"></select>
	  				</div>
	  				
	  				<div style="float:right;">
	  					<button type = "button" onclick = "addCooperationButtonOnclickResponse()">增加协作单位</button>
	  				</div>
	  			</div>
	  			
  				<br><br>
  				
  				<div align = "right">
  					单位：万元
  				</div>
  				
	  			<div>
			       <form id = "nation863BudgetForm">
				        <table align = "center" style = "width:100%;" border="1" cellspacing="0" borderColor="#7EC0EE" id = "a863BudgetFormTable">
							<tr bgColor=#e2e4ff>
								<td rowspan="2" valign="middle">预算科目名称</td>
								<td rowspan="2" id = "tableHeaderTD">批复预算数</td>
							</tr>
							<tr>
								<td id = "organizationNameTD"></td>
							</tr>
							
							<tr bgColor=#F0FFF0>
								<td >一.经费支出</td>
								<td id = "outGoingsTD"><label id = "outGoings_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;（一）直接费用</td>
								<td id = "directCostTD"><label id = "directCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp; &nbsp; 1.设备费</td>
								<td id = "equipmentCostTD"><label id = "equipmentCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp; (1)购置设备费</td>
								<td id = "buyCostTD"><label id = "buyCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp; (2)试制设备费</td>
								<td id = "tryToMakeCostTD"><label id = "tryToMakeCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp; (3)设备改造与租赁费</td>
								<td id = "reformLeaseCostTD"><label id = "reformLeaseCost_Sum"></label></td>
								
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 2.材料费</td>
								<td id = "materialCostTD"><label id = "materialCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 3.测试化验加工费</td>
								<td id = "testCostTD"><label id = "testCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 4.燃料动力费</td>
								<td id = "fuelCostTD"><label id = "fuelCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 5.差旅费</td>
								<td id = "travelCostTD"><label id = "travelCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 6.会议费</td>
								<td id = "conferenceCostTD"><label id = "conferenceCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 7.国际合作与交流费</td>
								<td id = "internationalCostTD"><label id = "internationalCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 8.出版/文献/信息传播/知识产权事务</td>
								<td id = "publishCostTD"><label id = "publishCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 9.劳务费</td>
								<td id = "labourCostTD"><label id = "labourCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 10.咨询费</td>
								<td id = "consultationCostTD"><label id = "consultationCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 11.基本建设费</td>
								<td id = "constructionCostTD"><label id = "constructionCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 12.其他支出</td>
								<td id = "otherCostTD"><label id = "otherCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;（二）间接费用</td>
								<td id = "indirectCostTD"><label id = "indirectCost_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 其中：绩效支出</td>
								<td id = "achievementsCostTD"><label id = "achievementsCost_Sum"></label></td>
							</tr>
							<tr bgColor=#F0FFF0>
								<td>二.经费来源</td>
								<td id = "fundSourseTD"><label id = "fundSourse_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;(一)申请从专项经费获得的资助</td>
								<td id = "specialFundSourceTD"><label id = "specialFundSource_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;(二)自筹经费来源</td>
								<td id = "selfFundSourceTD"><label id = "selfFundSource_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 1.其他财政拨款</td>
								<td id = "otherFinanceSourceTD"><label id = "otherFinanceSource_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 2.单位自有货币资金</td>
								<td id = "itsOwnSourceTD"><label id = "itsOwnSource_Sum"></label></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp; 3.其他资金</td>
								<td id = "otherSourceTD"><label id = "otherSource_Sum"></label></td>
							</tr>
			        	</table>

						<div style="padding-left: 0%;">
							<!-- 上传部分   start -->
							<div style="display: inline; width: 700px;">

								<form>
									<div
										style="float: left; width: 100px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
										<span id="spanButtonPlaceHolder"></span>
									</div>
								</form>

								<div style="float: left;">
									<label>
										文件列表:
									</label>
									<label id="uploadOutputResult"></label>
									<label
										style="border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px; cursor: pointer;"
										onclick="deleteItemPic()">
										删除所有附件
									</label>
								</div>

								<div id="divFileProgressContainer"></div>


							</div>
							<!-- 上传部分   end -->
						</div>


						<div align = "center">
							<br/><br/>
							<button type = "button" id = "nation863BudgetSaveButton">保存</button>
							<button type = "reset">重置</button>
						</div>
			       </form>
		        </div>
	        </div>
        </div>
        <div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
  </body>
</html>
