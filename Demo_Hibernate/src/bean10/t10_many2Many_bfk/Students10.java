package bean10.t10_many2Many_bfk;

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
@Table(name = "Ann10_Students")
public class Students10 {

	@Id
	@GeneratedValue
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	
	@ManyToMany
	@JoinTable(name = "ANN10_TEACH_STU", 
	joinColumns = {@JoinColumn(name = "sid") }, 
	inverseJoinColumns = { @JoinColumn(name = "tid") })
	private Set<Teacher10> teach = new HashSet<Teacher10>();

	public Students10() {
	}

	public Students10(String sname, String gender, Date birthday, String major) {
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
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


	public Set<Teacher10> getTeach() {
		return teach;
	}

	public void setTeach(Set<Teacher10> teach) {
		this.teach = teach;
	}

}
