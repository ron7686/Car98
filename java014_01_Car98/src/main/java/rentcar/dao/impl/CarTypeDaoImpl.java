package rentcar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

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
	
	private static final String SELECT_ALL = "SELECT typeId, rentId, carBrand, carType, weekdayHourly, holidayHourly, weekdayDaily, holidayDaily FROM cartype";
	@Override
	public Collection<CarTypeBean> getCarTypeData(){
		Collection<CarTypeBean> result = null;
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
		) {
			result = new Vector<>();
				while (rs.next()) {
					CarTypeBean ctb = new CarTypeBean();
					ctb.setTypeId(rs.getInt("typeId"));
					ctb.setRentId(rs.getInt("rentId"));
					ctb.setCarBrand(rs.getString("carBrand"));
					ctb.setCarType(rs.getString("carType"));
					ctb.setWeekdayHourly(rs.getInt("weekdayHourly"));
					ctb.setHolidayHourly(rs.getInt("holidayHourly"));
					ctb.setWeekdayDaily(rs.getInt("weekdayDaily"));
					ctb.setHolidayDaily(rs.getInt("holidayDaily"));
					result.add(ctb);				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("CarTypeDaoImpl_Jdbc類別#queryCarTypeData()發生例外： " 
					+ ex.getMessage());
		}
		return result;
    }
	
//	@Override
//	public void setConnection(Connection con) {
//		
//	}
}
