package ex07_FilterForLogin;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private FilterConfig config;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
        //取出web.xml中的登录相关配置
		String noLoginPaths = config.getInitParameter("noLoginPaths");

		//取出web.xml中的字符集配置
		String charset = config.getInitParameter("charset");
		if (charset == null) {
			charset = "UTF-8";
		}
		request.setCharacterEncoding(charset);
		System.out.println("ex07: Filter -- doFilter() : url="+request.getRequestURI());
		
		if (noLoginPaths != null) {
			String[] strArray = noLoginPaths.split(";");
			for (int i = 0; i < strArray.length; i++) {
				//取到为空，则继续
				if (strArray[i] == null || "".equals(strArray[i]))
					continue;
				//取到和当前的url一直的配置则放行
				if (request.getRequestURI().indexOf(strArray[i]) != -1) {
					System.out.println("ex07: Filter -- doFilter() : noLoginPaths=" +strArray[i]);
					arg2.doFilter(arg0, arg1);
					return;
				}
			}
		}
        //假如用户名不为空，证明已经登录，直接放行，否则返回登录界面
		if (session.getAttribute("username") != null) {
			System.out.println("ex07: Filter -- doFilter() : Login");
			arg2.doFilter(arg0, arg1);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
		System.out.println("ex07: Filter -- init...\n" + config.toString());
        //初始化时，取出参数
		Enumeration<String> confname = config.getInitParameterNames();
		int i = 0;
		while (confname.hasMoreElements()) {
			String nextElement = confname.nextElement();
			System.out.printf("Filterparam[%d] %s: %s%n", ++i, nextElement, config.getInitParameter(nextElement));

		}

	}

}