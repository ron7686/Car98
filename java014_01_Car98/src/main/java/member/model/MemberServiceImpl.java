package member.model;

public class MemberServiceImpl implements MemberService {
	MemberDaoImpl_Jdbc dao = null;
	
	public MemberServiceImpl(String dbString) {
		dao = new MemberDaoImpl_Jdbc(dbString);
	}
	
	public int saveMember(MemberBean bean) {
		return dao.saveMember(bean);
	}

	@Override
	public boolean idExists(String id) {
		return dao.idExists(id);
	}

	@Override
	public MemberBean queryMember(String id) {
		return dao.queryMember(id);
	}

	@Override
	public MemberBean checkIdPassword(String userId, String password) {
		MemberBean mb = dao.checkIdPassword(userId, password);
		return mb;
	}
}
