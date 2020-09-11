package rentcar.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _00_init.util.HibernateUtils;
import rentcar.model.CarTypeBean;
import rentcar.dao.CarTypeDao;

@SuppressWarnings("unchecked")
public class CarTypeDaoImpl_Hibernate implements CarTypeDao {

	SessionFactory factory;
	
	public CarTypeDaoImpl_Hibernate() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	@Override
	public Collection<CarTypeBean> getCarTypeData(){
		String hql = "FROM CarTypeBean";
		Session session = factory.getCurrentSession();
		Collection<CarTypeBean> carTypeBean = session.createQuery(hql).list();
		return carTypeBean;
    }
	
//	@Override
//	public void setConnection(Connection con) {
//		
//	}
}
