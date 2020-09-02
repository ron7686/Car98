package rentcar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import rentcar.dao.RentCarDao;
import rentcar.model.RentCarBean;


public class RentCarDaoImpl implements RentCarDao {
	private DataSource ds = null;
//	private Connection conn = null;
	
	public RentCarDaoImpl() {
//		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("RentCarDaoImpl_Jdbc類別#建構子發生例外:：" + ex.getMessage());
		}
	}

	@Override
	public RentCarBean queryRentCarData(Integer rentId , String store, String area, String address) {
		RentCarBean rcb = null;
		String sql = "SELECT * FROM rentcar r WHERE r.rentId = ? "
				   + " and r.store = ? "
				   + " and r.area = ? "
				   + " and r.address = ? ";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, rentId);
			ps.setString(2, store);
			ps.setString(3, area);
			ps.setString(4, address);
			
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					rcb = new RentCarBean();
					rcb.setRentId(rs.getInt("rentId"));
					rcb.setStore(rs.getString("store"));
					rcb.setArea(rs.getString("area"));
					rcb.setAddress(rs.getString("address"));		
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("RentCarDaoImpl_Jdbc類別#queryRentCarData()發生例外： " 
					+ ex.getMessage());
		}
		return rcb;
	}

	@Override
	public void setConnection(Connection conn) {
	}

}
