package com.TMS.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TMS.MODEL.Bidder;
import com.TMS.UTIL.DBUtil;

public class BidderDaoImpl implements BidderDao {

	
	
	@Override
	public String create_bid(Bidder bidder) {
		// TODO Auto-generated method stub
			String result = "Bidding unsuccessfull !";
		
		try(Connection conection = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conection.prepareStatement("insert into bidder values(?,?,?,?,?)");

			ps.setInt(1,bidder.getB_id());

			ps.setInt(2, bidder.getV_id());

			ps.setInt(3,bidder.getT_id());

			ps.setInt(4,bidder.getBid_amount());

			ps.setString(5,bidder.getStatus());


			int x = ps.executeUpdate();

			if(x>0)
				result = " Bid has Successfully done for the tender!. your Bidding ID is: "+ bidder.getB_id();


		} catch (SQLException e) {

			result = e.getMessage();
		}

		
		
		return result;
	}
	
	
//	************************************************************
	
	
	@Override
	public String createBid(int b_id, int v_id, int t_id) {
		// TODO Auto-generated method stub
		
	
		String result = "Bid Acceptance Failed";

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			ps = con.prepareStatement("select * from tender_status where t_id=?");
			ps.setInt(1, t_id);
			rs = ps.executeQuery();
			if(rs.next()){

				result = "Project Already Assigned";
			}
			else{

				pst = con.prepareStatement("update bidder set status = ? where b_id=? and status=?");

				pst.setString(1, "Accepted");
				pst.setInt(2, b_id);
				pst.setString(3, "Pending");

				int x = pst.executeUpdate();
				if(x>0){
					result = "Bid Has Been Accepted Successfully!";
					TenderDao dao = new TendorDaoImpl();
					result = dao.assignTender(b_id, v_id, t_id);
				}
			}
		} catch (SQLException e) {

			result = result + "Error: "+e.getMessage();
			e.printStackTrace();
		}

		return result;
	}
			
//********************************************8		

	
	@Override
	public List<Bidder> getBidV(int V_id) {
		// TODO Auto-generated method stub
		List<Bidder> v_list=new ArrayList<Bidder>();
																																				
		try(Connection conection=DBUtil.provideConnection() ){
			PreparedStatement ps=conection.prepareStatement("select * from bidder where v_id=?");
			
			
			ps.setInt(1, V_id);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Bidder b= new Bidder();
				b.setB_id(rs.getInt("b_id"));
				b.setV_id(rs.getInt("v_id"));
				b.setT_id(rs.getInt("t_id"));
				b.setBid_amount(rs.getInt("bid_amount"));
				b.setStatus(rs.getString("status"));
				
				v_list.add(b);
				
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return v_list;
	}

	
	
	
//	*****************************************************8
	
	@Override
	public List<Bidder> getBidT(int t_id) {
		// TODO Auto-generated method stub
		List<Bidder> t_list=new ArrayList<Bidder>();
		
		try(Connection conection=DBUtil.provideConnection() ){
			PreparedStatement ps=conection.prepareStatement("select * from bidder where t_id=?");
			
			
			ps.setInt(1, t_id);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Bidder b= new Bidder();
				b.setB_id(rs.getInt("b_id"));
				b.setV_id(rs.getInt("v_id"));
				b.setT_id(rs.getInt("t_id"));
				b.setBid_amount(rs.getInt("bid_amount"));
				b.setStatus(rs.getString("status"));
				
				t_list.add(b);
				
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return t_list;
	}

	


}
