package bean01;

import java.sql.Blob;
import java.util.Date;

/**
 * 持久化类的特征 1.公有的类 2.属性私有 3.提供公有的，不带参数的构造方法 4.属性geter/seter封装
 */

// 1.公有的类
public class Student_comp {

	// 2.私有属性
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private Blob picture;
	private Address address;

	// 3.提供公有的，不带参数的构造方法
	public Student_comp() {
	}

	// 可以先生成部分字段的构造函数，方便直接创建 new Student_comp(sname, gender, birthday);
	public Student_comp(String sname, String gender, Date birthday) {
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
	}

	// 4.属性geter/seter封装
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", birthday="
				+ birthday + ", address=" + address + ", picture=" + picture + "]";
	}

}