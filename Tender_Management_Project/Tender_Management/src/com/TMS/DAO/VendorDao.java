package com.TMS.DAO;

import java.util.List;

import com.TMS.EXCEPTION.VendorException;
import com.TMS.MODEL.Vendor;

public interface VendorDao {
		public String insertVendorDetail(Vendor v);
		
		public List<Vendor> showAllVendors() throws VendorException;
		
}
