package com.TMS.USECASES;

import java.util.Scanner;

import com.TMS.DAO.TenderDao;
import com.TMS.DAO.TendorDaoImpl;
import com.TMS.MODEL.Tendor;

public class AddTender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Tendor Id: ");
		int id=sc.nextInt();
		
		System.out.println("Enter Tender name: ");
		
		String t_name = sc.next();
		
		System.out.println("Enter Tender type: ");
		String t_type = sc.next();
		
		
		System.out.println("Enter Tender cost: ");
		String t_cost = sc.next();
		
		System.out.println("Enter Tender description: ");
		String t_desc = sc.next();
		
		System.out.println("Enter Tender deadline in 'YYYY-MM-DD': ");
		String t_deadline = sc.next();
		
		System.out.println("Enter Tender location: ");
		String t_loc = sc.next();
		
		
		Tendor t=new Tendor(id, t_name, t_type, t_cost, t_desc, t_deadline, t_loc);
		
		TenderDao tDao=new TendorDaoImpl();
		
		String result=tDao.createTendor(t);
		
		System.out.println(result);

	}

}
