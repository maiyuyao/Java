package bean10.t09_many2Many;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ann09_Students")
public class Students09 {

	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	private Set<Teacher09> teacher = new HashSet<Teacher09>();

	public Students09() {
	}

	public Students09(String sname, String gender, Date birthday, String major) {
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
	}

	@Id
	@GeneratedValue
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@ManyToMany
	@JoinTable(name = "Ann09_teach_stu", 
	joinColumns = {@JoinColumn(name = "sid") }, 
	inverseJoinColumns = { @JoinColumn(name = "tid") })
	public Set<Teacher09> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher09> teacher) {
		this.teacher = teacher;
	}

}
