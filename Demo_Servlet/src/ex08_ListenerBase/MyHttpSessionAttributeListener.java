package ex08_ListenerBase;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("ex08: Listener -- HttpSession attributeAdded:"+httpsessionbindingevent.getName());
	}

	public void attributeRemoved(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("ex08: Listener -- HttpSession attributeRemoved:"+httpsessionbindingevent.getName());
	}

	public void attributeReplaced(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("ex08: Listener -- HttpSession attributeReplaced:"+httpsessionbindingevent.getName());
	}

}
