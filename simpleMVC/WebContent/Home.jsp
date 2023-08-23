<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Another Page</title>
</head>
<body>
	<% String key = response.getHeader("authenciated");
		System.out.println(key);
	%>
	<form method="POST" action="EmpServ?key="+<%=key%>>
    <button type="submit" name="submit" >Go....</button>
    </form>
    
</body>
</html>
