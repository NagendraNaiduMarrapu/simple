<%@ page language="java" import="java.sql.*,java.util.*,emp.Employee"
 contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee List</title>
</head>
<body>
    <table border="1px">
        <tr>
            <th>name</th>
            <th>age</th>
            <th>sal</th>
            <th>job</th>
            <th>dept</th>
        </tr>
        <tbody>
            <%	int currentpages=0;
                ArrayList<Employee> aee = (ArrayList<Employee>) request.getAttribute("emp");
                int recordsPerPage = 2;
                String currentpage = request.getParameter("page");
                if(currentpage == null){
                	currentpages = 1;
                }
                else{
                	currentpages = Integer.parseInt(currentpage);
                }
            
                int totalPages = (int) request.getAttribute("totalPages");
                int startIndex = (currentpages - 1) * recordsPerPage;
                int endIndex = Math.min(startIndex + recordsPerPage, aee.size());

                for (int i = startIndex; i < endIndex; i++) {
                    Employee e = aee.get(i);
            %>
            <tr>
                <td><%= e.getName() %></td>
                <td><%= e.getAge() %></td>
                <td><%= e.getSal() %></td>
                <td><%= e.getJob() %></td>
                <td><%= e.getDept()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

 
    <div class="pagination">
        
            <%
                for (int i = 1; i <= totalPages; i++) {
            %>
            <button><a href="?page=<%= i %>"><%= i %></a></button>
            <%
                }
            %>
        
    </div>
</body>
</html>
