package talk.dao;

import java.util.List;

import talk.model.TalkBean;

public interface ITalkDao {

	void persist(TalkBean tb);

	List<TalkBean> getAll(int page);

}