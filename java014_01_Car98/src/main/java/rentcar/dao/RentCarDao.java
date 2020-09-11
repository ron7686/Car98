package rentcar.dao;

import java.sql.Connection;
import java.util.List;

import rentcar.model.RentCarBean;

public interface RentCarDao {
	
	//查詢全部
	List<RentCarBean> getAllRentCars();
	
	//查詢單筆
	RentCarBean getRentCar(Integer rentId);
	
	RentCarBean getRentCar();
	
	public void setConnection(Connection con);


}
