package _01_register.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _00_init.util.HibernateUtils;
import _01_register.dao.MemberDao;
import _01_register.model.MemberBean;

// 本類別使用為標準的JDBC技術來存取資料庫。
public class MemberDaoImpl_Hibernate implements MemberDao {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	public MemberDaoImpl_Hibernate() {
//		factory = HibernateUtils.getSessionFactory();
	}

	// 儲存MemberBean物件，將參數mb新增到Member表格內。
	public int saveMember(MemberBean mb) {

		int n = 0;
		Session session = factory.getCurrentSession();
		session.save(mb);
		return n;
	}

	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@SuppressWarnings("unchecked")
	@Override
	public boolean idExists(String id) {
		boolean exist = false;
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE email = :mail";

		List<MemberBean> beans = session.createQuery(hql).setParameter("mail", id).getResultList();
		if (beans.size() == 0) {
			exist = false;
		} else {
			exist = true;
		}
		return exist;
	}

	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@SuppressWarnings("unchecked")
	@Override
	public MemberBean queryMember(Integer id) {
		MemberBean mb = null;
		String hql = "FROM MemberBean WHERE memId = :memId";
		Session session = factory.getCurrentSession();

		List<MemberBean> beans = session.createQuery(hql).setParameter("memId", id).getResultList();
		if (beans.size() > 0) {
			mb = beans.get(0);
		}

		return mb;
	}

	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	@SuppressWarnings("unchecked")
	@Override
	public MemberBean checkIdPassword(String userId, String password) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean m WHERE m.email = :email and m.password = :password";

		List<MemberBean> beans = session.createQuery(hql).setParameter("email", userId)
				.setParameter("password", password).getResultList();
		if (beans.size() > 0) {
			mb = beans.get(0);
		}
		return mb;
	}

	// 更新使用者登入的時間
	@Override
	public int updateLoginTime(String id) {
		int n = 0;
		Session session = factory.getCurrentSession();
		String hql = "UPDATE MemberBean set LoginTime = now() where email= :email";
		session.createQuery(hql).setParameter("email", id).executeUpdate();
		n++;
		return n;
	}
	
	public int updateUserData(MemberBean mb){
		int n = 0;
		Session session = factory.getCurrentSession();
		session.merge(mb);
		n++;
		return n;
	}

	@Override
	public void setConnection(Connection conn) {
		throw new RuntimeException("MemberDaoImpl_Hibernate 類別不支援setConnection()方法");
	}
}
