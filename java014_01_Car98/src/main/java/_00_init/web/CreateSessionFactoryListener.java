package _00_init.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;

import _00_init.util.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class CreateSessionFactoryListener
 *
 */
@WebListener
public class CreateSessionFactoryListener implements ServletContextListener {
	SessionFactory factory ;
	
	// 沒有名子的靜態方法，區塊通常用來設定初始化和設定初值。 (或是計算過後的初值)
    public void contextDestroyed(ServletContextEvent sce)  { 
    	factory.close();
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	factory = HibernateUtils.getSessionFactory();
    }
	
}
