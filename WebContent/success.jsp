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
	request.setAttribute("errormsg", "Login to use success page ");	
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
%>

<body>
<a href="LogoutController" style="background: #33FF96  ;">Logout</a> <a> </a> <a href="index.jsp" style="background: #B1ADE5  ;">Home</a><br> 
<h1>Successfully added!</h1>
<form action="RedirectController">
	<input type="submit" name="add_new_success" value="Add New STB!!">
</form>
<!-- <a href="adds.jsp">Add New STB!!</a><br> -->

</body>
</html>