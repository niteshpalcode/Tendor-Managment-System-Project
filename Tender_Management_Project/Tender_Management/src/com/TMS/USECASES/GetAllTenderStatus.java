package com.TMS.USECASES;

import java.util.ArrayList;
import java.util.List;

import com.TMS.DAO.TenderStatusDao;
import com.TMS.DAO.TenderStatusDaoImpl;
import com.TMS.EXCEPTION.TenderStatusException;
import com.TMS.MODEL.Tender_Status;

public class GetAllTenderStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		TenderStatusDao dao=new TenderStatusDaoImpl();
		
		List<Tender_Status> t;
		try {
			t = dao.getStatus();
			t.forEach(s->{
				System.out.println("******************************************");
				System.out.println("Tender id: "+ s.getT_id());
				System.out.println("Bidder id: "+ s.getB_id());
				System.out.println("Vendor id: "+ s.getV_id());
				System.out.println("Status: "+s.getStatus());
			


				System.out.println("******************************************");
			});
			
			
			
			
			
			
		} catch (TenderStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
