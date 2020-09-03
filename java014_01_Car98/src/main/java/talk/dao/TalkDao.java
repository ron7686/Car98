package talk.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import talk.model.TalkBean;
import talk.util.HibernateUtils;


public class TalkDao {
	SessionFactory factory;
	public TalkDao() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	public void persist(TalkBean tb) {
		Session session = factory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.persist(tb);
			tx.commit();
		} catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public List<TalkBean> getAll(){
		List<TalkBean> li = new ArrayList<>();
		String hql = "FROM talk";
		Session session = factory.getCurrentSession();
		li = session.createQuery(hql).list();
		return li;
	}
	
}
