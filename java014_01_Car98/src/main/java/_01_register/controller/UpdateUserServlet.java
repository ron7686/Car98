package _01_register.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import _00_init.util.GlobalService;
import _01_register.model.MemberBean;
import _01_register.service.MemberService;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/_01_register/update.do")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 
	// 設定密碼欄位必須由大寫字母、小寫字母、數字與 !@#$%!^'" 等四組資料組合而成，且長度不能小於八個字元
	// 
//	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";
//	private Pattern pattern = null;
//	private Matcher matcher = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession(false);
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息

		String memberId = "";
		String name = "";
		String phone = "";
		String fileName = "";
		String sex = "";

		long sizeInBytes = 0;
		InputStream is = null;
		// 取出HTTP multipart request內所有的parts
		Collection<Part> parts = request.getParts();
//		GlobalService.exploreParts(parts, request);
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);

				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {

				} else {
					// 取出圖片檔的檔名
					fileName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (fileName != null && fileName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} 
//					else {
//						errorMsg.put("errPicture", "必須挑選圖片檔");
//					}
				}
			}
			// 2. 進行必要的資料轉換
			// (無)
			// 3. 檢查使用者輸入資料
			memberId = request.getParameter("memberId");
			
//			password = request.getParameter("password");
//			
//			password1 = request.getParameter("password1");
//			
//			if (password.trim().length() > 0 && password1.trim().length() > 0) {
//				if (!password.trim().equals(password1.trim())) {
//					errorMsg.put("errorPassword1Empty", "密碼欄必須與確認欄一致");
//					errorMsg.put("errorPasswordEmpty", "*");
//				}
//			}
			sex = request.getParameter("gridRadios");
			name = request.getParameter("name");	
			phone = request.getParameter("phone");

		

		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}
		// 如果有錯誤
//		if (errorMsg.isEmpty()) {
//			pattern = Pattern.compile(PASSWORD_PATTERN);
//			matcher = pattern.matcher(password);
//			if ( !matcher.matches() ) {
//				errorMsg.put("passwordError", "密碼至少含有一個大寫字母、小寫字母、數字與!@#$%!^'\"等四組資料組合而成，且長度不能小於八個字元");
//			}
//		}
		// 如果有錯誤
//		if (!errorMsg.isEmpty()) {
////			Set<String> set = errorMsg.keySet();
////			for(String s : set) {
////				System.out.println(s);
////			}
//			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
//			RequestDispatcher rd = request.getRequestDispatcher("/management/user.jsp");
//			rd.forward(request, response);
//			return;
//		}
		try {
			// 4. 產生MemberDao物件，以便進行Business Logic運算
			// MemberDaoImpl_Jdbc類別的功能：
			// 1.檢查帳號是否已經存在，已存在的帳號不能使用，回傳相關訊息通知使用者修改
			// 2.若無問題，儲存會員的資料
//			MemberService service = new MemberServiceImpl_Hibernate();
			ServletContext sc = getServletContext();
			WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
			MemberService service = ctx.getBean(MemberService.class);
			
			

				Blob blob = null;
				if (is != null) {
					blob = GlobalService.fileToBlob(is, sizeInBytes);
				}
				
				
				// 將所有會員資料封裝到MemberBean(類別的)物件
				MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
				
				mb.setName(name);
				if(blob!=null) {
					mb.setHeadPic(blob);					
				}
				mb.setId(memberId);
				mb.setPhone(phone);
				mb.setSex(sex);
				// 呼叫MemberDao的saveMember方法
				int n = service.updateUserData(mb);
				if (n == 1) {
//					msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
					session.setAttribute("MemberBean", mb);
//					response.sendRedirect("../index.jsp");
					response.sendRedirect("/java014_01_Car98/register/verify.jsp");
//					RequestDispatcher rd = request.getRequestDispatcher("/register/verify.jsp");
//					rd.forward(request, response);
					return;
				} else {
					errorMsg.put("errorIdDup", "新增此筆資料有誤(RegisterServlet)");
				}
			
			
			// 5.依照 Business Logic 運算結果來挑選適當的畫面
//			if (!errorMsg.isEmpty()) {
//				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
//				RequestDispatcher rd = request.getRequestDispatcher("/management/user.jsp");
//				rd.forward(request, response);
//				return;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/management/user.jsp");
			rd.forward(request, response);
		}
	}
}