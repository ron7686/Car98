package maintain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commodity.model.BidBean;
import commodity.service.BidService;
import commodity.service.impl.BidServiceImpl;

@WebServlet("/maintain/BidInsert.do")
public class Bidinster extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		Map<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		// 1. 讀取使用者輸入資料
		String bidName = request.getParameter("bidItemName");
		String priceStr = request.getParameter("bidPrice");
		String sellStr = request.getParameter("bidSelled");

		int price = 0;
		int sell = 0;
		// 2. price 資料轉換成Int
		if (priceStr == null || priceStr.trim().length() == 0) {
			errorMsg.put("price", "必須輸入價錢");
		} else {
			try {
				price = Integer.parseInt(priceStr.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("price", "價錢錯誤應該為整數");
			}
		}
		// sell 資料轉換成Int
		if (sellStr == null || sellStr.trim().length() == 0) {
			errorMsg.put("sell", "必須輸入數量");
		} else {
			try {
				sell = Integer.parseInt(sellStr.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("sell", "數量錯誤應該為整數");
			}
		}
		// 3. 檢查使用者輸入資料
		if (bidName == null || bidName.trim().length() == 0) {
			errorMsg.put("bidItemName", "品名欄必須輸入");
		}

		if (price < 0) {
			errorMsg.put("bidPrice", "價錢錯誤應該為整數");
		}
		if (sell < 0) {
			errorMsg.put("bidPrice", "數量錯誤應該為整數");
		}
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("insertBid.jsp");
			rd.forward(request, response);
			return;
		}
		// 4. 進行 Business Logic 運算
		BidService ms = new BidServiceImpl();

		try {
			BidBean bid = new BidBean(0, 36, bidName, null, price, null, sell, 0, null, null);
			ms.saveBid(bid);
		} catch (Exception e) {
			errorMsg.put("bidItemName", "儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
			e.printStackTrace();
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		HttpSession session = request.getSession();
		session.setAttribute("userIdKey", bidName);
		if (errorMsg.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/maintain/successBid.jsp");
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("insertBid.jsp");
			rd.forward(request, response);
			return;
		}
	}
}