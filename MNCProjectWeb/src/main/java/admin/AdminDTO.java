package admin;

import java.io.Serializable;

public class AdminDTO implements Cloneable, Serializable, Comparable<AdminDTO> {
	private String name;
	private String aname;
	private long id;
	private String pass;
	private String email;
	private long whatsapp;
	private int flag;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(long whatsapp) {
		this.whatsapp = whatsapp;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "adminDTO [name=" + name + ", aname=" + aname + ", id=" + id + ", pass=" + pass + ", email=" + email
				+ ", whatsapp=" + whatsapp + ", flag=" + flag + "]";
	}
	@Override
	public int compareTo(AdminDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
