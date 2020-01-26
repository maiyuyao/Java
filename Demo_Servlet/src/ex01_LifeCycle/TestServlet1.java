package ex01_LifeCycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TestServlet1() {
		System.out.println("TestServlet1构造方法被执行....");
	}

	public void destroy() {
		System.out.println("TestServlet1销毁方法被执行....");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TestServlet1的doGet()方法被执行...");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("<h1>大家好，我是TestServlet1！</h1>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TestServlet1的doPost()方法被执行...");
		doGet(request, response);
	}

	public void init() throws ServletException {
		System.out.println("TestServlet1的初始化方法被执行....");
	}

}
