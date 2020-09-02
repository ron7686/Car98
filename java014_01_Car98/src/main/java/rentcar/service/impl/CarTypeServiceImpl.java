package rentcar.service.impl;

import rentcar.dao.CarTypeDao;
import rentcar.dao.impl.CarTypeDaoImpl;
import rentcar.model.CarTypeBean;
import rentcar.service.CarTypeService;

public class CarTypeServiceImpl implements CarTypeService{
	
	CarTypeDao dao ;
	public CarTypeServiceImpl() {
		this.dao = new CarTypeDaoImpl();	
	}
	
	@Override
	public CarTypeBean queryCarTypeData(Integer typeId, Integer rentId, 
			String carType, Integer weekdayHourly,
			Integer weekdayDaily, Integer holidayHourly, Integer holidayDaily) {
		CarTypeBean ctb = dao.queryCarTypeData(typeId, rentId, carType, 
				weekdayHourly, weekdayDaily, holidayHourly, holidayDaily);
		return ctb;
	}
}
