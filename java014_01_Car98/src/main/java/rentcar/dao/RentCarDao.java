package rentcar.dao;

import java.sql.Connection;

import rentcar.model.RentCarBean;

public interface RentCarDao {
	//1.查詢
	public RentCarBean queryRentCarData(Integer rentId, 
			String store, 
			String area, 
			String address);
	
	public void setConnection(Connection con);
}
