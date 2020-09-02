package rentcar.dao;

import java.sql.Connection;
import rentcar.model.CarTypeBean;

public interface CarTypeDao {
	//1.查詢
	public CarTypeBean queryCarTypeData(Integer typeId, 
			Integer rentId, 
			String carType, 
			Integer weekdayHourly, 
			Integer weekdayDaily, 
			Integer holidayHourly, 
			Integer holidayDaily);
		
	public void setConnection(Connection con);
}
