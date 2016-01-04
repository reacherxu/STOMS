<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>入账打印</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
    <script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JS/teacher/inAccountApplication/inAccountPrint.js"></script>
	
	<script type="text/javascript">
	 	var addOutlayPK = "<%= request.getParameter("addOutlayPK")%>";
	   var flag = "<%= request.getParameter("flag")%>";
	</script>

	<script language=javascript>
		//打印指定区域内容 
		function preview() {
			bdhtml = window.document.body.innerHTML;
			sprnstr = "<!--startprint-->";
			eprnstr = "<!--endprint-->";
			prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17);
			prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));
			window.document.body.innerHTML = prnhtml;
			window.print();
		}
	</script>
	
	<style type="text/css">
		
		body {
			font-size:20px;
		}
		
		td {
			height:27px;
		}

	</style>
	
  </head>
  
  <body >
   	
   	<div align="center">
				<input name="print" type="button" onClick="preview()" value=" 打 印 ">
	</div>
   	
   	<!--startprint-->
   
   	<div style = "width:800px;height:30px;font-size: 18px; font-family:'宋体',Simsun;">
   		<div style = "padding-left:260px;">
   			<label id = "addOutlayYear"></label>&nbsp;&nbsp;&nbsp;
   			<label id = "addOutlayMonth"></label>&nbsp;&nbsp;&nbsp;
   			<label id = "addOutlayDay"></label>
   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   		</div>
	</div>
	<div style = "font-size: 14px; font-family:'宋体',Simsun; position: absolute; left: 696px; top: 255px;">
		<label id = "itemName2"></label>
	</div>	
	<div style = "font-size: 16px; font-family:'宋体',Simsun; position: absolute; left: 696px; top: 339px;">
		(活动40%)
	</div>	
	<div id = "jbr" style = "font-size: 16px; font-family:'宋体',Simsun; position: absolute; left: 340px; top: 460px;">
		<%=session.getAttribute("adminName") %>
	</div>
	<div style = "width:660px; font-size: 16px; font-family:'宋体',Simsun; position: absolute; left: 38px; top: 388px;">
		<label id = "comment"  style = "height:30px;"></label>
	</div>			
	<div style = "width:800px; font-family:'宋体',Simsun;">
	
		<table align="left" style="width: 88%;">
		
			<tr>
				<td>
					<table width = "100%">
						<tr>
							<td width="50%">
								<table width="100%" style="width: 339px;">
									<tr>
										<td colspan="2" align="right">
											<label id = "inAccountDepartment"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td></td>
										<td align="right">
											<label id = "outlayValue"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td></td>
										<td align="right">
											<label id = "isNewCreatedCard"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "manageProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "manage"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;
											<label id = "actProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "act"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;
											<label id = "improveProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "improve"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;
											<label id = "availableManageCreditProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "availableManageCredit"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td colspan="2" align="right">
											<label id = "itemType" style = "font-size: 14px"></label>
											&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;
											<label id = "pay3ProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "pay3"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "departmentPayProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "departmentPay"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;
											<label id = "departmentPublicProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "departmentPublic"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td colspan="2">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "performance2Left"></label>
										</td>
									</tr>
								</table>
							</td>
							
							<td width="50%">
								<table width="100%" style="width: 339px;">
									<tr>
										<td></td>
										<td align="right">
											<label id = "teacherName"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td></td>
										<td align="right">
											<label id = "contractID"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td colspan="2">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "itemYearRange"></label>
											&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "manage2ProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "manage2"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "payProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "pay"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "pay2ProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "pay2"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "consultProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "consult"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td colspan="2"  align="right">
											<label id = "itemName"  style = "font-size: 14px"></label>
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id = "artsPay3ProportionLabel"></label>
										</td>
										<td align="right">
											<label id = "artsPay3"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td colspan="2" align="right">
											<label id = "taxInfo"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td colspan="2" align="right">
											<label id = "coProjectProportionLabel"></label>
											&nbsp;
											<label id = "coProject"></label>
											&nbsp;
											<label id = "sumone"></label>
											&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr>
										<td colspan="2" align="right">
											<label id = "performance2Right"></label>
											&nbsp;
											<label id = "sumtwo"></label>
											&nbsp;
											<label id = "sumthree"></label>
											&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
	</div>
	
	<!--endprint-->
  </body>
</html>
