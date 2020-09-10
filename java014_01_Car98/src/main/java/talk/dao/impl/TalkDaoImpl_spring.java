package talk.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import talk.dao.ITalkDao;
import talk.model.TalkBean;
import talk.util.HibernateUtils;

@Repository
public class TalkDaoImpl_spring implements ITalkDao {
@Autowired
	SessionFactory factory;
	public TalkDaoImpl_spring() {
//		factory = HibernateUtils.getSessionFactory();
	}
	
	@Override
	public void persist(TalkBean tb) {
		Session session = factory.getCurrentSession();
//		Transaction tx=null;
//		try {
//			tx=session.beginTransaction();
			session.persist(tb);
//			tx.commit();
//		} catch (Exception e) {
//			if(tx !=null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<TalkBean> getAll(int page){
		int getpage=(page-1)*10;
		List<TalkBean> li = new ArrayList<>();
		String hql = "FROM TalkBean";
		Session session = factory.getCurrentSession();
		li=session.createQuery(hql).list();
		List<TalkBean> li10=new ArrayList<>();
		for(int i=getpage;i<getpage+10&&i<li.size();i++) {
			li10.add(li.get(i));
		}
		//li = session.createQuery(hql).list();
		return li10;
	}
	
	
	
}
