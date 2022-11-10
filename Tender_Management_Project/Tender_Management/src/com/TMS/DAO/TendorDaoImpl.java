package com.TMS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TMS.EXCEPTION.TenderException;
import com.TMS.EXCEPTION.VendorException;
import com.TMS.MODEL.Tendor;
import com.TMS.MODEL.Vendor;
import com.TMS.UTIL.DBUtil;

public class TendorDaoImpl implements TenderDao{

	@Override
	public String createTendor(Tendor t) {
		// TODO Auto-generated method stub
		String result="Register Unsuccessfull !";
		
		try (Connection conection=DBUtil.provideConnection()){
			
			PreparedStatement ps=conection.prepareStatement("insert into tender values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, t.getT_id());
			ps.setString(2, t.getT_name());
			ps.setString(3, t.getT_type());
			ps.setString(4, t.getT_cost());
			ps.setString(5, t.getT_desc());
			ps.setString(6, t.getT_deadline());
			ps.setString(7, t.getT_lock());
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				
				result="Register Successfull.";
			}
			
			
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			result="Error "+ e.getErrorCode()+" : "+ e.getMessage();
		}
		
				
				
				
		return result;
	}

	@Override
	public List<Tendor> getAllTenders() throws TenderException {
		// TODO Auto-generated method stub
	List<Tendor> t=new ArrayList<>();
	
		
		try(Connection c=DBUtil.provideConnection()){
			PreparedStatement ps=c.prepareStatement("select * from tender");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int t_id=rs.getInt("t_id");
				String t_name=rs.getString("t_name");
				String t_mobile=rs.getString("t_type");
				String t_email=rs.getString("t_cost");
				String t_cname=rs.getString("t_desc");
				String t_address=rs.getString("t_deadline");
				String t_loc=rs.getString("t_loc");
				
				
				Tendor tobj=new Tendor(t_id, t_name, t_mobile, t_email, t_cname, t_address, t_loc);
				t.add(tobj);
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		if(t.size() == 0)
			throw new TenderException("No Tendor found..");
		
		return t;
	}
		
}
