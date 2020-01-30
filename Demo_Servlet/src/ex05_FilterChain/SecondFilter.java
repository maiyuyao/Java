package ex05_FilterChain;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("ex05: Filter #2 -- destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ex05: Filter #2 -- doFilter -- START");
		chain.doFilter(request, response);
		System.out.println("ex05: Filter #2 -- doFilter -- END");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("ex05: Filter #2 -- init");
	}
}
