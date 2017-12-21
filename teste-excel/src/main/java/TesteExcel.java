import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TesteExcel {

	public static void main(String[] args) throws IOException {

		String excelPath = "D:\\Users\\t803530\\Desktop\\teste.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelPath));

		XSSFWorkbook wb = new XSSFWorkbook(excelPath);

		XSSFWorkbook test = new XSSFWorkbook();

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator<Row> rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();

				if (cell.getCellTypeEnum() == CellType.STRING) {
					System.out.print(cell.getStringCellValue() + " ");
				} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
					System.out.print(cell.getNumericCellValue() + " ");
				} else {
					// U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}

	}

}
