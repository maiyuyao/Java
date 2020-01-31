package ex08_ListenerBase;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	public void requestInitialized(ServletRequestEvent servletrequestevent) {
		String name = servletrequestevent.getServletRequest().getParameter("name");
		System.out.println("ex08: Listener -- request Initialized : name= "+name);
	}
	
	public void requestDestroyed(ServletRequestEvent servletrequestevent) {
		System.out.println("ex08: Listener -- request Destroyed ");
	}



}
