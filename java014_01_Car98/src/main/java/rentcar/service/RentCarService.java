package rentcar.service;

import java.util.List;

import rentcar.model.RentCarBean;

public interface RentCarService {

//	public RentCarBean queryRentCarData(Integer rentId, 
//			String store, 
//			String city, 
//			String district,
//			String street);

	public List<RentCarBean> getAllRentCars();

	public RentCarBean getRentCar();
}
