import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CombineExcelsInTheSameDir {
	public HashMap<Coordinator,Integer> maps;
	public static void init_maps(String file){
		//init maps
	}
	public static String[] getAllExcelFiles(String dirPath) {
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		Excel test = new Excel("test.xlsx");
		System.out.println(test.getContentFromCell(0, 0, 0));
	}

}

