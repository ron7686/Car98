package rentcar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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

import com.google.gson.Gson;

import rentcar.model.CarTypeBean;
import rentcar.model.RentCarBean;
import rentcar.service.RentCarService;
import rentcar.service.impl.CarTypeServiceImpl;
import rentcar.service.impl.RentCarServiceImpl;

@WebServlet("/rentcar/RentCarData")
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
		HttpSession session = request.getSession(false); 
		
		// 如果舊的session物件不存在， 不要建立新的Session物件，直接傳回 null，請使用者登入
		if (session == null) {
			response.sendRedirect(response.encodeRedirectURL(
					request.getContextPath() + "/login/BSlogin.jsp"));
			return;
		}
		
		// 取出存放在session物件內的RentCarBean物件
		RentCarBean rcb = (RentCarBean)session.getAttribute("RentCarBean");
		
		// 如果找不到RentCarBean物件，就新建一個
		if (rcb == null) {
			rcb = new RentCarBean();
			// 並將此新建RentCarBean的物件放到session物件內，成為它的屬性物件
			session.setAttribute("queryRent", rcb);
			}
		
		// 1. 讀取使用者輸入查詢的資料
		String city = request.getParameter("city");
		String district = request.getParameter("district") + "區";
		
		// 2. 進行必要的資料轉換
		
		// 3. 檢查資料
		
		// 4. 進行商業邏輯運算
		RentCarService rentCarservice = new RentCarServiceImpl();
		
		// 5.依照商業邏輯運算的結果，來挑選適當的
		RequestDispatcher rd = request.getRequestDispatcher("carRent.jsp");
		rd.forward(request, response);
		return;
	}
	
}
