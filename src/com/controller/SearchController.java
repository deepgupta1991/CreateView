package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
			try {
				AddBean addbean=new AddBean();
				String search=(request.getParameter("search"));
				DataConnection dc=new DataConnection();
				addbean=dc.getSearch(search);
				if(addbean.getA4()==null){
					request.setAttribute("errormsg", "Write a valid id!");
					RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("results", addbean);
					RequestDispatcher rd=request.getRequestDispatcher("searchresult.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("errormsg", "Please login to use Search module");
	        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
