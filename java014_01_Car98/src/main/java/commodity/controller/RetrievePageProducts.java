package commodity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/commdity/controller/DisplayPageProducts")
// 本控制器負責進行必要的前置作業，以便Dao取回某一頁的商品資料
public class RetrievePageProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		
		RequestDispatcher rd = request.getRequestDispatcher("listBid.jsp");
		rd.forward(request, response);
		return;

	}
}