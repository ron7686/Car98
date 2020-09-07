package talk.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import talk.dao.TalkDao;
import talk.model.TalkBean;
import talk.util.HibernateUtils;


public class TalkService {

	TalkDao dao;
	SessionFactory factory;
	
	public TalkService() {
		dao=new TalkDao();
		factory = HibernateUtils.getSessionFactory();
	}
	
	public void persist(TalkBean tb) {
		dao.persist(tb);
	}
	
	public List<TalkBean> select(int page){
		List<TalkBean> bean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = dao.getAll(page);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return bean;
	}
	
	public List<TalkBean> getAllTalk(int page){
		return select(page);
	}
	
	
}
