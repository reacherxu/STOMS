<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>国家重大专项课题支出预算科目调整情况表</title>
    
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
	
	<script type="text/javascript" src="JS/teacher/projectManagement/863Adjust.js"></script>
	
	
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
	   var a863adjustPk = "<%= request.getParameter("a863adjustPk")%>";
	</script>
	
  </head>
  
    </head>
    <body>
    
    <%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
  	
    
  		<div align="center">
	       <form id = "nation863AdjustForm">
	        
	       <table align="center" style = "width:90%;"  border="1" cellspacing="0" borderColor="#7EC0EE">
			<caption style = "height:50px;"><h2>国家重大专项课题支出预算科目调整情况表</h2></caption>			
				<tr bgColor=#e2e4ff>
					<td width="34%"><b>科目</b></td>
					<td width="22%"><b>批准专项经费预算</b></td>
					<td width="22%"><b>计划调整专项经费预算</b></td>
					<td width="22%"><b>调整后专项经费预算</b></td>
				</tr>
				<tr>
					<td >一.经费支出</td>
					<td><label id = "costSum_before"></label></td>
					<td><label id = "costSum_adjust"></label></td>
					<td><label id = "costSum_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 1.设备费</td>
					<td><label id = "equipmentCost_before"></label></td>
					<td><input type="text" id = "equipmentCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "equipmentCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 2.材料费</td>
					<td><label id = "materialCost_before"></label></td>
					<td><input type="text" id = "materialCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "materialCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 3.测试化验加工费</td>
					<td><label id = "testCost_before"></label></td>
					<td><input type="text" id = "testCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "testCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 4.燃料动力费</td>
					<td><label id = "fuelCost_before"></label></td>
					<td><input type="text" id = "fuelCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "fuelCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 5.差旅费</td>
					<td><label id = "travelCost_before"></label></td>
					<td><input type="text" id = "travelCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "travelCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 6.会议费</td>
					<td><label id = "conferenceCost_before"></label></td>
					<td><input type="text" id = "conferenceCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "conferenceCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 7.国际合作与交流费</td>
					<td><label id = "exchangeCost_before"></label></td>
					<td><input type="text" id = "exchangeCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "exchangeCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 8.出版/文献/信息传播/知识产权/事务费</td>
					<td><label id = "publishCost_before"></label></td>
					<td><input type="text" id = "publishCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "publishCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 9.劳务费</td>
					<td><label id = "serviceCost_before"></label></td>
					<td><input type="text" id = "serviceCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "serviceCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 10.专家咨询费</td>
					<td><label id = "consultCost_before"></label></td>
					<td><input type="text" id = "consultCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "consultCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 11.间接费用</td>
					<td><label id = "indirectCost_before"></label></td>
					<td><input type="text" id = "indirectCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "indirectCost_after"></label></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; 12.其他费用</td>
					<td><label id = "otherCost_before"></label></td>
					<td><input type="text" id = "otherCost_adjust" class="validate[custom[number]]" onchange = "costSum()"/></td>
					<td><label id = "otherCost_after"></label></td>
				</tr>
				<tr>
					<td colspan="4"><b>调整时间&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text"  class="validate[required] text-input datepicker" id = "ntime"/></td>
				</tr>
	        	</table>
	        	</form>
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
					<button type = "button" id = "nation863AdjustSaveButton">保存</button>
					<button type = "submit" id = "nation863AdjustSubmitButton">提交</button>
					<button type = "button" onclick = "resetForm()">重置</button>
				</div>
				
				<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
			</div>
	       
  </body>
</html>
