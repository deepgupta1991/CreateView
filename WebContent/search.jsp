<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#search').keyup(function(){
		var search=$('#search').val();
		$.ajax({
			type: 'POST',
			data: {search: search},
			url: 'SearchAjaxController',
			success: function(result){
				$('#result1').html(result);
			}
		})
		
	})
	
})
</script>
</head>
<%
String error="";
HttpSession ses=request.getSession(false);
if(ses.getAttribute("username")!=null && ses!=null){
	if((String)request.getAttribute("errormsg")==null){
		error="Enter ID to Search";
	}
	else{
		error=(String)request.getAttribute("errormsg");
	}
}else{
	request.setAttribute("errormsg", "Login to use search page ");	
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}

%>
<body>
<a href="LogoutController" style="background: #33FF96  ;">Logout</a> <a> </a> <a href="index.jsp" style="background: #B1ADE5  ;">Home</a><br> 
<%=error %>
<form action="SearchController">
Search : <input type="text" name="search" id="search" required> <input type="submit" name="submit" value="Details"><br>
<b style="color: blue;">Suggestions</b><br>
<span id="result1"></span>
</form>

</body>
</html>