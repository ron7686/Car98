package _01_register.service;

import _01_register.model.MemberBean;

public interface MemberService {
	boolean idExists(String id);
	int saveMember(MemberBean mb);
	MemberBean queryMember(Integer id);
	MemberBean checkIdPassword(String userId, String password) ;
	int updateLoginTime (String id);
}
