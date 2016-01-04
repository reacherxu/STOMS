function myprint(tableid) {
	var winname = window.open('', 'newwin', '');

	var strHTML = document.getElementById(tableid).innerHTML;

	winname.document.open('text/html', 'replace');

	winname.document.writeln(strHTML);
	winname.document.execCommand('print'); //打印
	winname.close();

}

var idTmr;

function myexcel(tableid) {//整个表格拷贝到EXCEL中   

	var curTbl = document.getElementById(tableid);
	var oXL = new ActiveXObject("Excel.Application");
	//创建AX对象excel   
	var oWB = oXL.Workbooks.Add();
	//获取workbook对象   
	var xlsheet = oWB.Worksheets(1);
	//激活当前sheet   
	var sel = document.body.createTextRange();
	sel.moveToElementText(curTbl);
	//把表格中的内容移到TextRange中   
	sel.select();
	//全选TextRange中内容   
	sel.execCommand("Copy");
	//复制TextRange中内容    
	xlsheet.Paste();
	//粘贴到活动的EXCEL中         
	oXL.Visible = true;
	//设置excel可见属性   

	try {
		var fname = oXL.Application.GetSaveAsFilename("save.xls",
				"Excel Spreadsheets (*.xls), *.xls");
		if (fname) {
			oWB.SaveAs(fname);
		}

	} catch (e) {
		print("Nested catch caught " + e);
	} finally {

		oWB.Close(savechanges = false);
		oXL.Quit();
		oXL = null;
		//结束excel进程，退出完成  
		idTmr = window.setInterval("Cleanup();", 1);

	}
}
function Cleanup() {
	window.clearInterval(idTmr);

	CollectGarbage();
}