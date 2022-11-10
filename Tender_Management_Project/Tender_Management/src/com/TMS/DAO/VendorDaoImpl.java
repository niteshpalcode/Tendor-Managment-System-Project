package com.TMS.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TMS.EXCEPTION.VendorException;
import com.TMS.MODEL.Vendor;
import com.TMS.UTIL.DBUtil;

public class VendorDaoImpl implements VendorDao {

	@Override
	public String insertVendorDetail(Vendor v) {
		// TODO Auto-generated method stub
		String result="Register UnSuccessfully !";
		
		try (Connection conection=DBUtil.provideConnection()){
			
			PreparedStatement ps = conection.prepareStatement("insert into vendor values(?,?,?,?,?,?)");
			ps.setInt(1, v.getV_id());
			ps.setString(2, v.getV_name());
			ps.setString(3, v.getV_mobile());
			ps.setString(4, v.getV_email());
			ps.setString(5, v.getV_company());
			ps.setString(6, v.getV_address());
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				result="Register Successfully";
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
			result = "Error: "+ e.getErrorCode()+" : "+e.getMessage();
		}
		
		
		return result;
	}

	@Override
	public List<Vendor> showAllVendors() throws VendorException {
		// TODO Auto-generated method stub
		List<Vendor> v=new ArrayList<>();
		
		try(Connection c=DBUtil.provideConnection()){
			PreparedStatement ps=c.prepareStatement("select * from vendor");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int v_id=rs.getInt("v_id");
				String v_name=rs.getString("v_name");
				String v_mobile=rs.getString("v_mobile");
				String v_email=rs.getString("v_email");
				String v_cname=rs.getString("v_company");
				String v_address=rs.getString("v_address");
				
				Vendor vobj=new Vendor(v_id, v_name, v_mobile, v_email, v_cname, v_address);
				v.add(vobj);
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new VendorException(e.getMessage());
		}
		
		if(v.size() == 0)
			throw new VendorException("No Vendor found..");
		
		return v;
	}

}
