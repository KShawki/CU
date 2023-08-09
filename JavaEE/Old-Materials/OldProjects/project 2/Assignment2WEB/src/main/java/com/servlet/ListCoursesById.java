package com.servlet;

import java.beans.Beans;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.CoursesBean;
import com.service.Admin;

/**
 * Servlet implementation class ListCoursesById
 */
@WebServlet("/ListCoursesById")
public class ListCoursesById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCoursesById() {
        super();
        // TODO Auto-generated constructor stub
    }
@EJB
Admin a;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String CourseId = request.getParameter("CourseId");
		List<CoursesBean> Courses = a.ListingOfCourseById(CourseId);
		response.getWriter().println(Courses);
		
	}

}
