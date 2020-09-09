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

@WebServlet("/_01_register/register.do")
public class RegisterServletMP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 會員預設權限
	private final Integer LEVELS = 1;
	// 
	// 設定密碼欄位必須由大寫字母、小寫字母、數字與 !@#$%!^'" 等四組資料組合而成，且長度不能小於八個字元
	// 
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";
	private Pattern pattern = null;
	private Matcher matcher = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息

		String memberId = "";
		String password = "";
		String password1 = "";
		String name = "";
		String email = "";
		String phone = "";
		String fileName = "";
		String sex = "";
		String birth ="";
		Date date = null;
		Date currentDate = new Date(System.currentTimeMillis());
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
			if (memberId == null || memberId.trim().length() == 0) {
				errorMsg.put("errorIdEmpty", "暱稱欄必須輸入");
			}
			password = request.getParameter("password");
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("errorMsgEmail", "密碼欄必須輸入");
			}
			password1 = request.getParameter("password1");
			if (password1 == null || password1.trim().length() == 0) {
				errorMsg.put("errorPassword1Empty", "密碼確認欄必須輸入");
			}
			if (password.trim().length() > 0 && password1.trim().length() > 0) {
				if (!password.trim().equals(password1.trim())) {
					errorMsg.put("errorPassword1Empty", "密碼欄必須與確認欄一致");
					errorMsg.put("errorPasswordEmpty", "*");
				}
			}
			name = request.getParameter("name");
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("errorName", "姓名欄必須輸入");
			}
			
			birth = request.getParameter("birth");
			
			if(birth!=null && birth.trim().length()>0) {
				try {
					date = Date.valueOf(birth);
				}catch(Exception e) {
//					e.printStackTrace();
					errorMsg.put("errorBirth","生日欄格式錯誤");
				}			
			}
			email = request.getParameter("email");
			if (email == null || email.trim().length() == 0) {
				errorMsg.put("errorEmail", "E-mail帳號必須輸入");
			}
			phone = request.getParameter("phone");
			if (phone == null || phone.trim().length() == 0) {
				errorMsg.put("errorPhone", "電話號碼欄必須輸入");
			}
			sex = request.getParameter("gridRadios");
			if (sex == null || sex.trim().length() == 0) {
				errorMsg.put("errorSex", "性別欄必須輸入");
			}

		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}
		// 如果有錯誤
		if (errorMsg.isEmpty()) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(password);
			if ( !matcher.matches() ) {
				errorMsg.put("passwordError", "密碼至少含有一個大寫字母、小寫字母、數字與!@#$%!^'\"等四組資料組合而成，且長度不能小於八個字元");
			}
		}
		// 如果有錯誤
		if (!errorMsg.isEmpty()) {
//			Set<String> set = errorMsg.keySet();
//			for(String s : set) {
//				System.out.println(s);
//			}
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("/register/register.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			// 4. 產生MemberDao物件，以便進行Business Logic運算
			// MemberDaoImpl_Jdbc類別的功能：
			// 1.檢查帳號是否已經存在，已存在的帳號不能使用，回傳相關訊息通知使用者修改
			// 2.若無問題，儲存會員的資料
//			MemberService service = new MemberServiceImpl_Hibernate();
			ServletContext sc = getServletContext();
			WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
			MemberService service = ctx.getBean(MemberService.class);
			if (service.idExists(email)) {
				errorMsg.put("errorIdDup", "此帳號已存在，請換新帳號");
			} else {
				// 為了配合Hibernate的版本。
				// 要在此加密，不要在 dao.saveMember(mem)進行加密
				password1 = GlobalService.getMD5Endocing(
						GlobalService.encryptString(password1));
				Blob blob = null;
				if (is != null) {
					blob = GlobalService.fileToBlob(is, sizeInBytes);
				}
				
				// 取得當前時間
				Timestamp registerTime = new Timestamp(System.currentTimeMillis()); 
				
				// 將所有會員資料封裝到MemberBean(類別的)物件
				MemberBean mem = new MemberBean(0,email,password1,name,
						memberId,phone,date,sex,blob,fileName,LEVELS,currentDate,registerTime);
				
				// 呼叫MemberDao的saveMember方法
				int n = service.saveMember(mem);
				if (n == 1) {
//					msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
					session.setAttribute("MemberBean", mem);
//					response.sendRedirect("../index.jsp");
					response.sendRedirect("/java014_01_Car98/register/verify.jsp");
//					RequestDispatcher rd = request.getRequestDispatcher("/register/verify.jsp");
//					rd.forward(request, response);
					return;
				} else {
					errorMsg.put("errorIdDup", "新增此筆資料有誤(RegisterServlet)");
				}
			}
			// 5.依照 Business Logic 運算結果來挑選適當的畫面
			if (!errorMsg.isEmpty()) {
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request.getRequestDispatcher("/register/register.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/register/register.jsp");
			rd.forward(request, response);
		}
	}
}