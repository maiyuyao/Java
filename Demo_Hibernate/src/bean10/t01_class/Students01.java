package bean10.t01_class;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity(name = "Ann01_Students") //name可选，对应表名。省略则表名与实体类名相同。
@Entity
@Table(name="Ann01_Students")
public class Students01 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int sid;
	private String name;
	private String gender;
	private Date birthday;
	private String major;
	private String address;

	public Students01() {
	}

	public Students01(int sid, String name, String gender, Date birthday, String major, String address) {
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.address = address;
	}

	//主键属性，不添加生成失败
	@Id
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
