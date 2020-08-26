package member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import member.model.MemberBean;
import member.model.MemberService;
import member.model.MemberServiceImpl;

@MultipartConfig(location="", fileSizeThreshold = 5 * 1024 * 1024,
			maxFileSize= 1024 * 1024 * 500, maxRequestSize= 1024 *1024 *500 *5)

@WebServlet(urlPatterns="/member/register.do",
			initParams= {
					@WebInitParam(
							name="driver",
							value="java:comp/env/jdbc/CarDB")
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
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息

		String memberId = "";
		String name = "";
		String email = "";
		String password = "";
		String phone = "";
		String sex = "";
		long sizeInBytes = 0;
		
		memberId = request.getParameter("memberId");
		email = request.getParameter("memberEmail");
		password = request.getParameter("memberPassword");
		name = request.getParameter("memberName");
		phone = request.getParameter("memberPhone");
		
		String date = request.getParameter("memberBirth");
		Date birth = null;
		if(date != null && date.trim().length() > 0) {
			try {
				birth = Date.valueOf(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sex = request.getParameter("gridRadios");
		Blob blob = null;
		
		
				MemberService service = new MemberServiceImpl(dbDriver);
				MemberBean mem = new MemberBean(0, memberId,email,password,name,
						phone, birth,sex, blob);
				// 呼叫MemberDao的saveMember方法
				int n = service.saveMember(mem);
				if (n == 1) {
					msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
					response.sendRedirect("../index.jsp");
					return;
				}
			// 5.依照 Business Logic 運算結果來挑選適當的畫面
			if (!errorMsg.isEmpty()) {
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}
		
	}
}
