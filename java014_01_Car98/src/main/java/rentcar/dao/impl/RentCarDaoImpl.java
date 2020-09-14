package rentcar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Vector;

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
		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("RentCarDaoImpl_Jdbc類別#建構子發生例外:：" + ex.getMessage());
		}
	}

	private static final String SELECT_ALL = "SELECT rentId, store, city, district, street FROM rentcar";
	@Override
	public List<RentCarBean> getAllRentCars() {
		List<RentCarBean> result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();				
		) {
			result = new Vector<>();
			while (rs.next()) {
				RentCarBean rcb = new RentCarBean();
				rcb.setRentId(rs.getInt("rentId"));
				rcb.setStore(rs.getString("store"));
				rcb.setCity(rs.getString("city"));
				rcb.setDistrict(rs.getString("district"));
				rcb.setStreet(rs.getString("street"));
				result.add(rcb);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("RentCarDaoImpl_Jdbc類別#queryRentCarData()發生例外： " 
					+ ex.getMessage());
		}
		return result; 
	}
	
	@Override
	public RentCarBean getRentCar(Integer rentId) {
		RentCarBean rcb = null;
		String sql = "SELECT rentId, store, city, district, street FROM rentcar WHERE rentId = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, rentId);
			try (
				 ResultSet rs = ps.executeQuery();
			) {
				if (rs.next()) {
				rcb = new RentCarBean();
				rcb.setRentId(rs.getInt("rentId"));
				rcb.setStore(rs.getString("store"));
				rcb.setCity(rs.getString("city"));
				rcb.setDistrict(rs.getString("district"));
				rcb.setStreet(rs.getString("street"));
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

	@Override
	public RentCarBean getRentCar() {
		return null;
	}
	
}
