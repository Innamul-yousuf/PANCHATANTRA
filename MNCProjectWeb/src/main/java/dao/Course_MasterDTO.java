package dao;

import java.io.Serializable;

public class Course_MasterDTO implements Cloneable, Serializable, Comparable<Course_MasterDTO> {
	
	private int course_id;
	private String course_name;
	private int	duration_in_hrs;
	private int course_level;
	private int course_fees;
	
	
	public int getCourse_id() {
	return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getDuration_in_hrs() {
		return duration_in_hrs;
	}
	public void setDuration_in_hrs(int duration_in_hrs) {
		this.duration_in_hrs = duration_in_hrs;
	}
	public int getCourse_level() {
		return course_level;
	}
	public void setCourse_level(int course_level) {
		this.course_level = course_level;
	}
	public int getCourse_fees() {
		return course_fees;
	}
	public void setCourse_fees(int course_fees) {
		this.course_fees = course_fees;
	}
	@Override
	public int compareTo(Course_MasterDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
			
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return course_id +" "+course_name+" "+duration_in_hrs+" "+course_level+" "+course_fees;
	}
	


}
