/* Test case RETC086 - To Verify whether application allows admin to Add New Region in the application & 
 * added details should get displayed in database */

package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.TC086_LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RealEstateDAO;
import com.training.readexcel.ApachePOIExcelRead;

public class DataProvidersDB_TC086 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<TC086_LoginBean> list = new RealEstateDAO().getRegions(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(TC086_LoginBean temp : list){
			Object[]  obj = new Object[3]; 
			obj[0] = temp.getRegionName(); 
			obj[1] = temp.getSlugName();
			obj[2] = temp.getDescription();
			
			result[count ++] = obj; 
		}
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(String sheetName){
		String fileName = "C:/Users/IBM_ADMIN/Documents/testing1.xlsx";
		String sheetName1 = "Sheet1";
		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName,sheetName1);
		System.out.println("size " + retVal.size());
		
		
		Object[][] result = new Object[retVal.size()][retVal.size()]; 
		int count = 0; 

		for(List<Object> temp : retVal){
			if(temp!=null){
			Object[]  obj = new Object[2]; 
			System.out.println(temp.get(0));
			System.out.println(temp.get(1));

			obj[0] = temp.get(0); 
			obj[1] = temp.get(1); 
			
			result[count ++] = obj; 
			}
		}
		
		return result; 
	}
	
	
}
