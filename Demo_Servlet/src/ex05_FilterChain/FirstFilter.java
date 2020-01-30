package ex05_FilterChain;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("ex05: Filter #1 -- destroy");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ex05: Filter #1 -- doFilter -- START");
		chain.doFilter(request, response);
 		HttpServletRequest req =(HttpServletRequest) request;
// 		HttpServletResponse response2 =(HttpServletResponse) response;
		// 重定向
//		 response2.sendRedirect(req.getContextPath()+"/ex05/main.jsp");
//		 response2.sendRedirect(req.getContextPath()+"/ex05/middle.jsp");
		// 转发
 		req.getRequestDispatcher("main.jsp").forward(request, response);
//		req.getRequestDispatcher("main.jsp").include(request, response);
		System.out.println("ex05: Filter #1 -- doFilter -- END");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("ex05: Filter #1 -- init");

	}

}
