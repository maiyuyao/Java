package ex08_ListenerBase;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	public void attributeAdded(ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("ex08: Listener -- ServletRequest_attributeAdded:"+servletrequestattributeevent.getName());
	}

	public void attributeRemoved(ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("ex08: Listener -- ServletRequest_attributeRemoved:"+servletrequestattributeevent.getName());
	}

	public void attributeReplaced(ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("ex08: Listener -- ServletRequest_attributeReplaced:"+servletrequestattributeevent.getName());

	}

}
