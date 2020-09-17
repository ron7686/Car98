package talk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import talk.model.CommentBean;
import talk.service.Impl.CommentServiceImpl;

@WebServlet("/forum/comment.do")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int floor=2;
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsgKey", errorMessage);
		request.setCharacterEncoding("UTF-8");
		Integer comId = null;
		String comText = request.getParameter("comments");
		Integer postId = 1;
		Integer memId = 36;
		Integer comLike = 6;
		if (comText == null || comText.trim().length() == 0) {
			errorMessage.put("TextEmptyError", "請輸入內文");
		}
		if (errorMessage.isEmpty()) {
			CommentBean cb = new CommentBean(postId, comText, new Date(), comLike);
			try {
				CommentServiceImpl service=new CommentServiceImpl();
				service.insertCom(cb);
				List<CommentBean> resultList = new ArrayList<>();
				resultList = service.selectCom();
				request.setAttribute("CommentBean", resultList);
				request.setAttribute("floor", floor);
				RequestDispatcher rd = request.getRequestDispatcher("/forum/talktalk.jsp");
				rd.forward(request, response);
				return;
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/forum/talktalk.jsp");
			rd.forward(request, response);
			return;
		}
		
		
	}

}
