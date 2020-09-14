package talk.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import talk.model.CommentBean;
import talk.service.ICommentService;
import talk.service.Impl.CommentService;

@WebServlet("/forum/comment.do")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsgKey", errorMessage);
		request.setCharacterEncoding("UTF-8");
		Integer ComID = null;
		String Comtext = request.getParameter("comments");
		Integer postId = 123;
		Integer memId = 36;
		Integer comLike = 6;
		if (Comtext == null || Comtext.trim().length() == 0) {
			errorMessage.put("TextEmptyError", "請輸入內文");
		}
		if (errorMessage.isEmpty()) {
			CommentBean cb = new CommentBean(postId, memId, Comtext, new Date(), comLike);
			try {
//				ICommentService service=new CommentService();

				ServletContext sc = getServletContext();
				WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
				ICommentService service = ctx.getBean(ICommentService.class);

				service.persist(cb);
				service.insertCom(cb);
				request.setAttribute("CommentBean", cb);
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
