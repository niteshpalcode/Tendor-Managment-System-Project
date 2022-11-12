package com.TMS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TMS.EXCEPTION.TenderException;

import com.TMS.MODEL.Tender_Status;
import com.TMS.MODEL.Tendor;

import com.TMS.UTIL.DBUtil;

public class TendorDaoImpl implements TenderDao{

	
//	1
	@Override
	public String createTendor(Tendor t) {
		// TODO Auto-generated method stub
		String result="Register Unsuccessfull !";
		
		try (Connection conection=DBUtil.provideConnection()){
			
			PreparedStatement ps=conection.prepareStatement("insert into tender(t_name,t_type,t_cost,t_desc,t_deadline,t_location) values(?,?,?,?,?,?)");
			
			ps.setString(1, t.getT_name());
			ps.setString(2, t.getT_type());
			ps.setString(3, t.getT_cost());
			ps.setString(4, t.getT_desc());
			ps.setString(5, t.getT_deadline());
			ps.setString(6, t.getT_lock());
			
			int x=ps.executeUpdate();
			
			ps= conection.prepareStatement("select * from tender where t_name=?");
			ps.setString(1, t.getT_name());
			
			ResultSet rs= ps.executeQuery();
			
			int id=0;
			
			while(rs.next()) {


				id= rs.getInt("t_id");

			}

			
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

	
//	2
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
				String t_loc=rs.getString("t_location");
				
				
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

	
//	3
	@Override
	public String assignTender(int bidderId, int vendorId,int tenderId ) {
		// TODO Auto-generated method stub
		
		String status = "Tender Assigning failed";

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from tender_status where t_id=?");
			ps.setInt(1, tenderId);

			rs = ps.executeQuery();

			if(rs.next()){

				status = "Tender is Already Assigned to Vendor: "+rs.getInt("v_id");
			}
			else{

				ps = con.prepareStatement("insert into tender_status values(?,?,?,?)");
				ps.setInt(1,tenderId);
				ps.setInt(2, bidderId);
				ps.setInt(3, vendorId);
				ps.setString(4, "Assigned");

				int k = ps.executeUpdate();
				
				
				
				if(k>0){
					status = "Tender: "+tenderId+" has been Assigned to vendor: "+vendorId;
				}

			}
		} catch (SQLException e) {
			status = status + e.getMessage();
			e.printStackTrace();
		}


		return status;
		

	}
	
//	4

	@Override
	public String getTenderStatus(int tid) {
		// TODO Auto-generated method stub
		String status = "Not Assigned";


		PreparedStatement ps = null;

		ResultSet rs = null;

		try (Connection con = DBUtil.provideConnection()){
			ps = con.prepareStatement("select * from tender_status where t_id=?");

			ps.setInt(1, tid);

			rs = ps.executeQuery();

			if(rs.next()){
				//Tender Has been Assigned 

				status = "Assigned";
			}

		} catch (SQLException e) {
			status = "Error: "+e.getMessage();
			e.printStackTrace();
		}

		return status;
	}


	@Override
	public List<Tender_Status> getAllAssignedTenders() {
		// TODO Auto-generated method stub
		List<Tender_Status> statusList = new ArrayList<Tender_Status>();



		PreparedStatement ps  = null;

		ResultSet rs = null;

		try(Connection con = DBUtil.provideConnection()) {

			ps = con.prepareStatement("select * from tender_status");

			rs = ps.executeQuery();

			while(rs.next()){

				Tender_Status status = new Tender_Status(rs.getInt("t_id"), rs.getInt("b_id"), rs.getInt("v_id"), rs.getString("status"));

				statusList.add(status);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}



		return statusList;
		
		
		
		
	}
		
}
