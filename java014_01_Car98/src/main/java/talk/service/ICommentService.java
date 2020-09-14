package talk.service;

import talk.model.CommentBean;

public interface ICommentService {

	void persist(CommentBean cb);

	int insertCom(CommentBean commentBean);

}