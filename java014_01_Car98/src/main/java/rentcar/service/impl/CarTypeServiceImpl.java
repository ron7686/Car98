package rentcar.service.impl;

import java.io.IOException;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _00_init.util.HibernateUtils;
import rentcar.dao.CarTypeDao;
import rentcar.dao.impl.CarTypeDaoImpl;
import rentcar.model.CarTypeBean;
import rentcar.service.CarTypeService;

public class CarTypeServiceImpl implements CarTypeService{
	
	CarTypeDao ctdao ;
	SessionFactory factory = null;
	
	public CarTypeServiceImpl() throws IOException {
		ctdao = new CarTypeDaoImpl();	
		factory = HibernateUtils.getSessionFactory();
	}
	
	public Collection<CarTypeBean> getCarTypeData(){
		Collection<CarTypeBean> carTypeBean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			carTypeBean = ctdao.getCarTypeData();
			tx.commit();
		} catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}
			throw new RuntimeException(ex);
		}
		return carTypeBean;
	}
	
//	public Collection<CarTypeBean> getCarTypeData(){ 
//		return ctdao.getCarTypeData();
//	}
	
//	@Override
//	public Collection<CarTypeBean> getQueryCarTypeData(
//			Integer typeId, 
//			Integer rentId, 
//			String carBrand, 
//			String carType,
//			Integer weekdayHourly, 
//			Integer holidayHourly, 
//			Integer weekdayDaily, 
//			Integer holidayDaily) {
//		return null;
//	}
}
