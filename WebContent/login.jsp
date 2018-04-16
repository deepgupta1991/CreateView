<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
    history.forward();
</script>
<%
HttpSession ses=request.getSession(false);
String error="";
if(ses.getAttribute("username")!=null && ses!=null){
	//request.setAttribute("errormsg", "Please login New");
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
}else{
	if((String)request.getAttribute("errormsg")==null){
		error="Please Login";
	}
	else{
		error=(String)request.getAttribute("errormsg");
	}
}
%>
<body>
<%=error%><br>

<form action="LoginController" method="post">
<table>
<tr>
<td style="color: blue;">Username </td><td><input type="text" name="username" required></td>
</tr>
<tr>
<td style="color: blue;">Password </td><td><input type="password" name="password" required></td>
</tr>
<tr>
<td></td><td><input type="submit" value="Login"></td>
</tr>
</table>
</form>

</body>
</html>