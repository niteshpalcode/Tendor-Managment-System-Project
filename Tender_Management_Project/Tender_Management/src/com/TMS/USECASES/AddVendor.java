package com.TMS.USECASES;

import java.util.Scanner;

import com.TMS.DAO.VendorDao;
import com.TMS.DAO.VendorDaoImpl;
import com.TMS.MODEL.Vendor;

public class AddVendor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Vendor Id: ");
		int id=sc.nextInt();
		
		
		System.out.println("Enter Vendor Name: ");
		String name=sc.next();
		
		
		System.out.println("Enter Vendor's Mobile No.: ");
		String mobile=sc.next();
		
		System.out.println("Enter Vendor's Email : ");
		String email=sc.next();
		
		System.out.println("Enter Comapany Name: ");
		String c_name=sc.next();
		
		System.out.println("Enter Address: ");
		String address=sc.next();
		
		Vendor v=new Vendor(id,name, mobile, email, c_name, address);
		VendorDao v_dao=new VendorDaoImpl();
		
		String result = v_dao.insertVendorDetail(v);
		
		System.out.println(result);
		
		
	}

}
