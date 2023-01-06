package totalDB;

import java.io.Serializable;

public class PanchaAllDTO implements Cloneable, Serializable{
	long student_id;
	int course_id;
	int cod_count;
	int qod_count;
	int tod_count;
	int low_count;
	int vow_count;
	
	Integer total;
	Integer cod;
	Integer qod;
	Integer tod;
	Integer low;
	Integer vow;
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public Integer getQod() {
		return qod;
	}
	public void setQod(Integer qod) {
		this.qod = qod;
	}
	public Integer getTod() {
		return tod;
	}
	public void setTod(Integer tod) {
		this.tod = tod;
	}
	public Integer getLow() {
		return low;
	}
	public void setLow(Integer low) {
		this.low = low;
	}
	public Integer getVow() {
		return vow;
	}
	public void setVow(Integer vow) {
		this.vow = vow;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
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
	public int getCod_count() {
		return cod_count;
	}
	public void setCod_count(int cod_count) {
		this.cod_count = cod_count;
	}
	public int getQod_count() {
		return qod_count;
	}
	public void setQod_count(int qod_count) {
		this.qod_count = qod_count;
	}
	public int getTod_count() {
		return tod_count;
	}
	public void setTod_count(int tod_count) {
		this.tod_count = tod_count;
	}
	public int getLow_count() {
		return low_count;
	}
	public void setLow_count(int low_count) {
		this.low_count = low_count;
	}
	public int getVow_count() {
		return vow_count;
	}
	public void setVow_count(int vow_count) {
		this.vow_count = vow_count;
	}
	
	@Override
	public String toString() {
		return "PanchatanthraDTO [student_id=" + student_id + ", course_id=" + course_id + ", cod_count=" + cod_count
				+ ", qod_count=" + qod_count + ", tod_count=" + tod_count + ", low_count=" + low_count + ", vow_count="
				+ vow_count + ", total=" + total + "]";
	}
	
}
