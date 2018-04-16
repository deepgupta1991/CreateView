<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%
HttpSession ses=request.getSession(false);
if(ses.getAttribute("username")!=null && ses!=null){
	ses=(HttpSession)request.getSession(false);
}else{
	request.setAttribute("errormsg", "Login to use Adds page ");	
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
%>

<body>
<a href="LogoutController" style="background: #33FF96  ;">Logout</a> <a> </a> <a href="index.jsp" style="background: #B1ADE5  ;">Home</a> 
<form action="AddController" method="post">
<table border='2' bordercolor="green">
<tr><td>Vendor</td><td><input type="text" name="a1" required /></td></tr>
<tr><td>MAC</td><td><input type="text" name="a2" required/></td></tr>
<tr><td>Name</td><td><input type="text" name="a3" required/></td></tr>
<tr><td>Id</td><td><input type="text" name="a4" required /></td></tr>
<tr><td>Type</td><td><input type="text" name="a5" required/></td></tr>
</table>
<input type="submit" value="Add" /><input type="reset" value="Reset" style="margin-left: 2cm " />
</form>
</body>
</html>