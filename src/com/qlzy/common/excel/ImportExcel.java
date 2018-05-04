/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qlzy.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;



/**
 * 导入Excel文件（支持“XLS”和“XLSX”格式）
 * @author yanghaili
 */
public class ImportExcel {
	
	private static Logger log = Logger.getLogger(ImportExcel.class);
			
	/**
	 * 工作薄对象
	 */
	private Workbook wb;
	
	/**
	 * 工作表对象
	 */
	private Sheet sheet;
	/**
	 * 工作表数组
	 */
	private List<Sheet> sheets = new ArrayList<Sheet>();
	
	/**
	 * 标题行号
	 */
	private int headerNum;
	
	/**
	 * 构造函数
	 * @param path 导入文件，读取第一个工作表
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @throws InvalidFormatException 
	 * @throws IOException 
	 */
	public ImportExcel(String fileName, int headerNum) 
			throws InvalidFormatException, IOException {
		this(new File(fileName), headerNum);
	}
	
	/**
	 * 构造函数
	 * @param path 导入文件对象，读取第一个工作表
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @throws InvalidFormatException 
	 * @throws IOException 
	 */
	public ImportExcel(File file, int headerNum) 
			throws InvalidFormatException, IOException {
		this(file, headerNum, 0);
	}

	/**
	 * 构造函数
	 * @param path 导入文件
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @param sheetIndex 工作表编号
	 * @throws InvalidFormatException 
	 * @throws IOException 
	 */
	public ImportExcel(String fileName, int headerNum, int sheetIndex) 
			throws InvalidFormatException, IOException {
		this(new File(fileName), headerNum, sheetIndex);
	}
	
	/**
	 * 构造函数
	 * @param path 导入文件对象
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @param sheetIndex 工作表编号
	 * @throws InvalidFormatException 
	 * @throws IOException 
	 */
	public ImportExcel(File file, int headerNum, int sheetIndex) 
			throws InvalidFormatException, IOException {
		this(file.getName(), new FileInputStream(file), headerNum, sheetIndex);
	}
	
	/**
	 * 构造函数
	 * @param file 导入文件对象
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @param sheetIndex 工作表编号
	 * @throws InvalidFormatException 
	 * @throws IOException 
	 */
	public ImportExcel(MultipartFile multipartFile, int headerNum, int sheetIndex) 
			throws InvalidFormatException, IOException {
		this(multipartFile.getOriginalFilename(), multipartFile.getInputStream(), headerNum, sheetIndex);
	}

	/**
	 * 构造函数
	 * @param path 导入文件对象
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @param sheetIndex 工作表编号
	 * @throws InvalidFormatException 
	 * @throws IOException 
	 */
	public ImportExcel(String fileName, InputStream is, int headerNum, int sheetIndex) 
			throws InvalidFormatException, IOException {
		if (StringUtils.isBlank(fileName)){
			throw new RuntimeException("导入文档为空!");
		}else if(fileName.toLowerCase().endsWith("xls")){    
			this.wb = new HSSFWorkbook(is);    
        }else if(fileName.toLowerCase().endsWith("xlsx")){  
        	this.wb = new XSSFWorkbook(is);
        }else{  
        	throw new RuntimeException("文档格式不正确!");
        }  
		if (this.wb.getNumberOfSheets()<sheetIndex){
			throw new RuntimeException("文档中没有工作表!");
		}
		this.sheet = this.wb.getSheetAt(sheetIndex);
		this.headerNum = headerNum;
		log.debug("Initialize success.");
	}
	public List<Sheet> getSheets() {
		return sheets;
	}

	public void setSheets(List<Sheet> sheets) {
		this.sheets = sheets;
	}

	/**
	 * 
	 * @param fileName 文件名称
	 * @param is 输入流
	 * @param headerNum 标题行号，数据行号=标题行号+1
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ImportExcel(String fileName, InputStream is, int headerNum) 
			throws InvalidFormatException, IOException {
		PropertyConfigurator.configure("log4j.properties");
		if (StringUtils.isBlank(fileName)){
			throw new RuntimeException("导入文档为空!");
		}else if(fileName.toLowerCase().endsWith("xls")){    
			this.wb = new HSSFWorkbook(is);    
        }else if(fileName.toLowerCase().endsWith("xlsx")){  
        	this.wb = new XSSFWorkbook(is);
        }else{  
        	throw new RuntimeException("文档格式不正确!");
        }  
		for (int i = 0; i < this.wb.getNumberOfSheets(); i++) {//获取每个Sheet表
           Sheet  sheetI =this.wb.getSheetAt(i);
           this.sheets.add(sheetI);
		}
		System.out.println(sheets.size()+"----------------sheets.size");
		this.headerNum = headerNum;
		log.debug("Initialize success.");
	}
	/**
	 * 获取行对象
	 * @param rownum
	 * @return
	 */
	public Row getRow(int rownum){
		return this.sheet.getRow(rownum);
	}

	/**
	 * 获取数据行号
	 * @return
	 */
	public int getDataRowNum(){
		return headerNum-1;
	}
	
	/**
	 * 获取最后一个数据行号
	 * @return
	 */
	public int getLastDataRowNum(){
		return this.sheet.getLastRowNum()+1;
	}
	
	/**
	 * 获取最后一个列号
	 * @return
	 */
	public int getLastCellNum(){
		return this.getRow(headerNum).getLastCellNum();
	}
	
	/**
	 * 获取单元格值
	 * @param row 获取的行
	 * @param column 获取单元格列号
	 * @return 单元格值
	 */
	public Object getCellValue(Row row, int column){
		Object val = "";
		try{
			Cell cell = row.getCell(column);
			if (cell != null){
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					val = cell.getNumericCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_STRING){
					val = cell.getStringCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA){
					val = cell.getCellFormula();
				}else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
					val = cell.getBooleanCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_ERROR){
					val = cell.getErrorCellValue();
				}
			}
		}catch (Exception e) {
			return val;
		}
		return val;
	}
	

	
	
	/**
	 * 获取制定sheet表内容
	 * 
	 * @param i
	 * @return
	 */
	public Map<Integer, Map> getSheetMap() {
		return getSheetMap1();
	}
	
	/**
	 * 获取sheet表内容
	 * 
	 * @return
	 */
	public Map<Integer, Map> getSheetMap1() {
		Map<Integer, Map> result = new HashMap<Integer, Map>();

		if (sheet != null) {
			// 获取所有行数据
			for (int r = sheet.getFirstRowNum(); r <= sheet.getLastRowNum(); r++) {
				// 获取行
				Row row = sheet.getRow(r);
				if (row == null)
					continue;
				if (row.getLastCellNum() > 0) {
					// 获取所有列数据
					Map<Integer, String> rowMap = getRowMap(row);
					result.put(r, rowMap);
				}
			}
		}
		return result;
	}
	
	/**
	 * 获取行中的所有列数据
	 * 
	 * @param row
	 * @return
	 */
	public Map<Integer, String> getRowMap(Row row) {
		Map<Integer, String> rowMap = new HashMap<Integer, String>();
		// 获取所有列数据
		for (int c = row.getFirstCellNum(); c <= row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell == null)
				continue;
			// 获取单元格内容
			rowMap.put(c, getValueFromCell(cell));
		}
		return rowMap;
	}
	
	/**
	 * 获取单元格内容
	 * 
	 * @param cell
	 * @return
	 */
	public String getValueFromCell(Cell cell) {

		if (cell == null) {
			return null;
		}
		String value;
		
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			if (DateUtil.isCellDateFormatted(cell)) {
				value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cell
						.getDateCellValue());
			} else {
				BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
				bd = bd.setScale(4, BigDecimal.ROUND_HALF_EVEN);
				String temp = bd.toString();
				if (temp.indexOf(".") > 0) {
					temp = temp.replaceAll("0+?$", "");// 去掉多余的0
					temp = temp.replaceAll("[.]$", "");// 如最后一位是.则去掉
				}
				value = temp.trim();
			}
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			value = cell.getStringCellValue().trim();
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			// 用数字方式获取公式结果，根据值判断是否为日期类型
			try {
				double numericValue = cell.getNumericCellValue();
				BigDecimal bigDecimal = new BigDecimal(numericValue);
				bigDecimal = bigDecimal.setScale(4, BigDecimal.ROUND_HALF_EVEN);
				String temp = bigDecimal.toString();
				if (temp.indexOf(".") > 0) {
					temp = temp.replaceAll("0+?$", "");// 去掉多余的0
					temp = temp.replaceAll("[.]$", "");// 如最后一位是.则去掉
				}
				value = temp.trim();
			} catch (IllegalStateException e) {
				try {
					value = cell.getStringCellValue();
				} catch (IllegalStateException e1) {
					value = String.valueOf(cell.getCellFormula());
				}
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BLANK: // 空白
			value = "";
			break;
		case Cell.CELL_TYPE_ERROR: // Error，返回错误码
			value = String.valueOf(cell.getErrorCellValue());
			break;
		default:
			value = StringUtils.EMPTY;
			break;
		}
		
//		System.out.println("行：" + cell.getRowIndex() + "列："
//				+ cell.getColumnIndex() + "-" + value);
		return value;
	}

//	/**
//	 * 导入测试
//	 */
	public static void main(String[] args) throws Throwable {
		String FileName = "D:\\mobile.xlsx";
//		ImportExcel ei = new ImportExcel(FileName,new FileInputStream(FileName),1);
//		ei.importAllSheet(FileName,0);
		ImportExcel ei = new ImportExcel(FileName,1);
		// 获取所有列数据
		
		System.out.println(ei.getLastDataRowNum());
		for (int i = ei.getDataRowNum(); i < ei.getLastDataRowNum(); i++) {
			Row row = ei.getRow(i);
			String str = "";
			System.out.println(row.getFirstCellNum());
			System.out.println(row.getLastCellNum());
//			for (int c = row.getFirstCellNum(); c <= row.getLastCellNum(); c++) {
//				System.out.println(c+"--------------");
				Cell cell = row.getCell(1);
				if (cell == null)
					continue;
				// 获取单元格内容
				str = str + "-----"+ei.getValueFromCell(cell);
				System.out.println(str);
//			}
			//Object val = ei.getCellValue(row, 1);
//			for (int j = 0; j < ei.getLastCellNum(); j++) {
//				Object val1 = ei.getCellValue(row, j);
//				System.out.print(val1.toString()+", ");
//			}
//			if(null != val && !"".equals(val.toString())){
//				System.out.print(val.toString()+"\n");
//			}
			
		}
		
	}
	
	public void importAllSheet(String FileName,int headerNum,int columnNum) throws InvalidFormatException, FileNotFoundException, IOException{
		
		if(null != sheets &&  sheets.size() > 0){
			for(Sheet sheetI : sheets){
				System.out.println("---------------------"+ sheetI.getLastRowNum()+headerNum);
				
				for (int i = headerNum-1; i <= sheetI.getLastRowNum()+1; i++) {
					Row row = sheetI.getRow(i);
					
//					for(int j = 0; j<getRow(headerNum).getLastCellNum();j++){
//						
//					}
					Object val =getCellValue(row, columnNum);
					System.out.print(val.toString()+"\n");
				}
			}
		}
	}
	
	/***
	 * 去除无用的行
	 * @param sheet
	 */
	public void delInutilitiesRow(Sheet sheet){
        CellReference cellReference = new CellReference("A4");  
        boolean flag = false;  
        System.out.println("总行数："+(sheet.getLastRowNum()+1));  
        for (int i = cellReference.getRow(); i <= sheet.getLastRowNum();) {  
            Row r = sheet.getRow(i);  
            if(r == null){  
                // 如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动  
                sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);  
                continue;  
            }  
            flag = false;  
            for(Cell c:r){  
                if(c.getCellType() != Cell.CELL_TYPE_BLANK){  
                    flag = true;  
                    break;  
                }  
            }  
            if(flag){  
                i++;  
                continue;  
            }  
            else{//如果是空白行（即可能没有数据，但是有一定格式）  
                if(i == sheet.getLastRowNum())//如果到了最后一行，直接将那一行remove掉  
                    sheet.removeRow(r);  
                else//如果还没到最后一行，则数据往上移一行  
                    sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);  
            }  
        }  
        System.out.println("总行数："+(sheet.getLastRowNum()+1));  
	}
}
