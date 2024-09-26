package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Cell cell;
	public static File file;
	public static FileInputStream input;
	public static FileOutputStream outputStream;

	public static void setExcelFile(String path, String sheetname) throws Exception {

		file = new File(path);
		input = new FileInputStream(file);
		workbook = new XSSFWorkbook(input);
		sheet = workbook.getSheet(sheetname);
	}

	public static String getCellData(int rownum, int colnum) {
		cell = sheet.getRow(rownum).getCell(colnum);
		String CellData = cell.getStringCellValue();
		return CellData;
	}

	public static int getNumericvalue(int rownum, int colnum) {
		cell = sheet.getRow(rownum).getCell(colnum);
		double CellData = (int) cell.getNumericCellValue();
		return (int) CellData;
	}

	public static String Write_data_pass(int rownum, int colnum) throws Exception {

		cell = sheet.getRow(rownum).createCell(colnum);
		cell.setCellValue("PASS");
		FileOutputStream fout = new FileOutputStream(file);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cell.setCellStyle(style);
		workbook.write(fout);
		return null;
	}

	public static String Write_data_fail(int rownum, int colnum) throws Exception {
		cell = sheet.getRow(rownum).createCell(colnum);
		cell.setCellValue("FAIL");
		FileOutputStream fout = new FileOutputStream(file);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.RED.getIndex());
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cell.setCellStyle(style);
		workbook.write(fout);
		return null;
	}
	
	public static String Write_Value(String value) throws Exception 
	{
	    sheet = workbook.getSheet("Sheet1");
	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    Row row = sheet.getRow(0);
	    Row newRow = sheet.createRow(rowCount+1);
	    for(int j = 0; j < row.getLastCellNum(); j++){

	        cell = newRow.createCell(j);
	        cell.setCellValue(value);
	      
	    }
	    input.close();

	    FileOutputStream outputStream = new FileOutputStream(file);
	    workbook.write(outputStream);
	    outputStream.close();
	    return null;
	}
	
	
	public void writedata(List<String> list,int rownum) throws Exception
	{
       // int cellnum=0;
        for (String value : list) {
            Row row = sheet.createRow(rownum);
            Cell cell = row.createCell(list.indexOf(value));
            System.out.println(list.indexOf(value));
//            int s1=row.getRowNum();
//            int s2=cell.getColumnIndex();
            //System.out.println("rows and clolmns"+s1+""+s2);
            System.out.println("value is:"+value);
            cell.setCellValue(value);
            FileOutputStream fileOut = new FileOutputStream(file);
            workbook.write(fileOut);
        }
	}
	
	public void wite(int rowval) throws Exception 
	{
		Map<Integer, Object[]> data 
        = new TreeMap<Integer, Object[]>(); 
        String image_name="3445454";
//    data.put(rowval, 
//             new Object[] { "Image Name", "Image Id", "Instance Id","Image Path","Segmented ImagePath","Predicted classes" }); 
    data.put(rowval, 
             new Object[] {image_name , "Pankaj", "Kumar" }); 

    Set<Integer> keyset = data.keySet(); 

    int rownum = 0; 

    for (int key : keyset) { 

        // Creating a new row in the sheet 
        Row row = sheet.createRow(rownum++); 

        Object[] objArr = data.get(key); 

        int cellnum = 0; 

        for (Object obj : objArr) { 

            // This line creates a cell in the next 
            //  column of that row 
            Cell cell = row.createCell(cellnum++); 

            if (obj instanceof String) 
                cell.setCellValue((String)obj); 

            else if (obj instanceof Integer) 
                cell.setCellValue((Integer)obj); 
        } 
    } 

    // Try block to check for exceptions 
    try { 

        // Writing the workbook 
        FileOutputStream out = new FileOutputStream(file); 
        workbook.write(out); 

        // Closing file output connections 
        out.close(); 

        // Console message for successful execution of 
        // program 
        System.out.println( 
            "gfgcontribute.xlsx written successfully on disk."); 
    } 

    // Catch block to handle exceptions 
    catch (Exception e) { 

        // Display exceptions along with line number 
        // using printStackTrace() method 
        e.printStackTrace(); 
    } 
} 

	
	
	public static int findRow(String cellContent) {
	    for (Row row : sheet) {
	        for (Cell cell : row) {
	        	if(cell.getCellType() == Cell.CELL_TYPE_STRING)
	        	{
	 
	        		 if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) 
	        		 {
		                  return row.getRowNum();  
		             }
	        	}               
	        }
	    }
		return 0;               
	}
}	
