package com.TMS.DAO;

import java.util.List;

import com.TMS.EXCEPTION.TenderException;
import com.TMS.MODEL.Tendor;

public interface TenderDao {
	public String createTendor(Tendor t );
	
	public List<Tendor> getAllTenders() throws TenderException;
	
}
