package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.repository.DataConnection;


/**
 * Servlet implementation class SearchAjaxController
 */
@WebServlet("/SearchAjaxController")
public class SearchAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAjaxController() {
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
	        RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("errormsg", "Please login to use SearchAjax module");
	        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String search=request.getParameter("search");
		PrintWriter out=response.getWriter();
		TreeSet<String> tree=null;
		DataConnection dc=new DataConnection();
		if(search==""){
			out.print("Enter an ID!");
		}
		else{	
			try {
				tree=(TreeSet<String>) dc.getAjaxSearch(search);
			
			} catch (Exception e) {
				System.out.println("exceptionController");
				e.printStackTrace();
			}
		
			if(tree.isEmpty()){
				out.println("No records found!");
			}
			else{
				for(String s:tree){
					out.print("<b>");
					out.print(s);
					out.print("</b>");
					out.print("<br>");
				}
			}
		}

	}

}
