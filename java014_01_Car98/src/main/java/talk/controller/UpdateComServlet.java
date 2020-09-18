package talk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import talk.model.CommentBean;
import talk.model.TalkBean;
import talk.service.TalkService;
import talk.service.Impl.CommentServiceImpl;


@WebServlet("/forum/updateCom.do")
public class UpdateComServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsgKey", errorMessage);
		request.setCharacterEncoding("UTF-8");
		String comIdStr = request.getParameter("comId");
		Integer comId = Integer.valueOf(comIdStr) ; 
		CommentBean commentBean = null;
		try {
			CommentServiceImpl service = new CommentServiceImpl();
		    int n = 0;
			n = service.updateComByPk(commentBean);
			RequestDispatcher rd = request.getRequestDispatcher("/forum/talktalk.jsp");
			rd.forward(request, response);
			return;
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
