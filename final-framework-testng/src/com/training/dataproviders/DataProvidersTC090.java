/* Data Provider
 * Test case RETC090 - To verify whether application allows admin to add multiple property with all details*/
package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;

public class DataProvidersTC090 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName = "C:/Users/IBM_ADMIN/git/Selenium_Framework/final-framework-testng/resources/TestData.xlsx";
		String sheetName = "Sheet3";

		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName,sheetName);
		System.out.println("size " + retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()]; 
		int count = 0; 

		for(List<Object> temp : retVal){
			if(temp!=null){
			Object[]  obj = new Object[12]; 
			System.out.println(temp.get(0));
			System.out.println(temp.get(1));
			System.out.println(temp.get(2));
			System.out.println(temp.get(3));
			System.out.println(temp.get(4));
			System.out.println(temp.get(5));
			System.out.println(temp.get(6));
			System.out.println(temp.get(7));
			System.out.println(temp.get(8));
			System.out.println(temp.get(9));
			System.out.println(temp.get(10));
			System.out.println(temp.get(11));
			
			
			obj[0] = temp.get(0); 
			obj[1] = temp.get(1);
			obj[2] = temp.get(2);
			obj[3] = temp.get(3);
			obj[4] = temp.get(4);
			obj[5] = temp.get(5);
			obj[6] = temp.get(6);
			obj[7] = temp.get(7); 
			obj[8] = temp.get(8);
			obj[9] = temp.get(9);
			obj[10] = temp.get(10);
			obj[11] = temp.get(11);
			
			
			result[count ++] = obj; 
			}
		}
		
		return result; 
	}
	
	
}
