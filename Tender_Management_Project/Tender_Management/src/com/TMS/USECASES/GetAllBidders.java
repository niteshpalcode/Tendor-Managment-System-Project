package com.TMS.USECASES;

import java.util.List;
import java.util.Scanner;

import com.TMS.DAO.BidderDao;
import com.TMS.DAO.BidderDaoImpl;
import com.TMS.MODEL.Bidder;

public class GetAllBidders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Vender id: ");
		int V_id = sc.nextInt();


		BidderDao dao =new BidderDaoImpl();
		try {
			List<Bidder> b=dao.getBidV(V_id);

			if(b.size()==0) {
				System.out.println("No bidding record!!");
			}else {
				b.forEach(s->{
					System.out.println("******************************************");
					System.out.println("Bidder id: "+  s.getB_id());
					System.out.println("Bidding Amount: "+ s.getBid_amount());
					System.out.println("Bidding Status: "+ s.getStatus());
					System.out.println("vendor Id: "+ s.getV_id());



					System.out.println("******************************************");
				});


			}


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
