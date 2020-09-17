package talk.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import talk.dao.CommentDao;
import talk.model.CommentBean;
import talk.util.HibernateUtils;

public class CommentDaoImpl implements CommentDao {
	
	SessionFactory factory;

	public CommentDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}
	

	@Override
	public void persist(CommentBean cb) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(cb);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public int insertCom(CommentBean commentBean) {
		Session session = factory.getCurrentSession();
		int n = 0;
		session.save(commentBean);
		n++;
		return n;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommentBean> selectCom() {
		Session session = factory.getCurrentSession();
		List<CommentBean> list = null;
		String hql = "FROM CommentBean";
		list = session.createQuery(hql).getResultList();
		return list;
	}

}
