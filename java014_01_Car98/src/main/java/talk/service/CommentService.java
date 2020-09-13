package talk.service;

import java.util.List;

import org.hibernate.SessionFactory;

import talk.dao.CommentDao;
import talk.model.CommentBean;
import talk.model.TalkBean;
import talk.util.HibernateUtils;

public class CommentService {
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
