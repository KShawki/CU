package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.StudentBean;
import com.service.Staff;

/**
 * Servlet implementation class ViewListOfStudentInCourse
 */
@WebServlet("/ViewListOfStudentInCourse")
public class ViewListOfStudentInCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       Staff s;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewListOfStudentInCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String StaffID = request.getParameter("StaffID");
		List<List<StudentBean>> Students = s.ListStudentsInStaffCourses(StaffID);
		response.getWriter().println(Students);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
