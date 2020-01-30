package ex06_FilterAsyn;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "AsynFilter", asyncSupported = true, value = {
		"/ex06/AsynServlet" }, dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.ASYNC })
public class AsynFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("ex06: Filter #Asyn -- destroy()...");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		// 记录执行时间
		String s1 = sdf.format(new Date());
		System.out.println("ex06: Filter #Asyn -- doFilter() start @ " + s1);
		// 放行请求/ex06/AsynServlet
		arg2.doFilter(arg0, arg1);
		// 记录结束时间
		String s2 = sdf.format(new Date());
		System.out.println("ex06: Filter #Asyn -- doFilter() end @ " + s2);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("ex06: Filter #Asyn -- init()...");
	}
}