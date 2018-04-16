<%@page import="com.bean.AddBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
AddBean addbean=null;
HttpSession ses=request.getSession(false);
if(ses.getAttribute("username")!=null && ses!=null){
	if(request.getAttribute("results")!=null){
		addbean= (AddBean)request.getAttribute("results");
	}
	else{
		addbean=new AddBean();
		addbean.setA1("Go to search page first");
		addbean.setA2("Go to search page first");
		addbean.setA3("Go to search page first");
		addbean.setA4("Go to search page first");
		addbean.setA5("Go to seach page first");
	}
	
}else{
	request.setAttribute("errormsg", "Login to use Search Result page ");	
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
%>
</head>
<body>
<a href="LogoutController" style="background: #33FF96  ;">Logout</a> <a> </a> <a href="index.jsp" style="background: #B1ADE5  ;">Home</a><br>
<u>Details of id '<%=addbean.getA4() %>' :</u><br>
Vendor : <b><%=addbean.getA1() %></b><br>
Name : <b><%=addbean.getA2() %></b><br>
MAC : <b><%=addbean.getA3() %></b><br>
ID : <b><%=addbean.getA4() %></b><br>
Type : <b><%=addbean.getA5() %></b><br>
<form action="RedirectController" method="post">
	<input type="submit" name="search_new" value="Search Another!!">
</form>

</body>
</html>