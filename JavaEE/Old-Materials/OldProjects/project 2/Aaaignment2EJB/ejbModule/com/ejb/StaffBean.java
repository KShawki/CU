package com.ejb;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Stateless
@LocalBean
@Entity
@Table(name = "staffBean")
public class StaffBean {
	
	
	@OneToMany(mappedBy="staffBean", fetch=FetchType.LAZY)
	  private Set<StudentBean> studentBean;
	@OneToMany(mappedBy="staffBean", fetch=FetchType.LAZY)
	  private Set<CoursesBean> courseBean;
	
		@Id
		//@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name= "staff_id")
		String staff_id;
		@Column(name= "staff_name")
	    String staff_name;
		@Column(name= "Password")
	    String Password;
		@Column(name= "assigned_courses")
	    String assigned_courses;
    public String getAssigned_grades() {
        return assigned_grades;
    }

    public void setAssigned_grades(String assigned_grades) {
        this.assigned_grades = assigned_grades;
    }

    String assigned_grades;
    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    String staff_password;
    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAssigned_courses() {
        return assigned_courses;
    }

    public void setAssigned_courses(String assigned_courses) {
        this.assigned_courses = assigned_courses;
    }

  
}