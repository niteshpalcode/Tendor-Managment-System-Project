package com.TMS.USECASES;

import java.util.List;

import com.TMS.DAO.TenderDao;
import com.TMS.DAO.TendorDaoImpl;
import com.TMS.EXCEPTION.TenderException;
import com.TMS.MODEL.Tendor;

public class GetAllTenders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TenderDao Tdao =new TendorDaoImpl();

		try {
			List<Tendor> T_list=Tdao.getAllTenders();

			T_list.forEach(s->{
				System.out.println("******************************************");
				System.out.println("Tender id: "+ s.getT_id());
				System.out.println("Tender name: "+ s.getT_name());
				System.out.println("Tender type: "+ s.getT_type());
				System.out.println("Tender amount: "+ s.getT_cost());
				System.out.println("Tender description: "+s.getT_desc());
				System.out.println("Tender deadline: "+s.getT_deadline());
				System.out.println("Tender location: "+s.getT_lock());


				System.out.println("******************************************");
			});





		} catch (TenderException e) {
			System.out.println(e.getMessage());
		}

	}

}
