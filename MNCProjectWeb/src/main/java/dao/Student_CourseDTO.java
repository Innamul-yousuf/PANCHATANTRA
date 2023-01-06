package dao;

import java.io.Serializable;
import java.sql.Date;

public class Student_CourseDTO implements Cloneable,Serializable ,Comparable<Course_MasterDTO> {
	private long student_id;
	private int course_id;
	private int fees_paid;
	private String student_CJD;
	private String student_CED;
	private int student_CAttendance;
	private int student_CGrade ;
	
	//private Student_CourseCK ck;
	
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getFees_paid() {
		return fees_paid;
	}
	public void setFees_paid(int fees_paid) {
		this.fees_paid = fees_paid;
	}
	public String getStudent_CJD() {
		return student_CJD;
	}
	public void setStudent_CJD(String student_CJD) {
		this.student_CJD = student_CJD;
	}
	public String getStudent_CED() {
		return student_CED;
	}
	public void setStudent_CED(String student_CED) {
		this.student_CED = student_CED;
	}
	public int getStudent_CAttendance() {
		return student_CAttendance;
	}
	public void setStudent_CAttendance(int student_CAttendance) {
		this.student_CAttendance = student_CAttendance;
	}
	public int getStudent_CGrade() {
		return student_CGrade;
	}
	public void setStudent_CGrade(int student_CGrade) {
		this.student_CGrade = student_CGrade;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return student_id+" "+fees_paid+" "+student_CJD +" "+student_CED;
	}
	@Override
	public int compareTo(Course_MasterDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
