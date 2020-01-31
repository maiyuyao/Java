package ex08_ListenerBase;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent httpsessionevent) {
		System.out.println("ex08: Listener -- sessionCreated");
	}

	public void sessionDestroyed(HttpSessionEvent httpsessionevent) {
		System.out.println("ex08: Listener -- sessionDestroyed");
	}

}
