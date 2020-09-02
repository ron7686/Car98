package commodity.dao.impl;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import commodity.dao.BidDao;
import commodity.model.BidBean;


// 本類別使用純JDBC的技術來存取資料庫。
// 所有SQLException都以catch區塊捕捉，然後一律再次丟出RuntimeException。
// 對SQLException而言，即使catch下來，程式依然無法正常執行，所以捕捉SQLException，再次丟出
// RuntimeException。
public class BidDaoImpl_Jdbc implements Serializable, BidDao {

	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	public BidDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CarDB");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("BookDaoImpl_Jdbc()#建構子發生例外: " 
										+ ex.getMessage());
		}
	}
	private static final String SELECT_BY_ID = "Select bidId, memId, bidItemName, bidDetail, bidPrice, bidSelled, bidTime, bidScore, bidPic from bid where bidId = ?";
	@Override
	public BidBean getBid(int bidId) {
		BidBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
		) {
			stmt.setInt(1, bidId);
			try (
				ResultSet rset = stmt.executeQuery();					
			){
				if (rset.next()) {
					result = new BidBean();
					result.setBidId(rset.getInt("bidId"));
					result.setMemId(rset.getInt("memId"));
					result.setBidItemName(rset.getString("bidItemName"));
					result.setBidDetail(rset.getString("bidDetail"));
					result.setBidPrice(rset.getInt("bidPrice"));
					result.setBidSelled(rset.getInt("bidSelled"));
					result.setBidTime(rset.getDate("bidTime"));
					result.setBidScore(rset.getInt("bidScore"));
					result.setBidPic(rset.getBlob("bidPic"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	private static final String SELECT_ALL = "Select bidId, memId, bidItemName, bidDetail, bidPrice, bidSelled,bidTime ,bidScore,bidPic from bid";
	@Override
	public List<BidBean> getSelectBid() {
		List<BidBean> result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();				
		) {
			result = new Vector<>();
			while (rset.next()) {
				BidBean temp = new BidBean();
				temp.setBidId(rset.getInt("bidId"));
				temp.setMemId(rset.getInt("memId"));
				temp.setBidItemName(rset.getString("bidItemName"));
				temp.setBidDetail(rset.getString("bidDetail"));
				temp.setBidPrice(rset.getInt("bidPrice"));
				temp.setBidSelled(rset.getInt("bidSelled"));
				temp.setBidTime(rset.getDate("bidTime"));
				temp.setBidScore(rset.getInt("bidScore"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	private static final String INSERT = "Insert into bid (bidId, memId, bidItemName, bidDetail, bidPrice, bidSelled, bidTime, bidScore, bidPic, fileName) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	@Override
	public BidBean saveBid(BidBean bean) {
		BidBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
		) {
			stmt.setInt(1, bean.getBidId());
			stmt.setInt(2, bean.getMemId());
			stmt.setString(3, bean.getBidItemName());
			stmt.setString(4, bean.getBidDetail());
			stmt.setInt(5, bean.getBidPrice());
			stmt.setInt(6, bean.getBidSelled());

			java.util.Date temp = bean.getBidTime();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(7, someTime);
			} else {
				stmt.setDate(7, null);
			}

//			Timestamp ts = new Timestamp(System.currentTimeMillis());
			stmt.setInt(8, bean.getBidScore());
			Blob b = null;
			stmt.setBlob(9, b);
			stmt.setString(10, bean.getFileName());
			
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.getBid(bean.getBidId());
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return result;
	}
	private static final String DELETE = "Delete from bid where bidId=?";
	@Override
	public int deleteBid(String bidId) {
		int result = 0;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);
		) {
			stmt.setString(1, bidId);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
}