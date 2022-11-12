package com.TMS.USECASES;

import java.util.List;
import java.util.Scanner;

import com.TMS.DAO.BidderDao;
import com.TMS.DAO.BidderDaoImpl;
import com.TMS.MODEL.Bidder;

public class HistoryofBids {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your vendor ID: ");

		int vid = sc.nextInt();

		BidderDao dao = new BidderDaoImpl();


		List<Bidder> BList  = dao.getBidV(vid);

		if(BList.size()==0) {
			System.out.println("No bidding history available !");
		}else {



			BList.forEach(s->{
				System.out.println("**********************************");
				System.out.println("Biding id: "+s.getB_id());
				System.out.println("Vender id: "+s.getV_id());
				System.out.println("Tender id: "+s.getT_id());
				System.out.println("Status: "+s.getStatus());
				System.out.println("Amount: "+s.getBid_amount());

				System.out.println("**********************************");
			});
		}





	}

}
