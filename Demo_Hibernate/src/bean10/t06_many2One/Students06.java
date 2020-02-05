package bean10.t06_many2One;

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
@Table(name = "Ann06_Students")
public class Students06 {

	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	//多方持有一方
	private ClassRoom06 classRoom;

	public Students06() {
	}

	public Students06(String sname, String gender, Date birthday, String major) {
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

	//多方持有一方的引用，抓取策略是积极加载
	//referencedColumnName表示关联类（表）在数据库中的关联字段名
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cid", referencedColumnName = "CID")
	public ClassRoom06 getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom06 classRoom) {
		this.classRoom = classRoom;
	}

}
