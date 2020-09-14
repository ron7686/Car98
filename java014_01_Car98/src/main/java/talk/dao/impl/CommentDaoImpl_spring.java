package talk.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import talk.dao.ICommentDao;
import talk.model.CommentBean;
import talk.util.HibernateUtils;
@Repository
public class CommentDaoImpl_spring implements ICommentDao {
	@Autowired
	SessionFactory factory;

	public CommentDaoImpl_spring() {
//		factory = HibernateUtils.getSessionFactory();
	}
	
	
	@Override
	public void persist(CommentBean cb) {
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			session.persist(cb);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public int insertCom(CommentBean commentBean) {
		Session session = factory.getCurrentSession();
		int n = 0;
		session.save(commentBean);
		n++;
		return n;

	}
}
