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
if(ses.getAttribute("username")!=null && ses!=null){
	ses=(HttpSession)request.getSession(false);
}else{
	request.setAttribute("errormsg", "Login to use Home page ");
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
%>
<body>
<a href="LogoutController" style="background: #33FF96  ;">Logout</a><br>
<a href="RedirectController" >Add New STB!!</a><br>
<a href="search.jsp">Search a STB!!</a>


</body>
</html>