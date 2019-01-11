/* Test case RETC086 - To Verify whether application allows admin to Add New Region in the application & 
 * added details should get displayed in database
 * The DAO for RealEstate Project */

package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.TC086_LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class RealEstateDAO {
	
	Properties properties; 
	
	public RealEstateDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<TC086_LoginBean> getRegions(){
		String sql = properties.getProperty("get.regions"); 
		
		GetConnection gc  = new GetConnection(); 
		List<TC086_LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<TC086_LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				TC086_LoginBean temp = new TC086_LoginBean(); 
				temp.setRegionName(gc.rs1.getString(1));
				temp.setSlugName(gc.rs1.getString(2));
				temp.setDescription(gc.rs1.getString(3));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RealEstateDAO().getRegions().forEach(System.out :: println);
	}
	
	
}
