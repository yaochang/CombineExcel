import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CombineExcelsInTheSameDir {
	public static HashMap<Coordinator,Integer> maps;
	public static void init_maps(String file){
		//init maps
		maps = new HashMap<Coordinator, Integer>();
		maps.put(new Coordinator(2,1),0);  	//姓名
		maps.put(new Coordinator(3,1),1);	//一级部门
		maps.put(new Coordinator(4,1),2);	//入职时间
		maps.put(new Coordinator(5,1),3);	//目前级职
		maps.put(new Coordinator(6,1),4);	//有无晋升记录
		
		maps.put(new Coordinator(2,5),5);	//员工编号
		maps.put(new Coordinator(3,5),6);	//职位
		maps.put(new Coordinator(4,5),7);	//直属TL
		maps.put(new Coordinator(5,5),8);	//申请晋升职级
		maps.put(new Coordinator(6,5),9);	//最近晋升时间
	}
	public static String[] getAllExcelFiles(String dirPath) {
		File file = new File(dirPath);
		String[] ret;
		if(file.exists()){
			File[] files = file.listFiles();
			if(files.length == 0){
				System.out.println("This is an empty folder");
				return null;
			}else{
				ret = new String[files.length];
				int index = 0;
				for(File tmpFile : files){
					ret[index] = tmpFile.getAbsolutePath();
					index++;
				}
			}
			return ret;
		}
		System.out.println("This folder does not exist");
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		init_maps(null);
		XLSExcel test = new XLSExcel("员工晋升申请表_贺腾.xls");
		XLSExcel save = new XLSExcel();
		save.createNewExcel("save.xls");
		Coordinator coordinator;
		int colindex;
//		test.outputall();
		int rowindex = 0;
		for(Map.Entry<Coordinator, Integer> entry : maps.entrySet()){
			coordinator = entry.getKey();
			colindex = entry.getValue();
			String content = test.getContentFromCell(coordinator.col, coordinator.row, 0);
			System.out.println("Row="+coordinator.row + " Col="+coordinator.col +" "+ test.getContentFromCell(coordinator.col, coordinator.row, 0));
			save.setContent(colindex, rowindex, 0, content);
		}
		save.saveFile();
	}

}

