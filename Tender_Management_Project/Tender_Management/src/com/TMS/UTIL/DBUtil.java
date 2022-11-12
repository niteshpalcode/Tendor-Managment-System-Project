package com.TMS.UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtil {

	public static Connection provideConnection() {
		Connection conection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/tenderdb";
		
		try {
			conection = DriverManager.getConnection(url, "root", "nitesh");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conection;
	}
	

	public static String generateBidderId(){
		String bidderId = null;
		
		SimpleDateFormat sdf=new SimpleDateFormat("MMddmmss");
		bidderId =sdf.format(new Date());
//		bidderId = "B"+bidderId;
		
		return bidderId;
	}
}
