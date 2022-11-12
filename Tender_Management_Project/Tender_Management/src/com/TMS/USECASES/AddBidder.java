package com.TMS.USECASES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.TMS.DAO.BidderDao;
import com.TMS.DAO.BidderDaoImpl;
import com.TMS.MODEL.Bidder;
import com.TMS.UTIL.DBUtil;

public class AddBidder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub




			try(Connection conn = DBUtil.provideConnection()) {


				System.out.println("Enter your vendor ID: ");


				Scanner sc = new Scanner(System.in);
				int v_id = sc.nextInt();



				System.out.println("Enter the tendor ID: ");
				int t_id = sc.nextInt();

				System.out.println("Enter the bid amount: ");
				int bid_amount = sc.nextInt();


				int b_id= Integer.parseInt(DBUtil.generateBidderId());
				
				PreparedStatement ps = conn.prepareStatement("select * from bidder where v_id=? and t_id=?");
				ps.setInt(1, v_id);
				ps.setInt(2, t_id);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					if(v_id==rs.getInt("v_id") && t_id ==rs.getInt("t_id")) {
						System.out.println("only one bid allowed");
					}
					
				}else {
					
					Bidder bidObject = new Bidder(b_id, v_id, t_id, bid_amount,"pending");
					BidderDao dao = new BidderDaoImpl();

					
					String status = dao.create_bid(bidObject);
					System.out.println(status);
				}


				

			} catch (SQLException e) {

				System.out.println(e.getMessage());


			}catch(InputMismatchException f) {
				System.out.println("invalid input");
			}




		}
}