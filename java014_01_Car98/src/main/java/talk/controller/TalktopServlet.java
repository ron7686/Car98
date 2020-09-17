package talk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01_register.model.MemberBean;
import talk.model.TalkBean;
import talk.service.TalkService;

@WebServlet("/forum/talktop.do")
public class TalktopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		
		try {
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
			pageNo = 1;
		}
		session.setAttribute("pageNo", pageNo);
		TalkService ts=new TalkService();
		int lastPage=ts.lastpage();
//		ServletContext sc=getServletContext();
//		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(sc);
//		ITalkService ts=ctx.getBean(ITalkService.class);

		List<TalkBean> li=ts.select(pageNo);
		session.setAttribute("lastPage", lastPage);
		session.setAttribute("abean", li);
		session.setAttribute("memberBean", mb);
		
		RequestDispatcher rd=request.getRequestDispatcher("/forum/carTalk.jsp");
		rd.forward(request, response);
		return;
	}
}
