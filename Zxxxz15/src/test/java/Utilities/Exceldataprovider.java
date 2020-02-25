package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider {

	
	
	
	
	XSSFWorkbook wb;
public Exceldataprovider(){
File src=new File("./Testdata/manual.xlsx");
try {
	FileInputStream fis=new FileInputStream(src);
	 wb=new XSSFWorkbook(fis);
} catch (Exception e) {
System.out.println("unsucessfully failed"+e.getMessage());
}
}
public String getStringdata(int indexname,int row,int coloum){
	return wb.getSheetAt(indexname).getRow(row).getCell(coloum).getStringCellValue();
}
public String getString(String sheetname,int row,int coloum){
	return wb.getSheet(sheetname).getRow(row).getCell(coloum).getStringCellValue();
}
public String getNumericaldata(String sheetname,int row,int coloum){
	return wb.getSheet(sheetname).getRow(row).getCell(coloum).getStringCellValue();
}
}
