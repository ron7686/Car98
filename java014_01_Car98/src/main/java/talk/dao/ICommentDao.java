package talk.dao;

import talk.model.CommentBean;

public interface ICommentDao {

	void persist(CommentBean cb);

	int insertCom(CommentBean commentBean);

}