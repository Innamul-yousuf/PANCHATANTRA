package admin;

import java.util.Objects;

public class AdminCK {
	private  long id;
	private  String pass;
	public AdminCK(long id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, pass);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminCK other = (AdminCK) obj;
		return pass.equals(other.pass) && Double.doubleToLongBits(id) == Double.doubleToLongBits(other.id);
	}	
}	
