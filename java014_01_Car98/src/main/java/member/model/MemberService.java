package member.model;

import java.sql.SQLException;
import java.util.List;



public class MemberService {
	MemberDao dao = null;
	
	public MemberService(String dbString) {
		dao = new MemberDao(dbString);
	}	

	public MemberBean select(String id) {
		return dao.select(id);
	}
	
	public List<MemberBean> select() {
		return dao.selectAll();
	}
	
	public MemberBean insertMember(MemberBean bean) throws SQLException {
		return dao.insertMember(bean);
	}
}
