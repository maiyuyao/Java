package bean10.t02_filed;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import bean10.t01_class.Address;

@Entity
@Table(name = "Ann02_Students")
public class Students02 {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE) // 自动生成策略
//	private int sid;

	@Id
	@GeneratedValue(generator = "sid")
	@GenericGenerator(name = "sid", strategy = "assigned") // hibernate的属性
	@Column(length = 10)
	private String sid;

	@Column(length = 50)
	private String name;

	@Column(length = 3)
	private String gender;

	private Date birthday;

	private String major;

	private Address address;

	public Students02() {
	}

	public Students02(String sid, String name, String gender, Date birthday, String major,
			Address address) {
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.address = address;
	}

	public Students02(String name, String gender, Date birthday, String major, Address address) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.address = address;
	}

	// @Id,写在字段和get上面也可以
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
