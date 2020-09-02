package rentcar.service.impl;

import rentcar.dao.RentCarDao;
import rentcar.dao.impl.RentCarDaoImpl;
import rentcar.model.RentCarBean;
import rentcar.service.RentCarService;

public class RentCarServiceImpl implements RentCarService{
	
	RentCarDao dao ;
	public RentCarServiceImpl() {
		this.dao = new RentCarDaoImpl();	
	}
	
	@Override
	public RentCarBean queryRentCarData(Integer rentId, 
			String store, String area, String address) {
		RentCarBean rcb = dao.queryRentCarData(rentId, store, area , address);
		return rcb;
	}
	
}
