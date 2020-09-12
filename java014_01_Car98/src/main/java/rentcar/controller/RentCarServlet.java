package rentcar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.model.CarTypeBean;
import rentcar.model.RentCarBean;
import rentcar.service.RentCarService;
import rentcar.service.impl.CarTypeServiceImpl;
import rentcar.service.impl.RentCarServiceImpl;

@WebServlet("/rent/RentCarServlet")
public class RentCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarTypeServiceImpl cts = new CarTypeServiceImpl();
		Collection<CarTypeBean> ctb = cts.getCarTypeData();

		Gson gson = new Gson();
		String carJsonString = gson.toJson(ctb);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(carJsonString);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//先取出session物件
		HttpSession session = request.getSession(); 
//		
//		// 如果session物件不存在， 不要建立新的Session物件，直接傳回 null，請使用者登入
//		if (session == null) {
//			response.sendRedirect(response.encodeRedirectURL(
//					request.getContextPath() + "BSlogin.jsp"));
//			return;
//		}
		
		RentCarService rentCarservice = new RentCarServiceImpl();
		
//		查詢rentcar全部
		List<RentCarBean> rentCarBean = rentCarservice.getAllRentCars();
		
		//這裡建立功能：將查詢的結果，可能轉成緯經度和GSON，然後再顯示在地圖上
		
//		session.setAttribute("rcBean", rentCarBean);
//		RequestDispatcher rd = request.getRequestDispatcher("test_allrentcar.jsp");
		
		
//		查詢rentcar單筆
//		RentCarBean rentcarbean = rentCarservice.getRentCar();
//		session.setAttribute("rcbean", rentcarbean);
//		RequestDispatcher rd = request.getRequestDispatcher("test_rentcar.jsp");
//		
//		rd.forward(request, response);
//		return;
		
//		查詢cartype全部
//		CarTypeServiceImpl cts = new CarTypeServiceImpl();
//		
//		Collection<CarTypeBean> ctb = cts.getCarTypeData();
//		session.setAttribute("CarTypeData", ctb);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("carRent.jsp");
//		rd.forward(request, response);
//		return;
	}
	
}
