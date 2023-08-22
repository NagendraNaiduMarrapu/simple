package emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpServ")
public class EmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JDBC J = new JDBC();
		response.setContentType("jsp/html/text");
		ArrayList<Employee> ae = J.con();
		System.out.println(ae.size());
		request.setAttribute("emp", ae);
		int totalRecords = ae.size();
		int recordsPerPage = 2;
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		request.setAttribute("totalPages", totalPages);
		RequestDispatcher rd = request.getRequestDispatcher("/self.jsp");
		rd.forward(request, response);

	}

}