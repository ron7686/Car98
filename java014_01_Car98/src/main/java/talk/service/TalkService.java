package talk.service;

import java.util.List;

import talk.dao.TalkDao;
import talk.model.TalkBean;

public class TalkService {

	TalkDao dao;
	
	public TalkService() {
		dao=new TalkDao();
	}
	
	public void persist(TalkBean tb) {
		dao.persist(tb);
	}
	
	public List<TalkBean> select(){
		return dao.getAll();
	}
	
	public List<TalkBean> getAllTalk(){
		return select();
	}
}
