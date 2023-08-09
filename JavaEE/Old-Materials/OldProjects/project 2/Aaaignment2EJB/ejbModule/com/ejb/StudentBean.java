package com.ejb;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Stateful
@LocalBean
@Entity
@Table(name = "studentBean")
public class StudentBean {
	@OneToMany(mappedBy="studentBean", fetch=FetchType.LAZY)
	  private Set<CoursesBean> courseBean;
	 @ManyToOne
	 @JoinColumn(name="staff_id")
	 private StaffBean staffBean;
	
	 	@Id
	 	@Column(name = "student_id")
	    String student_id;
	 	@Column(name = "student_name")
	    String student_name;
	 	@Column(name = "student_Password")
	    String student_Password;
	 	@Column(name = "passed_courses")
	    String passed_courses;
	 	@Column(name = "current_courses")
	    String current_courses;
	 	@Column(name = "Year")
	    String Year;
	 	
	
    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_Password() {
        return student_Password;
    }

    public void setStudent_Password(String student_Password) {
        this.student_Password = student_Password;
    }

    public String getPassed_courses() {
        return passed_courses;
    }

    public void setPassed_courses(String passed_courses) {
        this.passed_courses = passed_courses;
    }

    public String getCurrent_courses() {
        return current_courses;
    }

    public void setCurrent_courses(String current_courses) {
        this.current_courses = current_courses;
    }

  

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}