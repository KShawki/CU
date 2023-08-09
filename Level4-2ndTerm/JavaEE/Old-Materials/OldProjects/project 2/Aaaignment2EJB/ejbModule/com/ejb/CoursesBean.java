package com.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Stateless
@LocalBean
@Entity
@Table(name = "coursesBean")
public class CoursesBean {
	  @ManyToOne
	  @JoinColumn(name="student_id")
	  private StudentBean studentBean;
	
	  @ManyToOne
	  @JoinColumn(name="staff_id")
	  private StaffBean staffBean;
	
	@Id
	@Column(name = "course_id")
    String course_id;
	@Column(name = "course_name")
    String course_name;
	@Column(name = "pre_req_academic_year")
    int pre_req_academic_year;
	@Column(name="grade")
	int grade;
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getPre_req_academic_year() {
        return pre_req_academic_year;
    }

    public void setPre_req_academic_year(int pre_req_academic_year) {
        this.pre_req_academic_year = pre_req_academic_year;
    }

    
}