package talk.service.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import talk.dao.CommentDao;
import talk.dao.Impl.CommentDaoImpl;
import talk.model.CommentBean;
import talk.service.CommentServicee;
import talk.util.HibernateUtils;

public class CommentServiceImpl implements CommentServicee {
	CommentDao dao;
	SessionFactory factory;

	public CommentServiceImpl() {
		dao = new CommentDaoImpl();
		factory = HibernateUtils.getSessionFactory();
	}

	public void persist(CommentBean cb) {
		dao.persist(cb);
	}

	public int insertCom(CommentBean commentBean) {
		int n = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			n = dao.insertCom(commentBean);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return n;
	}

	public List<CommentBean> selectCom() {
		List<CommentBean> list = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = dao.selectCom();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return list;
	}

}
