package talk.service;

import org.hibernate.SessionFactory;

import talk.dao.CommentDao;
import talk.model.CommentBean;
import talk.util.HibernateUtils;

public class CommentService  {
	CommentDao dao;
	SessionFactory factory;
	
	public CommentService() {
		dao=new CommentDao();
		factory = HibernateUtils.getSessionFactory();
	}
	
	public void persist(CommentBean cb) {
		dao.persist(cb);
	}
	
	public int insertCom(CommentBean commentBean){
		 return dao.insertCom(commentBean);	
	}
	
	

}
