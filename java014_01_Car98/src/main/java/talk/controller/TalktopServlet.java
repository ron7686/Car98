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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TalkService ts=new TalkService();
		List<TalkBean> li=ts.select();
		session.setAttribute("abean", li);
		System.out.println(li.toString() + "123");
		RequestDispatcher rd=request.getRequestDispatcher("/forum/carTalk.jsp");
		rd.forward(request, response);
		return;
		
	}
}
