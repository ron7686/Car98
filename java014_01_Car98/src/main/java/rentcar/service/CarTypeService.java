package rentcar.service;

import java.util.Collection;
import rentcar.model.CarTypeBean;

public interface CarTypeService {

//	public Collection<CarTypeBean> getCarTypeData(
//			Integer typeId, 
//			Integer rentId, 
//			String carBrand, 
//			String carType, 
//			Integer weekdayHourly, 
//			Integer holidayHourly, 
//			Integer weekdayDaily, 
//			Integer holidayDaily);
	public Collection<CarTypeBean> getCarTypeData();
}
