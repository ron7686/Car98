package talk.service;

import java.util.List;

import talk.model.CommentBean;

public interface CommentServicee {
	
	void persist(CommentBean cb);   

	int insertCom(CommentBean commentBean);  

	List<CommentBean> selectCom();

}
