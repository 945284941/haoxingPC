/**
 * 
 */
package com.qlzy.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.model.Member;

public class ReadExcel {	
	private String excel_path = ResourceUtil.getExcelPath();
	private int excel_row = ResourceUtil.getExcelRow();
	public static void main(String[] args) {
		ReadExcel readExcel = new ReadExcel();
			try {
				readExcel.readXlsOrXlsx();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public List<Member> readXlsOrXlsx() throws IOException, InvalidFormatException {
		ImportExcel ei = new ImportExcel(excel_path, excel_row);		
		List<Member> memberList = new ArrayList<Member>();
		
		for (int i = ei.getDataRowNum(); i < ei.getLastDataRowNum(); i++) {
			Row row = ei.getRow(i);
			Member member = new Member();
			Cell cell1 = row.getCell(0);
			Cell cell2 = row.getCell(1);
//			Object c1 = ei.getCellValue(row, 0);
//			java.text.DecimalFormat df = new DecimalFormat("########");
//			Object c2 = ei.getCellValue(row, 1);
//			String userName = df.format(c1);  
//			String mobile = df.format(c2);  			
			member.setUsername(ei.getValueFromCell(cell1));
			member.setMobile(ei.getValueFromCell(cell2));
			memberList.add(member);
			System.out.println(member.getUsername()+"--"+member.getMobile());
		}
		System.out.println(memberList.size());
		return memberList;
	}
}
