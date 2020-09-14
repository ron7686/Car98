package talk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import talk.model.TalkBean;
import talk.service.TalkService;

@WebServlet("/TalkTalkServlet")
public class TalkTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int postID;
		try {
			postID=Integer.valueOf(request.getParameter("postID"));
		} catch (NumberFormatException e) {
			postID = 1;
		}
		System.out.println(postID);
		session.setAttribute("postID", postID);
		TalkService ts=new TalkService();
		TalkBean tb=ts.selectOne(postID);
		session.setAttribute("tbean", tb);
		
		RequestDispatcher rd=request.getRequestDispatcher("/forum/talktalk.jsp");
		rd.forward(request, response);
		return;
		
		
	}

}
