package emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmpServ")
public class EmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JDBC J = new JDBC();
		response.setContentType("text/html");
		ArrayList<Employee> ae = J.con();
		System.out.println(ae.size());
		request.setAttribute("emp", ae);
		int totalRecords = ae.size();
		int recordsPerPage = 2;
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		HttpSession session = request.getSession();
		session.setAttribute("totalPages", totalPages);
		response.sendRedirect("self.jsp");

	}

}