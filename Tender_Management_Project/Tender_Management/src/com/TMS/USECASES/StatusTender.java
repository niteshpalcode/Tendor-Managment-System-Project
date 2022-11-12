package com.TMS.USECASES;

import java.util.Scanner;

import com.TMS.DAO.TenderDao;
import com.TMS.DAO.TendorDaoImpl;

public class StatusTender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Tender No. to check status: ");
		int tid = sc.nextInt();
		
		
		TenderDao dao = new TendorDaoImpl();
		
		
		
		 String  status  =  dao.getTenderStatus(tid);
		
		System.out.println(status);
		
	}

}
