package com.service;
import javax.ejb.Stateful;
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
@Path("/StaffServices")
public class Staff {
	@PersistenceContext(unitName = "hello")
    EntityManager em;
	
    @Path("/Login/{Id}/{Pass}")
    public String Login(@PathParam("Id") String StaffId,@PathParam("Pass") String StaffPassword)
    {
    	String reply ="";
        List<StaffBean> exists =  em.createQuery("select e from staffBean e where e.staff_id = :staff_id",
                StaffBean.class).setParameter("staff_id", StaffId).getResultList();
        if(exists.get(0).equals(StaffId))
        {
            if(exists.get(1).equals(StaffPassword))
            {
                reply = "Logged In Successfully.";
            }
            else
            	 reply ="Incorrect Credentials";
        }
        else
            reply = "Incorrect Credentials";
        return reply;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/AssignGrades/{StudentId}/{CourseId}/{Grade}")
    public void AssignGrades(@PathParam("Grade") int Grade,@PathParam("CourseId") String CourseId,@PathParam("StudentId") String StudentId) throws ClassNotFoundException, IOException
    {
    	CoursesBean coursesEntity = (CoursesBean) Beans.instantiate(ClassLoader.getSystemClassLoader(), "com.ejb.CoursesBean");
    	StudentBean studentEntity = (StudentBean) Beans.instantiate(ClassLoader.getSystemClassLoader(), "com.ejb.StudentBean");
    	TypedQuery<StudentBean> query = em.createQuery("select e from StudentBean e where e.student_id = :student_id",StudentBean.class);
    	query.setParameter("student_id",StudentId);
    	List<StudentBean> student = query.getResultList();
    	TypedQuery<CoursesBean> query2 = em.createQuery("select e FROM CoursesBean e where e.course_id = :course_id",CoursesBean.class);
    	query2.setParameter("course_id", CourseId);
    	List<CoursesBean> Course = query2.getResultList();
    	for(int i =0; i<student.size();i++)
    	{
    		if(student.get(i).getStudent_id().equals(StudentId))
    		{
	    		for(int k =0; k<Course.size(); k++)
	    		{
	    			if(Course.get(k).getCourse_id().equals(CourseId))
	    			{
	    				coursesEntity.setGrade(Grade);
	    				em.persist(coursesEntity);
	    				System.out.println("Grade Added Successfully");
	    				if(Grade>50 && Grade<100)
	    				{
	    					studentEntity.setPassed_courses(Course.get(i).getCourse_id());
	    					em.persist(studentEntity);
	    				}
	    				
	    			}
	    			
	    		}
    		}
    	}

    }
    ArrayList<List<StudentBean>> students = new ArrayList<List<StudentBean>>();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ListStudentsInCourses/{StaffId")
    public ArrayList<List<StudentBean>> ListStudentsInStaffCourses(@PathParam("StaffId")String ID)
    {
    	//TypedQuery<StaffBean> query = em.createQuery("select e from StaffBean e where e.staff_id = :staff_id",StaffBean.class);
    	
    	TypedQuery<CoursesBean> query1 = em.createQuery("select e FROM StaffBean e where e.staff_id = :staff_id",CoursesBean.class);
    	TypedQuery<StudentBean> query = em.createQuery("select e FROM Studentean e where e.course_id = :course_id",StudentBean.class);
    	query1.setParameter("staff_id",ID);
    	List<CoursesBean> courses = query1.getResultList();
    	for(int i =0; i<courses.size();i++)
    	{
    		query.setParameter("course_id",courses.get(i).getCourse_id());
    		List<StudentBean> student = query.getResultList();
    		students.add(student);
    	}
    	return students;
    	
    }
}