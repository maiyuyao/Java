package ex07_FilterForLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("ex07: Servlet #Login -- doPost(): username="+username);
		
		if("admin".equals(username) && "admin".equals(password)){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			System.out.println("ex07: Servlet #Login -- doPost(): Login successful");
			response.sendRedirect(request.getContextPath()+"/ex07/sucess.jsp");
		}else{
			System.out.println("ex07: Servlet #Login -- doPost(): Login failure");
			response.sendRedirect(request.getContextPath()+"/ex07/fail.jsp");
		}
	}

	public void init() throws ServletException {
		System.out.println("ex07: Servlet init()...");
	}

}
