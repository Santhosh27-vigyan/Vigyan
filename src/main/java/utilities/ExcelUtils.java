package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	private static FileInputStream fis;
	private static XSSFWorkbook book;
	private static XSSFSheet sheet;
	public static String[][] GetExcelData(String SheetName, String Path, String RowNumber) throws IOException {
		fis = new FileInputStream(Path);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(SheetName);
		int row;
		int col = 1;
		int Ci, Cj;
		int TotalRows = sheet.getLastRowNum();
		int TotalColumns = sheet.getRow(0).getLastCellNum();
		TotalColumns = TotalColumns - 1;
		String[][] Table;
		Ci = 0;
		if (RowNumber.equalsIgnoreCase("All")) {
			row = 1;
			Table = new String[TotalRows][TotalColumns];
			for (int i = row; i <= TotalRows; i++, Ci++) {
				Cj = 0;
				for (int j = col; j <= TotalColumns; j++, Cj++) {
					Table[Ci][Cj] = GetCellData(i, j);
				}
			}
		} else {
			row = Integer.valueOf(RowNumber);
			Table = new String[1][TotalColumns];
			Cj = 0;
			for (int j = col; j <= TotalColumns; j++, Cj++) {
				Table[Ci][Cj] = GetCellData(row, j);
			}
		}
		return Table;
	}
	public static String GetCellData(int RowValue, int ColumnValue) {
		String Data;
		XSSFCell cell = sheet.getRow(RowValue).getCell(ColumnValue);
		if (cell.getCellType() == CellType.STRING) {
			Data = cell.getStringCellValue();
		} else {
			Data = String.valueOf(cell.getNumericCellValue());
		}
		return Data;
	}
public static String GetRowNum(String SheetName,String Path,String ResourceName) throws IOException {
fis=new FileInputStream(Path);
book=new XSSFWorkbook(fis);
sheet=book.getSheet(SheetName);
int col=1;
String rowNum = "";
int TotalRows=sheet.getLastRowNum();
//System.out.println(TotalRows);
	for (int i = 0; i < TotalRows+1; i++) {
		XSSFCell cell=sheet.getRow(i).getCell(col);
		//System.out.println(cell.getStringCellValue() + "  "+ResourceName);
		if(cell.getStringCellValue().equalsIgnoreCase(ResourceName))
		{
		rowNum=String.valueOf(i);
		//System.out.println(rowNum);
		break;
		}
	}
	return rowNum;
}
}
