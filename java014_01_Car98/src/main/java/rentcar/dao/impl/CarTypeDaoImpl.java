package rentcar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import rentcar.model.CarTypeBean;
import rentcar.dao.CarTypeDao;


public class CarTypeDaoImpl implements CarTypeDao {

	private DataSource ds = null;
	
	public CarTypeDaoImpl() {
//		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("CarTypeDaoImpl_Jdbc類別#建構子發生例外:：" + ex.getMessage());
		}
	}

	@Override
	public CarTypeBean queryCarTypeData(Integer typeId, 
			Integer rentId, 
			String carType, 
			Integer weekdayHourly, 
			Integer holidayHourly, 
			Integer weekdayDaily, 
			Integer holidayDaily) {
		CarTypeBean ctb = null;
		String sql = "SELECT * FROM cartype c WHERE c.typeId = ? "
				   + " and c.rentId = ? "
				   + " and c.carType = ? "
				   + " and c.weekdayHourly = ? "
				   + " and c.holidayHourly = ? "
				   + " and c.weekdayDaily = ? "
				   + " and c.holidayDaily = ? ";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, typeId);
			ps.setInt(2, rentId);
			ps.setString(3, carType);
			ps.setInt(4, weekdayHourly);
			ps.setInt(5, holidayHourly);
			ps.setInt(6, weekdayDaily);
			ps.setInt(7, holidayDaily);
			
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					ctb = new CarTypeBean();
					ctb.setTypeId(rs.getInt("typeId"));
					ctb.setRentId(rs.getInt("rentId"));
					ctb.setCarType(rs.getString("carType"));
					ctb.setWeekdayHourly(rs.getInt("weekdayHourly"));
					ctb.setHolidayHourly(rs.getInt("holidayHourly"));
					ctb.setWeekdayDaily(rs.getInt("weekdayDaily"));
					ctb.setHolidayDaily(rs.getInt("holidayDaily"));
							
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("CarTypeDaoImpl_Jdbc類別#queryCarTypeData()發生例外： " 
					+ ex.getMessage());
		}
		return null;
    }
	
	@Override
	public void setConnection(Connection con) {
		
	}
}
