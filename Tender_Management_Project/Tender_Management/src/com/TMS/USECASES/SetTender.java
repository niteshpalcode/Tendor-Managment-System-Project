package com.TMS.USECASES;

import java.util.Scanner;

import com.TMS.DAO.TenderDao;
import com.TMS.DAO.TendorDaoImpl;

public class SetTender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter your vendor ID: ");
		int vid = sc.nextInt();

		System.out.println("Enter the tendor ID: ");
		int tid = sc.nextInt();
		
		System.out.println("Enter the bider ID: ");
		int bid = sc.nextInt();
		
		TenderDao dao = new TendorDaoImpl();
		
		String status = dao.assignTender(tid, vid, bid);
		
		System.out.println( status);
		
		
		



	}

}
