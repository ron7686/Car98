package _01_register.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import _00_init.util.DBService;
import _00_init.util.GlobalService;
import _01_register.dao.MemberDao;
import _01_register.model.MemberBean;
// 本類別使用為標準的JDBC技術來存取資料庫。
public class MemberDaoImpl_Jdbc implements MemberDao {

	private DataSource ds = null;
	private Connection conn = null;
	
	public MemberDaoImpl_Jdbc() {
//		System.out.println("DBService.JNDI_DB_NAME=" + DBService.JNDI_DB_NAME);
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
	// 儲存MemberBean物件，將參數mb新增到Member表格內。
	public int saveMember(MemberBean mb) {
		String sql = "INSERT INTO mem "
				+ "(MemId, Email, PASSWORD, NAME, ID, Phone, Birth, "
				+ "Sex, HeadPic,fileName,Levels,MeCreate,LoginTime) " + 
				"VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, 2, CURDATE(),NOW())";
		int n = 0;
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
//			ps.setInt(1, mb.getMemId());
			ps.setString(1, mb.getEmail());
			ps.setString(2, mb.getPassword());
			ps.setString(3, mb.getName());
			ps.setString(4, mb.getId());
			ps.setString(5, mb.getPhone());
			ps.setDate(6, mb.getBirth());
			
			ps.setString(7, mb.getSex());
			ps.setBlob(8, mb.getHeadPic());
			ps.setString(9, mb.getFileName());
//			ps.setInt(12, mb.getLevels());
//			ps.setDate(13, mb.getMeCreate());
//			ps.setDate(14, mb.getLoginTime());
			n = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#saveMember()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@Override
	public boolean idExists(String id) {
		boolean exist = false;
		String sql = "SELECT * FROM mem WHERE email = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#idExists()發生例外: " 
					+ ex.getMessage());
		}
		return exist;
	}
	
	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public MemberBean queryMember(String id) {
		MemberBean mb = null;
		String sql = "SELECT * FROM mem WHERE memId = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setMemId(rs.getInt("memId"));
					mb.setEmail(rs.getString("email"));
					mb.setPassword(rs.getString("password"));
					mb.setName(rs.getString("name"));
					mb.setId(rs.getString("id"));
					mb.setPhone(rs.getString("phone"));
					mb.setBirth(rs.getDate("birth"));
					mb.setSex(rs.getString("sex"));
					mb.setHeadPic(rs.getBlob("HeadPic"));
					mb.setFileName(rs.getString("filename"));
					mb.setLevels(rs.getInt("levels"));
					mb.setMeCreate(rs.getDate("meCreate"));
					mb.setLoginTime(rs.getDate("loginTime"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " 
					+ ex.getMessage());
		}
		return mb;
	}
	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	@Override
	public MemberBean checkIdPassword(String userId, String password) {
		MemberBean mb = null;
		String sql = "SELECT * FROM mem m WHERE m.email = ? and m.password = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, userId);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setMemId(rs.getInt("memId"));
					mb.setEmail(rs.getString("email"));
					mb.setPassword(rs.getString("password"));
					mb.setName(rs.getString("name"));
					mb.setId(rs.getString("id"));
					mb.setPhone(rs.getString("phone"));
					mb.setBirth(rs.getDate("birth"));
					mb.setSex(rs.getString("sex"));
					mb.setHeadPic(rs.getBlob("HeadPic"));
					mb.setFileName(rs.getString("filename"));
					mb.setLevels(rs.getInt("levels"));
					mb.setMeCreate(rs.getDate("meCreate"));
					mb.setLoginTime(rs.getDate("loginTime"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#checkIDPassword()發生SQL例外: " 
					+ ex.getMessage());
		}
		return mb;
	}

	@Override
	public void setConnection(Connection conn) {
        this.conn = conn;
	}
	
	// 更新使用者登入的時間
	@Override
	public int updateLoginTime(String id) {
		int n = 0;
		String sql = "UPDATE mem set LoginTime = now() where email= ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, id);
			n = ps.executeUpdate();
		
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#updateLoginTime()發生SQL例外: " 
					+ ex.getMessage());
		}
		return n;
	}
	
}
