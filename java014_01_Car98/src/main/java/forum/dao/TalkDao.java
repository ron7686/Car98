package forum.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _00_init.util.HibernateUtils;
import forum.model.TalkBean;



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
	
}

