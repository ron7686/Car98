package talk.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import talk.model.CommentBean;
import talk.service.CommentService;

@WebServlet("/forum/talk/comment.do")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> errorMessage=new HashMap<>();
		request.setAttribute("ErrorMsgKey", errorMessage);
		request.setCharacterEncoding("UTF-8");
		Integer ComID=null;		
	    String Comtext=request.getParameter("comments");
	    Integer postId=123;
	    Integer memId=1;
	    Integer comLike=6;
		if(Comtext==null||Comtext.trim().length()==0) {
			errorMessage.put("TextEmptyError", "請輸入內文");
		}
		if(errorMessage.isEmpty()) {
			CommentBean cb=new CommentBean(postId,memId,Comtext,new Date(),comLike);
			try {
				CommentService service=new CommentService();
				service.persist(cb);
				service.insertCom(cb);
				request.setAttribute("CommentBean", cb);
				RequestDispatcher rd=request.getRequestDispatcher("/forum/talktalk.jsp");
				rd.forward(request, response);
				return;
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/forum/talktalk.jsp");
			rd.forward(request, response);
			return;
		}
	}
	

}
