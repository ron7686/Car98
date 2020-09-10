package talk.service;

import java.util.List;

import talk.model.TalkBean;

public interface ITalkService {

	void persist(TalkBean tb);

	List<TalkBean> select(int page);

	List<TalkBean> getAllTalk(int page);

}