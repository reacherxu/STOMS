<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>编辑入账信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
	<link href="CSS/idealForms/idealForms-theme-sapphire.css" rel="stylesheet" type="text/css" media="screen"/>
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
	
	<script type="text/javascript" src="JS/admin/outlayStatisticsQuery/addoutlayEdit.js"></script>
	
	
	
	<script type="text/javascript">
		var addOutlayPK = "<%= request.getParameter("addOutlayPK")%>";
		var isModifyPage = "<%= request.getParameter("isModifyPage")%>"; 
		var itemID = "<%= request.getParameter("itemID")%>";
	</script>
	
  </head>
  
  	<div align = "center" id="container">
  		
  		<div id="createNewDepartmentDialog" title="编辑项目信息" align = "center">
  			<div align = "left">
	   	&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);"><img src="Resource/Image/returnBack.jpg"  alt="返回上一页" title = "返回上一页"
	   			style = "width:43px; height:35px; background-color: transparent; border-style: none; cursor: pointer;"/></a>
	</div>
			<form id = "editAddoutlayForm" method = "post">
				<table align="center" style="width: 80%;">
				<caption style = "height:40px;">
					<h3>
						修改入账信息
					</h3>
				</caption>
				<tr>
					<td align="right">来款单位:</td>
					<td>
						<input type="text" style="width: 40%" class="validate[required]" id = "txtDP"/>
					</td>
				</tr>
				<tr>
					<td align="right">入账人姓名:</td>
					<td>
						<input type="text" id = "txtName"/>
						和
						<input type="text" id = "txtName2"/>
					</td>
				</tr>
				<tr>
					<td align="right">来款金额:</td>
					<td> 
						<input type="text"  class="validate[required, custom[number], min[0]]" id = "txtValue" onkeyup = "valueOrOutChange()"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td align="right">项目代码:</td>
					<td>
						<input type="text" onchange="adjustDepartment()" class="validate[required, custom[integer], minSize[10], maxSize[12]]" id = "txtID"/>&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			<table align="center" style="width: 70%;">
				<tr>
					<td>理科:</td>
					<td>
						<select id="science" style = "height:20px; width:240px">
							<option value="notme">无</option>
						</select>
					</td>
					<td>文科:</td>
					<td>
						<select id="art" style = "height:20px; width:220px">
							<option value="notme">无</option>
						</select>
					</td>
				</tr>
				
			</table>
			<hr width="80%" />
			<table  align="center" style="width: 80%; text-align: center;">
				<tr>
					<td></td>
					<td>汇出金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtOut" onkeyup = "valueOrOutChange()"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>其它说明:</td>
					<td>
						该块已移至最下方。
					</td>
				</tr>
				<tr>
					<td></td>
					<td>劳务费1 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtNewPay"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>管理费1 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtManage"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td></td>
					<td>劳务费2 金额:</td>
					<td>
						<input type="text" id = "txtNewPay2"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>管理费2 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtManage2"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" id="chk_availableManageCredit"/>
					</td>
					<td>可用管理额度:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtAvailableManageCredit"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>专家咨询费:</td>
					<td>
						<input type="text" id = "txtConsult"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td></td>
					<td>业务活动费 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtAct"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>改善工作条件费 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtImprove"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
			</table>
			<hr width="80%" />
			<table   align="center" style="width: 80%; text-align: center;">
				<tr>
					<td></td>
					<td>
						直接费用：
					</td>
					<td>
						<input type="text" onkeyup = "calc()" class="validate[option, custom[number], min[0]]" id="directFee"/>
						&nbsp;元
					</td>
					<td>
						间接费用：
					</td>
					<td>
						<input type="text" onkeyup = "calc()" class="validate[option, custom[number], min[0]]" id="indirectFee"/>
						&nbsp;元
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						绩效支出：
					</td>
					<td>
						<input type="text" onkeyup = "calc()" class="validate[option, custom[number], min[0]]" id="performanceSpending"/>
						&nbsp;元
					</td>
					<td>
						设备购置费：
					</td>
					<td>
						<input type="text" onkeyup = "calc()" class="validate[option, custom[number], min[0]]" id="equipmentPurchaseFee"/>
						&nbsp;元
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>院系公共支出:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtDepartPublic"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>课题统筹支出:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtCoProject"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td></td>
					<td>绩效(80%):</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtPerformance1"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>绩效(20%):</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtPerformance2"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
			</table>
			<table  align="center" style="width: 80%;">
				<tr>
					<td colspan="2" width="19%">
						<input type="checkbox" id="chkIsBroadwise"/>
						是否是横向项目
					</td>
					<td colspan="8">
						<hr/>
					</td>
				</tr>
				<tr id="row1" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td colspan="2">
						院系酬金(5%):
					</td>
					<td >
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtDepartmentPay"/>
					</td>
					<td >
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" id="chkIsArt"/>
						文科劳务费3：
					</td>
					<td colspan="5">
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtArtPay"/>
					</td>
				</tr>
				<tr id="row2" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td colspan="3">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" id="chkIsTax"/>
						是否税金
					</td>
					<td >
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" id="chkIsScience"/>
						理科劳务费3：
					</td>
					<td colspan="5">
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtSciencePay"/>
					</td>
				</tr>
				<tr id="row3" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td >&nbsp;&nbsp;&nbsp;&nbsp;税金1：</td>
					<td colspan="2"><input type="text"  class="validate[option, custom[number], min[0]]" id = "txtTax1"/></td>
					<td >&nbsp;&nbsp;&nbsp;&nbsp;税金2：</td>
					<td colspan="2"><input type="text"  class="validate[option, custom[number], min[0]]" id = "txtTax2"/></td>
					<td >&nbsp;&nbsp;&nbsp;&nbsp;税金3：</td>
					<td colspan="2"><input type="text"  class="validate[option, custom[number], min[0]]" id = "txtTax3"/></td>
				</tr>
			</table>
				<br/>
				<div>
					
					<table>
						<tr>
							<td width="10%">修改备注：</td>							
							<td width="40%"><textarea id = "remark" rows="2" cols="40" style="font-size: 14px"></textarea></td>	
							<td width="10%">其它说明：</td>							
							<td width="40%"><textarea id = "txtOther" rows="2" cols="40" style="font-size: 14px"></textarea></td>	
						</tr>
					</table>
				</div>
				<br/>
				<div>
					<button type="button" id = "assureButton">添加</button>
					<button type="button" id = "deleteButton">删除</button>
					<button type="button" id = "print" onclick = "openInAccountPrintPage()">打印完整</button>
					<button type="button" id = "print2" onclick = "openInAccountPrintPage2()">打印比对</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" id = "showHistory">查看历史</button>
				</div>
				<div>
					<table id="history">
						
					</table>
				</div>
			</form>
			
		</div>
		</div>
  	
  </body>
</html>
