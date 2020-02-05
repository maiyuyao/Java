package bean01;

import java.sql.Blob;
import java.util.Date;

public class Student {
	private int sid;
	private String sname;
	private Date birthday;
	private String gender;
	private String address;
	private Blob picture;

	public Student() {
	}

	public Student( String sname, String gender, Date birthday, String address,
			Blob picture) {
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.picture = picture;
	}


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", birthday=" + birthday + ", gender="
				+ gender + ", address=" + address + ", picture=" + picture + "]";
	}

}