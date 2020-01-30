package ex05_FilterChain;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ErrorFilter implements Filter {

    public ErrorFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ex05: Filter #ERROR  -- doFilter -- START");
		chain.doFilter(request, response);
		System.out.println("ex05: Filter #ERROR  -- doFilter -- END");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("ex05: Filter #ERROR -- init");
	}

}
