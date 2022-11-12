package com.TMS.DAO;

import java.util.List;

import com.TMS.MODEL.Bidder;

public interface BidderDao {
	
	public String createBid(int b_id,int v_id,int t_id);
	
	public List<Bidder> getBidV(int v_id);
	
	public List<Bidder> getBidT(int t_id);

	public String create_bid(Bidder bidder);
	
}
 