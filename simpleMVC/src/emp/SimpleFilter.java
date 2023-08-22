package emp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/EmpServ")
public class SimpleFilter implements Filter {

	public SimpleFilter() {

	}

	public void destroy() {

	}

	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String pass = request.getParameter("pass");
		response.setContentType("html/text");
		HttpServletRequest ss = (HttpServletRequest) request;
		HttpSession hs = ss.getSession();
		int flag = 0;
		if (pass.equals("vamsi")) {
			flag = 1;
			hs.setAttribute("flag", flag);
			RequestDispatcher rr = request.getRequestDispatcher("/EmpServ");
			rr.forward(request, response);
		} else if (hs.getAttribute("flag").equals("1")) {
			System.out.println("hiii bro");
			RequestDispatcher rd = request.getRequestDispatcher("/EmpServ");
			rd.forward(request, response);
		} else {
			System.out.println("bro");
			RequestDispatcher rd = request.getRequestDispatcher("NewFile.html");
			rd.forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
