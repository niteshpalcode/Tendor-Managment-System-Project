package com.TMS.USECASES;

import java.util.List;

import com.TMS.DAO.VendorDao;
import com.TMS.DAO.VendorDaoImpl;
import com.TMS.EXCEPTION.VendorException;
import com.TMS.MODEL.Vendor;

public class GetAllVendors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendorDao vDao=new VendorDaoImpl();
		
		try {
			List<Vendor> Vlist=vDao.showAllVendors();
			
			Vlist.forEach(s->{
				System.out.println("**********************************");
				System.out.println("vendor id: "+ s.getV_id());
				System.out.println("vendor name: "+ s.getV_name());
				System.out.println("vendor email: "+ s.getV_email());
				
				System.out.println("vendor Mobile: "+s.getV_mobile());
				System.out.println("vendor company: "+s.getV_company());
				System.out.println("vendor address: "+s.getV_address());
				
				
				
				System.out.println("**********************************");
			});
			
			
			
			
			
		} catch (VendorException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
