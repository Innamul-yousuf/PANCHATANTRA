package dao;

import java.util.Objects;

public class Student_CourseCK {
	private  long sid;
	private int cid;
	public Student_CourseCK(long sid, int cid) {
		this.sid = sid;
		this.cid = cid;
	}
	
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cid, sid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student_CourseCK other = (Student_CourseCK) obj;
		return cid == other.cid && Double.doubleToLongBits(sid) == Double.doubleToLongBits(other.sid);
	}	
}	
