package _01_register.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import _00_init.util.GlobalService;
import _01_register.model.MemberBean;
import _01_register.service.MemberService;

@WebServlet("/_01_reguster/change.do")
public class ChangePassword extends HttpServlet {
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";
	private Pattern pattern = null;
	private Matcher matcher = null;
	private static final long serialVersionUID = 1L;
	private static int n = 0;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Map<String, String> errorMsg = new HashMap<>();

		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息

		HttpSession session = request.getSession(false);

		String password = request.getParameter("password");
		if (password == null || password.trim().length() == 0) {
			errorMsg.put("errorMsgEmail", "密碼欄必須輸入");
		}
		String password1 = request.getParameter("password1");
		if (password1 == null || password1.trim().length() == 0) {
			errorMsg.put("errorMsgEmail", "密碼欄必須輸入");
		}

		if (password.trim().length() > 0 && password1.trim().length() > 0) {
			if (!password.trim().equals(password1.trim())) {
				errorMsg.put("errorPassword1Empty", "密碼欄必須與確認欄一致");
				errorMsg.put("errorPasswordEmpty", "*");
			}
		}
		if (errorMsg.isEmpty()) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				errorMsg.put("passwordError", "密碼至少含有一個大寫字母、小寫字母、數字與!@#$%!^'\"等四組資料組合而成，且長度不能小於八個字元");
			}
		}

		if (!errorMsg.isEmpty()) {
//			Set<String> set = errorMsg.keySet();
//			for(String s : set) {
//				System.out.println(s);
//			}
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("/management/user.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			ServletContext sc = getServletContext();
			WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
			MemberService service = ctx.getBean(MemberService.class);

			if (errorMsg.isEmpty()) {
				MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
				if (errorMsg.isEmpty()) {
					password1 = GlobalService.getMD5Endocing(GlobalService.encryptString(password1));
					mb.setPassword(password1);
					n = service.updateUserData(mb);
				}

				if (n == 1) {
					session.setAttribute("MemberBean", mb);
//			response.sendRedirect("../index.jsp");
//			response.sendRedirect("/java014_01_Car98/register/verify.jsp");
					response.sendRedirect("/java014_01_Car98/management/user.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("/management/user.jsp");
					return;
				}
			}
//			if (!errorMsg.isEmpty()) {
//				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
//				RequestDispatcher rd = request.getRequestDispatcher("/management/user.jsp");
//				rd.forward(request, response);
//				return;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/management/user.jsp");
			rd.forward(request, response);
		}
	}
}
