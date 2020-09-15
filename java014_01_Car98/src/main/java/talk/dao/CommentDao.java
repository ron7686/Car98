package talk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import talk.model.CommentBean;
import talk.util.HibernateUtils;

public class CommentDao {
	SessionFactory factory;

	public CommentDao() {
		factory = HibernateUtils.getSessionFactory();
	}

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

	@SuppressWarnings("unchecked")
	public int insertCom(CommentBean commentBean) {
		Session session = factory.getCurrentSession();
		int n = 0;
		session.save(commentBean);
		n++;
		return n;

	}

	@SuppressWarnings("unchecked")
	public List<CommentBean> selectCom() {
		Session session = factory.getCurrentSession();
		List<CommentBean> list = null;
		String hql = "FROM CommentBean";
		list = session.createQuery(hql).getResultList();
		return list;
	}
}
