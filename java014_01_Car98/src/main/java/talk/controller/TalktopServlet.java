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
		HttpSession session = request.getSession();
		
		session.setAttribute("pageNo", pageNo);
		try {
			pageNo=Integer.valueOf(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
			pageNo = 1;
		}
		TalkService ts=new TalkService();
		List<TalkBean> li=ts.select(pageNo);
		session.setAttribute("abean", li);
		RequestDispatcher rd=request.getRequestDispatcher("/forum/carTalk.jsp");
		rd.forward(request, response);
		return;
		
	}
}
