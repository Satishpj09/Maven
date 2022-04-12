package com.framework.org.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Kamalesh\\eclipse-workspace\\MavenProject\\Excel\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		for (int i = 0; i < sheetAt.getPhysicalNumberOfRows(); i++) {
			Row row = sheetAt.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if (cellType.equals(cellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				} else if (cellType.equals(cellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					String valueOf = String.valueOf(numericCellValue);
					System.out.println(valueOf);

				}
			}

		}
	}

}
