<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

		    	<tr>
					<td valign="top" colspan="2">
					
						<div id = "itemTypesClassificationDIV">
							<h3 style=" font:25px; display:block; height:25px;text-indent:25px">项目分类</h3>
							<div >
								<div>
									<input type = "checkbox" id = "allScienceItemTypeCheckbox"/>&nbsp;理科
								</div>
								<div id = "scienceItemTypeDIV" style = "padding-left:3em;">
									<table id = "scienceItemTypeTable" width = "100%">
										<tbody id = "scienceItemTypeTableBody">
										</tbody>
									</table>
								</div>
								
								<br>
								
								<div>
									<input type = "checkbox" id = "allArtsItemTypeCheckbox"/>&nbsp;文科
								</div>
								<div id = "artsItemTypeDIV" style = "padding-left:3em;">
									<table id = "artsItemTypeTable" width = "100%">
										<tbody id = "artsItemTypeTableBody">
										</tbody>
									</table>
								</div>
							</div>
						</div>
							
	            	</td>
				</tr>
				
				
				<tr>
					<td valign="top" colspan="2" >
					<div id = "DepartmentClassificationDIV">
						<h3 style=" font:25px; display:block; height:25px;text-indent:25px">院系信息</h3>
						<div>
							<div><input type = "checkbox" id = "allDepartmentsCheckbox"/>&nbsp;所有</div>
							<div id = "departmentDIV" style = "padding-left:3em;">
								<table id = "departmentTable" width = "100%">
									<tbody id = "departmentTableBody">
									</tbody>
								</table>
							</div>
						</div>
					</div>
					</td>
				</tr>
				