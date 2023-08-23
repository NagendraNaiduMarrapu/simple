package emp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/Home.jsp")
public class SimpleFilter implements Filter {

	public SimpleFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String pass = request.getParameter("pass");
		HttpServletRequest req = (HttpServletRequest) request;
		String x = req.getHeader("authenciated");
		if (x != null) {
			chain.doFilter(request, response);
		} else {
			System.out.println("hiii");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
