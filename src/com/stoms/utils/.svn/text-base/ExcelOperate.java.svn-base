package com.stoms.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import com.stoms.model.AddOutlay;

public class ExcelOperate {

	private ArrayList<AddOutlay> addoutlays;

	public ExcelOperate() {
		super();
		this.addoutlays = new ArrayList<AddOutlay>();
	}

	public static void main(String[] args) throws Exception {
		new ExcelOperate().getData("d:/STOMS_FileData_temp/", "Twice.xls");
	}
	
	public String writeToExcel(List<List<String>> list,String tableName) {
		String filePath = "";
		try {
			// 创建excel文件对象
			HSSFWorkbook wb = new HSSFWorkbook();// 建立新HSSFWorkbook对象
			// 创建一个张表
			HSSFSheet sheet = wb.createSheet("Sheet 1");
			// 创建行对象
			HSSFRow row = null;
			// 创建表格对象
			HSSFCell cell = null;
			sheet.setColumnWidth((short)0, (short)(15 * 256));
			sheet.setColumnWidth((short)1, (short)(30 * 256));
			sheet.setColumnWidth((short)2, (short)(10 * 256));
			sheet.setColumnWidth((short)3, (short)(10 * 256));
			if("Addoutlays".equals(tableName)){
				sheet.setColumnWidth((short)4, (short)(10 * 256));
				sheet.setColumnWidth((short)5, (short)(10 * 256));
				sheet.setColumnWidth((short)6, (short)(30 * 256));
				sheet.setColumnWidth((short)7, (short)(15 * 256));
			}else if("Items".equals(tableName)){
				sheet.setColumnWidth((short)4, (short)(25 * 256));
				sheet.setColumnWidth((short)5, (short)(15 * 256));
			}
			
			// 循环行
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow((short) i);
				// 循环列
				for (int j = 0; j < list.get(i).size(); j++) {
					cell = row.createCell((short) j);// 创建单元格
					String m = list.get(i).get(j);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue(m);// 赋值
				}
			}
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String currentDate = formatter.format(date);
			int i = (int)(Math.random()*100);
			filePath = tableName+"_"+currentDate+".xls";
			FileOutputStream out = new FileOutputStream("D:/STOMS_FileData_temp/"+filePath);
			wb.getSheetAt(0).getRow(0).getCell((short)0);
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	public ArrayList<AddOutlay> getData(String uploadPath, String filePath)
			throws Exception {
		File file = new File(uploadPath + "/" + filePath);
		// d:\\STOMS_FileData_temp\\Twice.xls
		// d:\\STOMS_FileData_temp\\Twice.xls
		System.out.println("getData started");
		String[][] result = getData2(file, 1);
		System.out.println("getData over");
		int rowLength = result.length;
		System.out.println(rowLength);

		for (int i = 0; i < rowLength; i++) {
			AddOutlay addoutlay = new AddOutlay();
			for (int j = 0; j < result[i].length; j++) {
				switch (j) {
				case 0:
					addoutlay.setContractId(result[i][j]);
					break;
				case 1:
					addoutlay.setItemName(result[i][j]);
					break;
				case 2:
					addoutlay.setTeacherName(result[i][j]);
					break;
				case 3:
					addoutlay.setDepartmentName(result[i][j]);
					break;
				case 4:
					addoutlay.setOutlayTime(result[i][j]);
					break;
				case 5:
					addoutlay.setOutlayValue(Double.parseDouble(result[i][j]));
					break;
				case 6:
					addoutlay.setItemId(result[i][j]);
					break;
				default:
					break;
				}
				// System.out.print(result[i][j] + "\t\t");
			}
			addoutlays.add(addoutlay);
		}

		System.out.println("over:" + addoutlays.size());
		return addoutlays;
	}

	/**
	 * 
	 * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
	 * 
	 * @param file
	 *            读取数据的源Excel
	 * 
	 * @param ignoreRows
	 *            读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
	 * 
	 * @return 读出的Excel中数据的内容
	 * 
	 * @throws FileNotFoundException
	 * 
	 * @throws IOException
	 */

	public static String[][] getData2(File file, int ignoreRows)

	throws FileNotFoundException, IOException {

		List<String[]> result = new ArrayList<String[]>();

		int rowSize = 0;

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(

		file));

		// 打开HSSFWorkbook

		POIFSFileSystem fs = new POIFSFileSystem(in);

		HSSFWorkbook wb = new HSSFWorkbook(fs);

		HSSFCell cell = null;

		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {

			HSSFSheet st = wb.getSheetAt(sheetIndex);

			// 第一行为标题，不取

			for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
				System.out.println("l:" + rowIndex);
				HSSFRow row = st.getRow(rowIndex);

				if (row == null) {

					continue;

				}

				int tempRowSize = row.getLastCellNum() + 1;

				if (tempRowSize > rowSize) {

					rowSize = tempRowSize;

				}

				String[] values = new String[rowSize];

				Arrays.fill(values, "");

				boolean hasValue = false;

				for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {

					String value = "";
					cell = row.getCell(columnIndex);

					if (cell != null) {

						// 注意：一定要设成这个，否则可能会出现乱码
						cell.setEncoding(HSSFCell.ENCODING_UTF_16);

						switch (cell.getCellType()) {

						case HSSFCell.CELL_TYPE_STRING:

							value = cell.getStringCellValue();

							break;

						case HSSFCell.CELL_TYPE_NUMERIC:

							if (HSSFDateUtil.isCellDateFormatted(cell)) {

								Date date = cell.getDateCellValue();

								if (date != null) {

									value = new SimpleDateFormat("yyyy-MM-dd")

									.format(date);

								} else {

									value = "";

								}

							} else {

								value = new DecimalFormat("0").format(cell

								.getNumericCellValue());

							}

							break;

						case HSSFCell.CELL_TYPE_FORMULA:

							// 导入时如果为公式生成的数据则无值

							if (!cell.getStringCellValue().equals("")) {

								value = cell.getStringCellValue();

							} else {

								value = cell.getNumericCellValue() + "";

							}

							break;

						case HSSFCell.CELL_TYPE_BLANK:

							break;

						case HSSFCell.CELL_TYPE_ERROR:

							value = "";

							break;

						case HSSFCell.CELL_TYPE_BOOLEAN:

							value = (cell.getBooleanCellValue() == true ? "Y"

							: "N");

							break;

						default:

							value = "";

						}

					}

					if (columnIndex == 0 && value.trim().equals("")) {

						break;

					}

					values[columnIndex] = rightTrim(value);

					hasValue = true;

				}

				if (hasValue) {

					result.add(values);

				}

			}

		}

		in.close();

		String[][] returnArray = new String[result.size()][rowSize];

		for (int i = 0; i < returnArray.length; i++) {

			returnArray[i] = (String[]) result.get(i);

		}

		return returnArray;

	}

	/**
	 * 
	 * 去掉字符串右边的空格
	 * 
	 * @param str
	 *            要处理的字符串
	 * 
	 * @return 处理后的字符串
	 */

	public static String rightTrim(String str) {

		if (str == null) {

			return "";

		}

		int length = str.length();

		for (int i = length - 1; i >= 0; i--) {

			if (str.charAt(i) != 0x20) {

				break;

			}

			length--;

		}

		return str.substring(0, length);

	}

	public ArrayList<AddOutlay> getAddoutlays() {
		return addoutlays;
	}

	public void setAddoutlays(ArrayList<AddOutlay> addoutlays) {
		this.addoutlays = addoutlays;
	}

}
