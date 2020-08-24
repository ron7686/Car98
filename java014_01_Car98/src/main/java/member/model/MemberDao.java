package member.model;

import java.sql.Connection;

public interface MemberDao {
	public boolean idExists(String id);

	public int saveMember(MemberBean mb) ;
	
	public MemberBean queryMember(String id);
	
	public MemberBean checkIdPassword(String userId, String password);

	public void setConnection(Connection con);
}
