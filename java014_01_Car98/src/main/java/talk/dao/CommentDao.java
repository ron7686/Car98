package talk.dao;

import java.util.List;

import talk.model.CommentBean;

public interface CommentDao {

	void persist(CommentBean cb);   

	int insertCom(CommentBean commentBean);  

	List<CommentBean> selectCom();

}