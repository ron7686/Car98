package member.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	DataSource ds = null;
	public MemberDao(String driver) {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup(driver);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_ID = "select custId, id, email, password, "
												+ "name, phone, birth, sex, mheadPic, leves"
												+ "from member where custId=?";
	public MemberBean select(String id) {
		MemberBean result = null;
		try (
				Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
			)
		{
			stmt.setString(0, id);
			try(
					ResultSet rs = stmt.executeQuery(); 
			){
				if(rs.next()) {
					result = new MemberBean();
					result.setCustId(rs.getInt("custid"));
					result.setId(rs.getString("id"));
					result.setEmail(rs.getString("Email"));
					result.setPassword(rs.getString("password"));
					result.setName(rs.getString("name"));
					result.setPhone(rs.getString("phone"));
					result.setBirth(rs.getDate("Birth"));
					result.setSex(rs.getString("sex"));
					result.setHeadPic(rs.getBlob("HeadPic"));
					result.setPassword(rs.getString("password"));
					result.setLevels(rs.getInt("Levels"));
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static final String select_All = "select custId, id, email, password, "
											+ "name, phone, birth, sex, mheadPic, leves"
											+ "from member where custId=?";
	public List<MemberBean> selectAll() {
		List <MemberBean> selectAll = new ArrayList<>();
		try(
				Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(select_All);
				ResultSet rs = stmt.executeQuery();
			){
			while(rs.next()) {
				MemberBean result = new MemberBean();
				result = new MemberBean();
				result.setCustId(rs.getInt("custid"));
				result.setId(rs.getString("id"));
				result.setEmail(rs.getString("Email"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setPhone(rs.getString("phone"));
				result.setBirth(rs.getDate("Birth"));
				result.setSex(rs.getString("sex"));
				result.setHeadPic(rs.getBlob("HeadPic"));
				result.setPassword(rs.getString("password"));
				result.setLevels(rs.getInt("Levels"));
				selectAll.add(result);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return selectAll;
	}
	
	private static final String INSERT = "Insert into member "
			+ "(CustID, ID, Email, Password, Name, Phone, Birth, Sex, HeadPic, Levels) "
			+ "values (0, ?, ?, ?, ?, ?, ?, ?, ?, 1)";

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
		) {
			stmt.setString(1, bean.getId());
			stmt.setString(2, bean.getEmail());
			stmt.setString(3, bean.getPassword());
			stmt.setString(4, bean.getName());
			stmt.setString(5, bean.getPhone());


			java.util.Date temp = bean.getBirth();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(5, someTime);
			} else {
				stmt.setDate(5, null);
			}
			stmt.setString(6, bean.getSex());
			Blob b = bean.getHeadPic();
			if(b!=null) {
				stmt.setBlob(7, bean.getHeadPic());
			}else {
				Blob blobNull = null;
				stmt.setBlob(7, blobNull);
			}

			stmt.setInt(8, bean.getLevels());
		} 
		return result;
	}
}
