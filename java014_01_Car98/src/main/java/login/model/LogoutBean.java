package login.model;

import javax.servlet.http.HttpSession;
// 登出時需要做的事寫在這裡，如session.invalidate()
public class LogoutBean {
   
	HttpSession session;
	
	public HttpSession getSession() {
		return session;
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	// 先做 setSession 取得 session ，才有session.invalidate()去做關掉的動作。
	public Integer getLogout() { // logout 
		session.invalidate();
		return 0;
	}
}
