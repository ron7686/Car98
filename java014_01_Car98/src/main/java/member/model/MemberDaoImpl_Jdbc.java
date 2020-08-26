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

public class MemberDaoImpl_Jdbc implements MemberDao {
	private DataSource ds = null;
	private Connection con = null;
	public MemberDaoImpl_Jdbc(String driver) {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup(driver);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_BY_ID = "select Memid, id, email, password, "
												+ "name, phone, birth, sex, headPic, leves,"
												+ "MeCreate, LoginTime "
												+ "from mem where Memid=?";
	@Override
	public MemberBean queryMember(String id) {
		MemberBean mb = null;
		try (
				Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
			)
		{
			stmt.setString(1, id);
			try(
					ResultSet rs = stmt.executeQuery(); 
			){
				if(rs.next()) {
					mb = new MemberBean();
					mb.setMemId(rs.getInt("Memid"));
					mb.setId(rs.getString("id"));
					mb.setEmail(rs.getString("Email"));
					mb.setPassword(rs.getString("password"));
					mb.setName(rs.getString("name"));
					mb.setPhone(rs.getString("phone"));
					mb.setBirth(rs.getDate("Birth"));
					mb.setSex(rs.getString("sex"));
					mb.setHeadPic(rs.getBlob("HeadPic"));
//					mb.setLevels(rs.getInt("Levels"));
//					mb.setMeCreate(rs.getDate("MeCreate"));
//					mb.setLoginTime(rs.getTimestamp("LoginTime"));
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return mb;
	}
	private static final String select_All = "select custId, id, email, password, "
											+ "name, phone, birth, sex, mheadPic, leves, "
											+ "MeCreate, LoginTime "
											+ "from mem where custId=?";
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
				result.setMemId(rs.getInt("custid"));
				result.setId(rs.getString("id"));
				result.setEmail(rs.getString("Email"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setPhone(rs.getString("phone"));
				result.setBirth(rs.getDate("Birth"));
				result.setSex(rs.getString("sex"));
				result.setHeadPic(rs.getBlob("HeadPic"));
//				result.setLevels(rs.getInt("Levels"));
//				result.setMeCreate(rs.getDate("MeCreate"));
//				result.setLoginTime(rs.getTimestamp("LoginTime"));
				selectAll.add(result);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return selectAll;
	}
	
	private static final String INSERT = "INSERT INTO mem (MemId, ID, Email, PASSWORD, NAME, Phone, Birth, Sex, HeadPic, Levels,MeCreate,LoginTime)\r\n" + 
			"VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, 2, CURDATE(),NOW())";

	public int saveMember(MemberBean bean)  {
		int n = 0;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT);
		) {
			ps.setString(1, bean.getId());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getName());
			ps.setString(5, bean.getPhone());
			ps.setDate(6, bean.getBirth());
			ps.setString(7, bean.getSex());
			ps.setBlob(8, bean.getHeadPic());
//			ps.setInt(9, bean.getLevels());
//			ps.setDate(10, bean.getMeCreate());
//			ps.setTimestamp(11, bean.getLoginTime());
			n = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#saveMember()發生例外:"
			+e.getMessage());
		}
		return n;
	}

	@Override
	public boolean idExists(String id) {
		boolean exists = false;
		String sql = "select * from mem where email = ?";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			)
		{
			ps.setString(1,id);
			try(
				ResultSet rs = ps.executeQuery();
				){
				if(rs.next()) {
					exists=true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("MemberDaoImp_Jdbc類別idExists()發生例外:"
					+e.getMessage());
		}
		return exists;
	}

	@Override
	public MemberBean checkIdPassword(String email, String password) {
		MemberBean mb = null;
		String sql ="select * from mem where email = ? and password = ?";
		try(
			Connection conn =ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			){
			ps.setString(1,email);
			ps.setString(2, password);
			try(
					ResultSet rs = ps.executeQuery();
				){
				if(rs.next()) {
					mb = new MemberBean();
					mb.setMemId(rs.getInt("memId"));
					mb.setMemId(rs.getInt("custid"));
					mb.setId(rs.getString("id"));
					mb.setEmail(rs.getString("Email"));
					mb.setPassword(rs.getString("password"));
					mb.setName(rs.getString("name"));
					mb.setPhone(rs.getString("phone"));
					mb.setBirth(rs.getDate("Birth"));
					mb.setSex(rs.getString("sex"));
					mb.setHeadPic(rs.getBlob("HeadPic"));
//					mb.setLevels(rs.getInt("Levels"));
//					mb.setMeCreate(rs.getDate("MeCreate"));
//					mb.setLoginTime(rs.getTimestamp("LoginTime"));
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#checkIDPassword()發生SQL例外: " 
					+ e.getMessage());
		}
		return mb;
	}

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}
}
