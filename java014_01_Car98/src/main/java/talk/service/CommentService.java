package talk.service;

import java.util.Date;
import java.util.List;

import talk.model.CommentBean;

public interface CommentService {

	void persist(CommentBean cb);

	int insertCom(CommentBean commentBean);

	List<CommentBean> selectCom(Integer postId);

	int updateMemCom(String comText, Date comTime, Integer memId, Integer postId, Integer comId);

	int updateComByPk(CommentBean commentBean);

	int deleteComByPk(Integer comId);
	
	CommentBean selectComByPk(Integer comId);
}
