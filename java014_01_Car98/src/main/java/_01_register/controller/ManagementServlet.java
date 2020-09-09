package _01_register.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import _01_register.model.MemberBean;
import _01_register.service.MemberService;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/_01_register/management.do")
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼

		HttpSession session = request.getSession(false);

		try {
			// 讀取瀏覽器傳送來的主鍵
			MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			// MemberService 是介面 = MemberServiceImpl() 類別
			// 針對介面去寫程式，很重要，Spring也會再提到。

//			MemberService memberService = new MemberServiceImpl_Hibernate();
			ServletContext sc = getServletContext();
			WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
			MemberService memberService = ctx.getBean(MemberService.class);
			MemberBean bean = memberService.queryMember(mb.getMemId());
			session.setAttribute("memberBean", bean);
			response.sendRedirect("/java014_01_Car98/management/user.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}