package rentcar.service;

import rentcar.model.RentCarBean;

public interface RentCarService {

	public RentCarBean queryRentCarData(Integer rentId, 
			String store, 
			String area, 
			String address);
}
