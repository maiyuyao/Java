package bean10.t08_one2Many_bfk;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ann08_Students")
public class Students08 {

	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	private ClassRoom08 classRoom09;

	public Students08() {
	}

	public Students08(String sname, String gender, Date birthday, String major) {
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

	// 多方持有一方的引用，抓取策略是积极加载
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cid")
	public ClassRoom08 getClassRoom09() {
		return classRoom09;
	}

	public void setClassRoom09(ClassRoom08 classRoom09) {
		this.classRoom09 = classRoom09;
	}

}
