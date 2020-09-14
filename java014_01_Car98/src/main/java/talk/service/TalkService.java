package talk.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import talk.dao.TalkDao;
import talk.model.TalkBean;
import talk.util.HibernateUtils;


public class TalkService  {

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
		bean = dao.getPage(page);
		return bean;
	}
	
	public int lastpage() {
		return dao.lastpage();
	}

	public TalkBean selectOne(int postID) {
		return dao.selectOne(postID);
	}
}
