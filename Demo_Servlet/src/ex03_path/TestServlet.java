package ex03_path;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TestServlet() {
		super();
	}

	public void destroy() {
		super.destroy();  
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 //请求重定向方式跳转到test.jsp,当前路径是http://localhost:8088/Demo_Servlet/ex003
		 //错误写法，实际路径是：http://localhost:8088/Demo_Servlet/ex003/ex03/test.jsp
		 //response.sendRedirect("ex03/test.jsp");
		 //使用request.getContextPath获得上下文对象
	    // response.sendRedirect(request.getContextPath()+"/ex03/test.jsp");
	
	    //服务器内部跳转,这里的斜线表示项目的根目录
	   request.getRequestDispatcher("ex03/test.jsp").forward(request, response);
		//request.getRequestDispatcher("../ex03/test.jsp").forward(request, response);
	}

	public void init() throws ServletException {
	}

}
