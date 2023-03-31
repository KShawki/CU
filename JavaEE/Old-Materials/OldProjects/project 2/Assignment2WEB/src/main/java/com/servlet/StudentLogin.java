package com.servlet;

import java.io.IOException;
import java.io.*;
import javax.ejb.EJB;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.StudentBean;
import com.service.Student;


/**
 * Servlet implementation class MyServlet
 */
@WebServlet(name = "StudentLogin", value = "/my-servlet")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB 
    Student s ;
    
    private String message;

    public void init() {
        message = "Hello World!";
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String name=request.getParameter("Uname");
	        String pass=request.getParameter("Pass");
	        //Admin admin=new Admin();
	        StudentBean stud  =   new StudentBean();
	        stud.setStudent_Password(pass);
	        stud.setStudent_name(name);
	        String msg=s.StudentLogin(name,pass);
	        response.getWriter().println(msg);
	        //response.sendRedirect("StudentLogin.jsp");
//		 PrintWriter out = response.getWriter();
//	        out.println("<html><body>");
//	        out.println("<h1>" + message + "</h1>");
//	        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
	}

}
