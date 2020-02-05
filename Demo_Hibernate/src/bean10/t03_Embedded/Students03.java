package bean10.t03_Embedded;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import bean10.t01_class.Address;

/**
 * @classname: 掌握EmbeddedId注解，PK表作为外键连接表
 */
@Entity
@Table(name = "Ann03_Students")
public class Students03 {

	@EmbeddedId
	private StudentPk pk;

	@Column(length = 10)
	private String name;

	@Column(length = 10)
	private String gender;

	private Date birthday;

	@Column(length = 10)
	private String major;

	// 可以单独在关联的类设定@Embeddable也可以
	@Embedded
	private Address address;

	public Students03() {
	}

	public Students03(StudentPk pk, String name, String gender, Date birthday, String major,
			Address address) {
		this.pk = pk;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.address = address;
	}

	public StudentPk getPk() {
		return pk;
	}

	public void setPk(StudentPk pk) {
		this.pk = pk;
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
