package com.TMS.USECASES;

import java.util.Scanner;

import com.TMS.DAO.BidderDao;
import com.TMS.DAO.BidderDaoImpl;

public class AcceptBid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);


		System.out.println("Enter your vendor ID: ");
		int vid = sc.nextInt();


		System.out.println("Enter the tendor ID: ");
		int tid = sc.nextInt();

		System.out.println("Enter the bider ID: ");
		int bid = sc.nextInt();

		BidderDao dao = new BidderDaoImpl();

		String status = dao.createBid(bid, vid, tid);
		System.out.println(status);
	}

}
