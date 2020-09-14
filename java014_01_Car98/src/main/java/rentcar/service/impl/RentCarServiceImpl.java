package rentcar.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _00_init.util.HibernateUtils;
import rentcar.dao.RentCarDao;
import rentcar.dao.impl.RentCarDaoImpl;
import rentcar.model.RentCarBean;
import rentcar.service.RentCarService;

public class RentCarServiceImpl implements RentCarService{
	
	RentCarDao dao ;
	SessionFactory factory = null;
	
	public RentCarServiceImpl() {
		dao = new RentCarDaoImpl();
		factory = HibernateUtils.getSessionFactory();
	}
	
//	public RentCarBean queryRentCarData() {
//		return dao.queryRentCarData();
//	}
//	
//	@Override
//	public RentCarBean queryRentCarData(Integer rentId, 
//			String store, String city, String district, String street) {
//		RentCarBean rcb = dao.queryRentCarData(rentId, store, city, district, street);
//		return rcb;
//	}
	
	@Override
	public List<RentCarBean> getAllRentCars() {	
		List<RentCarBean> rentCarBean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			rentCarBean = dao.getAllRentCars();
			tx.commit();
		} catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}
			throw new RuntimeException(ex);
		}
		return rentCarBean;
	}
	
	@Override
	public RentCarBean getRentCar() {	
		RentCarBean rentcarbean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			rentcarbean = dao.getRentCar();
			tx.commit();
		} catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}
			throw new RuntimeException(ex);
		}
		return rentcarbean;
	}
}
