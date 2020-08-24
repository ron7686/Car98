package member.model;

import java.sql.SQLException;
import java.util.List;



public class MemberService {
	MemberDaoImpl_Jdbc dao = null;
	
	public MemberService(String dbString) {
		dao = new MemberDaoImpl_Jdbc(dbString);
	}	

	public MemberBean select(String id) {
		return dao.queryMember(id);
	}
	
	public List<MemberBean> select() {
		return dao.selectAll();
	}
	
	public MemberBean insertMember(MemberBean bean) throws SQLException {
		return dao.insertMember(bean);
	}
}
