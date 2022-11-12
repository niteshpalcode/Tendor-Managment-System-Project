package com.TMS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TMS.EXCEPTION.TenderStatusException;
import com.TMS.MODEL.Tender_Status;
import com.TMS.UTIL.DBUtil;

public class TenderStatusDaoImpl implements TenderStatusDao{

	@Override
	public List<Tender_Status> getStatus () throws TenderStatusException{
		// TODO Auto-generated method stub
		List<Tender_Status >t=new ArrayList<>();
		
				try(Connection c=DBUtil.provideConnection()){
					PreparedStatement ps=c.prepareStatement("select * from tender_status");
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
					int tid=rs.getInt("t_id");
					int bid=rs.getInt("b_id");
					int vid=rs.getInt("v_id");
					String status=rs.getString("status");
					
					Tender_Status t_s=new Tender_Status(tid, bid, vid, status);
					t.add(t_s);
					
					}
				}catch(SQLException e){
					
					e.getMessage();
					
				}
				if(t.size()==0) {
					throw new TenderStatusException("No record Found");
				}
				
				
		
		return t;
		
		
		
		
	}

}
