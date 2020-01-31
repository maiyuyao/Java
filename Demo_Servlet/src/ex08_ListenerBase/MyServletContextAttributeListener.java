package ex08_ListenerBase;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent servletcontextattributeevent) {
		System.out.println("ex08: Listener -- ServletContext attributeAdded:"+servletcontextattributeevent.getName());
	}

	public void attributeRemoved(ServletContextAttributeEvent servletcontextattributeevent) {
		System.out.println("ex08: Listener -- ServletContext attributeRemoved:"+servletcontextattributeevent.getName());

	}

	public void attributeReplaced(ServletContextAttributeEvent servletcontextattributeevent) {
		System.out.println("ex08: Listener -- ServletContext attributeReplaced:"+servletcontextattributeevent.getName());

	}

}
