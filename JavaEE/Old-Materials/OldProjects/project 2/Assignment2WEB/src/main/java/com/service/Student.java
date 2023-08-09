package com.service;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.beans.Beans;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.ejb.*;
@Stateful
@Path("/StudentServices")
public class Student {
    @PersistenceContext(unitName = "hello")
    EntityManager em;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Login/{Id}/{Password}")//cb1a9022
    public String StudentLogin(@PathParam("Id")String Id, @PathParam("Password")String Password)
    {
    	String reply = "";
      List<StudentBean> exists =  em.createQuery("select e from StudentBean e where e.student_id = :student_id",
    		  StudentBean.class).setParameter("student_id", Id).getResultList();
      for(int i=0;i<exists.size();i++)
      {
        if(exists.get(i).getStudent_id().equals(Id))
        {
            if(exists.get(i).getStudent_Password().equals(Password))
            {
                reply = "Logged In Successfully.";
            }
            else
                reply = "Incorrect Credentials";
        }
        else
            reply = "Incorrect Credentials";
      }
        return reply;
    }
    ArrayList<String> Passed = new ArrayList<String>();
    ArrayList<String> Current = new ArrayList<String>();
    @GET
    @Path("/ViewCurrentAndPassedCourses/{StudentId}")
    public String ViewCurrentAndPassedCourses(@PathParam("StudentId") String StudentId) {
    	TypedQuery<StudentBean> query1 =  em.createQuery("select e From StudentBean e", StudentBean.class);
    	//TypedQuery<StudentBean> query2 = em.createQuery("select e from StudentBean e", StudentBean.class);
        List<StudentBean> Courses = query1.getResultList();
        for(int i = 0; i<Courses.size(); i++)
        {
        	Passed.add(Courses.get(i).getPassed_courses());
        	Current.add(Courses.get(i).getCurrent_courses());
        }
       // List<StudentBean> PassedCourses = query2.getResultList();
        String currentCourses = "Current Courses: " + Current;
        String passedCourses = " Passed Courses: " + Passed;
        return currentCourses + passedCourses;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/RegiterCourses/{StudentId}/{CourseId}")//-1163334498
    public String RegisterCourses(@PathParam("StudentId")String studentId , @PathParam("CourseId")String Id) throws ClassNotFoundException, IOException
    {
    	StudentBean studentEntity = (StudentBean) Beans.instantiate(ClassLoader.getSystemClassLoader(), "com.ejb.StudentBean");
String reply ="";
        List<CoursesBean> prerequisite = em.createQuery("select e FROM CoursesBean e where e.course_id = :course_id",
        		CoursesBean.class).setParameter("course_id",Id).getResultList();
        List<StudentBean> student = em.createQuery("select e from StudentBean e where e.student_id = :student_id", StudentBean.class).setParameter("student_id",studentId).getResultList();
        for(int i=0;i<student.size();i++)
        {
        	reply = String.valueOf("He "+student.size());
        	if(student.get(i).getStudent_id().equals(studentId))
            {
        		reply = "test";

        			if(prerequisite.get(0).getCourse_id().equals(Id) && prerequisite.get(0).getPre_req_academic_year()<=Integer.parseInt(student.get(i).getYear()))
        			{
	        			
	        				studentEntity.setCurrent_courses(Id);
	        	            em.persist(studentEntity);
	        	            reply="Course Registered Successfully.";
	        	            System.out.println("Course Registered Successfully.");
	        		}
	        		else
	        			    reply ="You Are Not Allowed To Register To This Course.";
        			
        		
            }	
        }
        return reply;
    }
}