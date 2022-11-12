package com.TMS.DAO;

import java.util.List;

import com.TMS.EXCEPTION.TenderStatusException;
import com.TMS.MODEL.Tender_Status;

public interface TenderStatusDao {
	public List<Tender_Status> getStatus() throws TenderStatusException;
}
