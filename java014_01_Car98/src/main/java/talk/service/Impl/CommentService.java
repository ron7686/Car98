package talk.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import talk.dao.ICommentDao;
import talk.model.CommentBean;
import talk.service.ICommentService;
@Service
public class CommentService implements ICommentService {
	@Autowired
	ICommentDao dao;
//	SessionFactory factory;
	
	public CommentService() {
//		dao=new CommentDao();
//		factory = HibernateUtils.getSessionFactory();
	}
	@Transactional
	@Override
	public void persist(CommentBean cb) {
		dao.persist(cb);
	}
	@Transactional
	@Override
	public int insertCom(CommentBean commentBean){
		 return dao.insertCom(commentBean);	
	}
	
	

}
