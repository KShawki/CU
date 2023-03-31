package com.service;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.beans.Beans;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

import com.ejb.*;


@Stateless
@Path("/AdminServices")
public class Admin {

	@PersistenceContext(unitName = "hello")
    EntityManager em;
	
	
    
    Random rd = new Random();
    static String usingUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }
    int Range;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/SetRange/{Range}")
    public void setRange(@PathParam("Range") int Range)
    {
        this.Range = Range;
    }
    @GET
    @Path("/GetRange")
    public int getRange()
    {
        return Range;
    }
    
    int counter = 0;
    



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/CreateStudent/{Name}/{Year}")//done
    public String CreateStudentAccount(@PathParam("Year") String Year,@PathParam("Name") String Name)  throws ClassNotFoundException, IOException
    {
    	StudentBean studentEntity = (StudentBean) Beans.instantiate(ClassLoader.getSystemClassLoader(), "com.ejb.StudentBean");
        String reply = "";
        counter++;
        if(counter<=getRange()) {
        	
        	String Id = Integer.toString(counter);
            studentEntity.setStudent_id(Id);
            String randomString = usingUUID();
            studentEntity.setStudent_Password(randomString.substring(0, 8));
            studentEntity.setStudent_name(Name);
            studentEntity.setCurrent_courses("zero");
            studentEntity.setPassed_courses("zero");
            studentEntity.setYear(Year);
            em.persist(studentEntity);
            reply = "Student's ID: "+ studentEntity.getStudent_id() + " Student's Password: " + studentEntity.getStudent_Password();
            
            
        }
        else
            reply = "You have exceeded the number of allowed students.";
        return reply;
    }
    StaffBean staffEntity;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/CreateStaff/{Name}")//done
    public String CreateStaffAccount(@PathParam("Name") String Name) throws ClassNotFoundException, IOException
    {
    	staffEntity = (StaffBean) Beans.instantiate(ClassLoader.getSystemClassLoader(), "com.ejb.StaffBean");

        String ID = Integer.toString(rd.nextInt());
        staffEntity.setStaff_id(ID);
        String randomString = usingUUID();
        staffEntity.setStaff_password(randomString);
        staffEntity.setStaff_name(Name);
        em.persist(staffEntity);
        
        return "Done";
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)//-1768214836
    @Produces(MediaType.APPLICATION_JSON)//-2056407191
    @Path("/AddCourseToStaff/{StaffId}/{CourseId}")
    public String AddCourseToStaff(@PathParam("StaffId") String ID,@PathParam("CourseId") String CourseId) throws  IOException, ClassNotFoundException
    {
    	String reply = "";
    	staffEntity = (StaffBean) Beans.instantiate(ClassLoader.getSystemClassLoader(), "com.ejb.StaffBean");
    	
    	List<StaffBean> Id = em.createQuery("select e from StaffBean e where e.staff_id = :staff_id",
    			StaffBean.class).setParameter("staff_id",ID).getResultList();
    	for(int i=0;i<Id.size();i++)
    	{
			if(Id.get(i).getStaff_id().equals(ID))
			{
			     staffEntity.setAssigned_courses(CourseId);
			    
			}
			else
			{
			     reply = "No Staff With This Id";
			}
    	} 
    	 em.persist(staffEntity);
	     reply = "Course Added To Staff Successfully";
		       
		
        return reply;

    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ListAllStaff")//done
    public List<StaffBean> ListingOfStaffAccounts()
    {
    	
    	TypedQuery<StaffBean> query = em.createQuery("select staff from StaffBean staff",StaffBean.class);
    	List<StaffBean> staff = query.getResultList();
        return staff;
    }
    
    
    @GET
    @Path("/ListStaffById/{Id}")//done
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffBean> ListingOfStaffAccount(@PathParam("Id") String ID)
    {
    	TypedQuery<StaffBean> query = em.createQuery("select e from StaffBean e where e.staff_id = :staff_id",
    			StaffBean.class);
    	query.setParameter("staff_id",ID);
    	List<StaffBean> staff = query.getResultList();
        return staff;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ListAllStudents")//done
    public List<StudentBean> ListingOfStudentAccounts()
    {
    	
    	TypedQuery<StudentBean> query = em.createQuery("select student from StudentBean student",StudentBean.class);
    	List<StudentBean> students = query.getResultList();
        return students;
    }
    @GET
    @Path("/ListStudentById/{Id}")//done
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentBean> ListingOfStudentAccount(@PathParam("Id") String ID)
    {
    	TypedQuery<StudentBean> query = em.createQuery("select e from StudentBean e where e.student_id = :student_id",
                StudentBean.class);
    	query.setParameter("student_id",ID);
    	List<StudentBean> student = query.getResultList();
        return student;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/CreateCourse/{Name}/{prerequisite}")//done
    public String CreationOfCourses(@PathParam("Name") String Name, @PathParam("prerequisite") int prerequisite) throws ClassNotFoundException, IOException
    {
    	CoursesBean coursesEntity = (CoursesBean) Beans.instantiate(ClassLoader.getSystemClassLoader(), "com.ejb.CoursesBean");

        String ID = Integer.toString(rd.nextInt());
        coursesEntity.setCourse_id(ID);
        coursesEntity.setCourse_name(Name);
        coursesEntity.setPre_req_academic_year(prerequisite);
        em.persist(coursesEntity);
        
        return "Course created successfully.";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/GetAllCourses")//done
    public List<CoursesBean> ListingOfCourses()
    {
    	TypedQuery<CoursesBean> query = em.createQuery("select e FROM CoursesBean e",CoursesBean.class);
    	List<CoursesBean> courses = query.getResultList();
        return courses;
    }
    @GET
    @Path("/GetCourseById/{Id}")//done
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<CoursesBean> ListingOfCourseById(@PathParam("Id") String ID)
    {
    	TypedQuery<CoursesBean> query = em.createQuery("select e FROM CoursesBean e where e.course_id = :course_id",CoursesBean.class);
    	query.setParameter("course_id", ID);
    	List<CoursesBean> course = query.getResultList();
        return course;
    }
}