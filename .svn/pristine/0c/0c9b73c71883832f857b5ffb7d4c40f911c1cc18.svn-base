package com.job5156.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 读取Excel表格的功能类 description:不能读取wps类型
 * 
 * @author： zhaoman
 * @version 1.0
 */
public class ExcelReader {
	private  POIFSFileSystem fs;
	private  HSSFWorkbook wb;
	private  HSSFSheet sheet;
	private  HSSFRow row;
	
	/**
	 * 正文开始行内容
	 * 默认第二行，第一行为标题
	 */
	public int contentRow = 1;

	/**
	 * 标题起始行
	 * 默认第一行为标题
	 */
	public int titleRow = 0;
	
	/**
	 * 读取的sheet页
	 * 默认第一页
	 */
	public int sheetPage = 0;
	
	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 * 
	 */
	public String[] readExcelTitle(InputStream is) {
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(sheetPage);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		String[] title = new String[colNum];
		for (int i = titleRow; i < colNum; i++) {
			title[i] = getStringCellValue(row.getCell(i, Row.CREATE_NULL_AS_BLANK));
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream excel的输入流
	 * @param split 单元格之间拼接字符串
	 * @return Map 包含单元格数据内容的Map对象
	 */
	public List<Map<Integer, String>> readExcelContent(InputStream is) {
		List<Map<Integer, String>> dataList = Lists.newArrayList();
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(sheetPage);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		for (int i = contentRow; i <= rowNum; i++) {
			row = sheet.getRow(i);
			if(row != null){
				int j = 0;
				Map<Integer, String> rowMap = Maps.newHashMap();
				
				while (j < colNum) {
					HSSFCell cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK); 
					String cellVal = StringUtils.trim(getStringCellValue(cell));
					rowMap.put((j + 1), StringUtils.lowerCase(cellVal));
					j++;
				}
				dataList.add(rowMap);
				rowMap = null;
			}
		}
		return dataList;
	}

	/**
	 * 获取单元格数据内容为字符串类型的数据
	 * 
	 * @param cell  Excel单元格
	 * @return String 单元格数据内容
	 */
	private String getStringCellValue(HSSFCell cell) {
		if(cell != null){
			switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					return cell.getStringCellValue();
				case HSSFCell.CELL_TYPE_NUMERIC:
					return String.valueOf(Double.valueOf(cell.getNumericCellValue()).intValue());
				case HSSFCell.CELL_TYPE_BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue());
			}
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 测试用的
	 */
	public static void main(String[] args) {
		try {
			ExcelReader excelReader = new ExcelReader();
			excelReader.sheetPage=0;
			excelReader.contentRow=1;
			InputStream is = new FileInputStream("D://职位类别整理关键字.xls");
			// 对读取Excel表格内容测试
			List<Map<Integer, String>> dataList = excelReader.readExcelContent(is);
			System.out.println("获得Excel表格的内容:");
			int row = 1;
			for(Map<Integer, String> dataMap : dataList){
				for(Map.Entry<Integer, String> entry : dataMap.entrySet()){
					System.out.println("[" + row + "," + entry.getKey() + "] => " + entry.getValue());
				}
				row ++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		}
	}
}
