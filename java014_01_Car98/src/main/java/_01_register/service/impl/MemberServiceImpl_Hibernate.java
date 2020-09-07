package _01_register.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _00_init.util.HibernateUtils;
import _01_register.dao.MemberDao;
import _01_register.dao.impl.MemberDaoImpl_Hibernate;
import _01_register.model.MemberBean;
import _01_register.service.MemberService;

public class MemberServiceImpl_Hibernate implements MemberService {

	MemberDao  dao ;
	SessionFactory factory = null;
	
	public MemberServiceImpl_Hibernate() {
		this.dao = new MemberDaoImpl_Hibernate();
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public int saveMember(MemberBean mb) {
		int n = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.saveMember(mb);
			n++;
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return n;
	}

	@Override
	public boolean idExists(String id) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = dao.idExists(id);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}

	@Override
	public MemberBean queryMember(Integer id) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			mb = dao.queryMember(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return mb;
	}
	
	@Override
	public MemberBean checkIdPassword(String userId, String password) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			mb = dao.checkIdPassword(userId, password);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
			throw new RuntimeException(e);
		}
		return mb;
	}

	@Override
	public int updateLoginTime(String id) {
		int n = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.updateLoginTime(id);
			n++;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
			throw new RuntimeException(e);
		}
		return n;
	}
}
