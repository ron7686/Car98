package rentcar.service;

import rentcar.model.CarTypeBean;

public interface CarTypeService {

	public CarTypeBean queryCarTypeData(Integer typeId, 
			Integer rentId, 
			String carType, 
			Integer weekdayHourly, 
			Integer weekdayDaily, 
			Integer holidayHourly, 
			Integer holidayDaily);

}
