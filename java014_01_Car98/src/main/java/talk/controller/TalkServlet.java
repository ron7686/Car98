package talk.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import talk.dao.TalkDao;
import talk.model.TalkBean;
import talk.service.TalkService;

@WebServlet("/forum/talk.do")
public class TalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> errorMessage=new HashMap<>();
		request.setAttribute("ErrorMsgKey", errorMessage);
		request.setCharacterEncoding("UTF-8");
		Integer PostID=null;
		String PostTitle=request.getParameter("title");
		if(PostTitle==null||PostTitle.trim().length()==0) {
			errorMessage.put("TitleEmptyError", "請輸入標題");
		}
		String PostText=request.getParameter("text");
		if(PostText==null||PostText.trim().length()==0) {
			errorMessage.put("TextEmptyError", "請輸入內文");
		}
		if(errorMessage.isEmpty()) {
			TalkBean tb=new TalkBean(PostID, PostTitle, PostText);
			try {
				TalkService service=new TalkService();
				service.persist(tb);
				request.setAttribute("TalkBean", tb);
				RequestDispatcher rd=request.getRequestDispatcher("/forum/talktalk.jsp");
				rd.forward(request, response);
				return;
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/forum/content_1.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
