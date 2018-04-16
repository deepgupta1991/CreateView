package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AddBean;
import com.repository.DataConnection;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);  
		if(session.getAttribute("username")!=null && session!=null){
	        RequestDispatcher rd=request.getRequestDispatcher("adds.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("errormsg", "Please login to use AddGet module");
	        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);  
		if(session.getAttribute("username")!=null && session!=null){ 
			try {
				AddBean addbean=new AddBean();
				addbean.setA1(request.getParameter("a1"));
				addbean.setA2(request.getParameter("a2"));
				addbean.setA3(request.getParameter("a3"));
				addbean.setA4(request.getParameter("a4"));
				addbean.setA5(request.getParameter("a5"));
				DataConnection dataconnection=new DataConnection();
				dataconnection.AddToDB(addbean);
				
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}  
		else{   
			request.setAttribute("errormsg", "Login to use AddPost Module");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response); 
			}  
	}

}
