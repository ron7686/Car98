package talk.dao;

import java.util.Date;
import java.util.List;

import talk.model.CommentBean;

public interface CommentDao {

	void persist(CommentBean commentBean);   

	int insertCom(CommentBean commentBean);  

	List<CommentBean> selectCom(); 
	
	int updateMemCom(String comText, Date comTime, Integer memId, Integer postId, Integer comId);
	
    int updateComByPk(CommentBean commentBean);
    
    int deleteComByPk(Integer comId);
    
    
	

	


}