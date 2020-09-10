package talk.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import talk.dao.ITalkDao;
import talk.model.TalkBean;
import talk.service.ITalkService;

@Service
public class TalkService implements ITalkService {
@Autowired
	ITalkDao dao;
//	SessionFactory factory;
	
	public TalkService() {
//		dao=new TalkDao();
//		factory = HibernateUtils.getSessionFactory();
	}
	@Transactional
	@Override
	public void persist(TalkBean tb) {
		dao.persist(tb);
	}
	@Transactional
	@Override
	public List<TalkBean> select(int page){
		List<TalkBean> bean = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			bean = dao.getAll(page);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
		return bean;
	}
	@Transactional
	@Override
	public List<TalkBean> getAllTalk(int page){
		return select(page);
	}
	
	
}
