package rentcar.dao.impl;

import java.sql.Connection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _00_init.util.HibernateUtils;
import rentcar.dao.RentCarDao;
import rentcar.model.RentCarBean;

@SuppressWarnings("unchecked")
public class RentCarDaoImpl_Hibernate implements RentCarDao {

//	private Connection conn = null;
	SessionFactory factory;
	
	public RentCarDaoImpl_Hibernate() {
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<RentCarBean> getAllRentCars() {		//取得所有租車資料
		String hql = "FROM RentCarBean";
		Session session = factory.getCurrentSession();
		List<RentCarBean> rentCarBean = session.createQuery(hql).list();
		return rentCarBean;	
	}
	
	@Override
	public RentCarBean getRentCar() {				//取得單筆租車資料(第?筆)
		String hql = "FROM RentCarBean";
		Session session = factory.getCurrentSession();
		RentCarBean rentcarbean = (RentCarBean) session.createQuery(hql).list().get(0);
		return rentcarbean;
	}
	
//	@Override
//	public List<RentCarBean> getRentCarByDistrict(String district) {	//取得符合地區的資料(經過使用者篩選)
//		String hql = "FROM RentCarBean WHERE district = :district";
//		Session session = factory.getCurrentSession();
//		List<RentCarBean> rentcarbean = session.createQuery(hql).list();
//		return rentcarbean;
//	}
	
	
	
	@Override
	public void setConnection(Connection conn) {
	}

	@Override
	public RentCarBean getRentCar(Integer rentId) {
		return null;
	}	
	
}
