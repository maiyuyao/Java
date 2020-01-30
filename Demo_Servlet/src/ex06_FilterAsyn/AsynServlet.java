package ex06_FilterAsyn;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AsynServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AsynServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		String s3 = sdf.format(new Date());
		System.out.println("ex06: Servlet #Asyn -- doGet() start @ " + s3);
		// Servlet线程可以将耗时的操作委派给另一个线程来完成，自己在不生成响应的情况下返回至容器。
		// 定义AsyncContext，开启异步
		AsyncContext context = request.startAsync();
		// 把AsyncContext传到多线程中去
		new Thread(new Executor(context)).start();

		request.getRequestDispatcher("/ex06/index.jsp").forward(request, response);
		String s4 = sdf.format(new Date());
		System.out.println("ex06: Servlet #Asyn -- doGet() end @ " + s4);
	}

	// 使用多线程测试异步的特性
	public class Executor implements Runnable {
		// 此处定义AsyncContext对象，getRequest()、getResponse()方法取得请求、响应对象
		@SuppressWarnings("unused")
		private AsyncContext context;
		// 构造方法
		public Executor(AsyncContext context) {
			this.context = context;
		}
		@Override
		public void run() {
			// 执行相关复杂业务
			try {
				Thread.sleep(1000);
				// context.getRequest();
				// context.getResponse();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
				String s5 = sdf.format(new Date());
				System.out.println("ex06: Servlet #Asyn -- run() @ " + s5);
				// context.complete();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>ex06: AsynServlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method: ex06 AsynServlet");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
