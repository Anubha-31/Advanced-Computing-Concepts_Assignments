package assignmentSolution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InsertDataIntoExcel {

	List<String> headers;
	Map<Long, List<Long>> data;
	String sheetName;
	List<String> rowHeader;

	public InsertDataIntoExcel(List<String> headers, Map<Long, List<Long>> data, String sheetName,
			List<String> rowHeader) {
		super();
		this.headers = headers;
		this.data = data;
		this.sheetName = sheetName;
		this.rowHeader = rowHeader;
	}

	public InsertDataIntoExcel(List<String> headers, Map<Long, List<Long>> data, String sheetName) {
		super();
		this.headers = headers;
		this.data = data;
		this.sheetName = sheetName;
	}

	public void insertData() {

		File file = new File("D:/Question3.xls");

		FileInputStream in;
		XSSFSheet sheet = null;
		XSSFWorkbook excel = null;
		try {

			//can check the number of sheets in a data to check the size// implement later
			if (file.exists()) {
				in = new FileInputStream(file);
				excel = new XSSFWorkbook(in);
				sheet = excel.getSheet(sheetName);
				if (sheet == null) {
					sheet = excel.createSheet(sheetName);
				}
			} else {
				excel = new XSSFWorkbook();
				sheet = excel.createSheet(sheetName);
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int rowId = 0;
		int cellId = 0;
		
		/*
		 * if(rowHeader != null && !rowHeader.isEmpty()) cellId = 1;
		 */

		Row row;
		Cell cell;
		row = sheet.createRow(rowId++);
		for (String header : headers) {

			cell = row.createCell(cellId++);
			cell.setCellValue(header);
		}

		//make this generic
		for (int i = 0; i <= data.size(); i++) {

			List<Long> cellData = (List<Long>) data.get((long) i);
			if (cellData != null) {
				row = sheet.createRow(rowId);
				rowId++;
				cellId = 0;
				if(rowHeader != null && !rowHeader.isEmpty()) {
					/*
					 * cell = row.createCell(cellId++); cell.setCellValue(rowHeader.get(i));
					 */
					cellId = 1;
				}
				for (int j = 0; j < cellData.size(); j++) {
					cell = row.createCell(cellId);
					cell.setCellValue(cellData.get(j));
					cellId++;
				}
			}

		}

		if(rowHeader != null && !rowHeader.isEmpty()) {
			for(int i = 1 ; i <= sheet.getLastRowNum() ; i++) {
				row = sheet.getRow(i);
				cell = row.createCell(0);
				cell.setCellValue(rowHeader.get(i-1));
			}
		}
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			excel.write(out);
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
