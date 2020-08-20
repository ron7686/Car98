package member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import member.model.*;

@WebServlet(urlPatterns="/member/controller/MemberServlet",
			initParams= {
					@WebInitParam(
							name="driver",
							value="java:comp/env/jdbc/Car98")
			})
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String dbDriver = null;   
    public MemberServlet() {
        super();
        
    }
    
    public void init() {
    	dbDriver = getInitParameter("driver");
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map <String,String> ErrorMap = new HashMap<>();
		session.setAttribute("ErrorMessage",ErrorMap);
		
		request.setCharacterEncoding("UTF-8");
		
		
		String id = request.getParameter("id");
		if(id==null || id.trim().length() == 0) {
			String idError = "請輸入暱稱";
			ErrorMap.put("idError",idError);
		}
		
		String email = request.getParameter("Email");
		if(email==null||email.trim().length()==0) {
			String emailError = "請輸入email(帳號)";
			ErrorMap.put("emailError",emailError);
		}
		
		String password = request.getParameter("password");
		if (password == null || password.trim().length() == 0) {
			ErrorMap.put("passwordError", "密碼欄必須輸入");
		}
		
		String name = request.getParameter("name");
		if(name==null || name.trim().length()==0) {
			String nameError = "請輸入姓名";
			ErrorMap.put("nameError",nameError);
		}
		
		String phone = request.getParameter("phone");
		if(phone ==null||phone.trim().length()==0) {
			String phoneError = "請輸入電話號碼";
			ErrorMap.put("phoneError",phoneError);
		}
		
		String date = request.getParameter("birth");
		java.util.Date birth = null;
		if(date != null && date.trim().length() > 0) {
			try {
				birth = java.sql.Date.valueOf(date);
			} catch (Exception e) {
				ErrorMap.put("birthError","生日格式錯誤");
			}
		}
		
		String sex = request.getParameter("sex");
		if(sex ==null && sex.trim().length()==0) {
			String sexError = "請輸入性別";
			ErrorMap.put("sexError", sexError);
		}
		Blob headPic = null;
		String headPictemp = request.getParameter("headPic");
		try {
			headPic = new SerialBlob(headPictemp.getBytes("UTF-8"));
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String leveltemp = request.getParameter("levels");
		Integer levels = Integer.parseInt(leveltemp.trim());
		
		if (!ErrorMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("???");
			rd.forward(request, response);
			return;
		}
		
		MemberBean mb = new MemberBean(0, id, email, password, 
				name, phone, birth, sex, headPic, levels);
		try {
			MemberService service = new MemberService(dbDriver);
			service.select();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
