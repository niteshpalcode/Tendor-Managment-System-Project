package com.TMS.USECASES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.TMS.UTIL.DBUtil;

public class CheckVAlidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Username: ");
		String email = sc.next();


		System.out.println("Enter Password");
		String pass = sc.next();






		try(Connection conn= DBUtil.provideConnection()) {

			PreparedStatement ps= conn.prepareStatement("select * from vendor where v_email=? and v_pass=?");

			ps.setString(1, email);
			ps.setString(2, pass);



			ResultSet rs= ps.executeQuery();

			if(rs.next()) {

				if(rs.getString("v_email").equalsIgnoreCase(email)&& rs.getString("v_pass").equalsIgnoreCase(pass)) {

					System.out.println("Welcome "+rs.getString("v_name"));
					SwitchActivity.Vendor();
				}


			}else {

				System.out.println("Username or password are wrong try again");
				SwitchActivity.selectUser();

			}




		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
