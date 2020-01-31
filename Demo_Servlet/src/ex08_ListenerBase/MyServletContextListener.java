package ex08_ListenerBase;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletcontextevent) {
		String initParam = servletcontextevent.getServletContext().getInitParameter("initParam");
		System.out.println("ex08: Listener -- context Initialized : initParam = "+initParam);
	}

	public void contextDestroyed(ServletContextEvent servletcontextevent) {
		System.out.println("ex08: Listener -- contex tDestroyed");
	}

}
