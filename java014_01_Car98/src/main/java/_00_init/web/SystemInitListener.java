package _00_init.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import _00_init.util.GlobalService;

/**
 * Application Lifecycle Listener implementation class SystemInitListener
 *
 */
@WebListener
// 有重要的資料要透過 Listener監聽 送過來處理。
public class SystemInitListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        ServletContext ctx = sce.getServletContext();
        //GlobalService service = new GlobalService();
        // 只用一次就不要用變數來存，直接new。
        ctx.setAttribute("SYSTEM", new GlobalService());
    }
	
}
