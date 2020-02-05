package bean10.t05_one2one_bfk;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ann05_Students")
public class Students05 {

	private IdCard05 card;
	private int sid;
	private String gender;
	private Date birthday;
	private String major;

	public Students05() {
	}

	public Students05(IdCard05 card, String gender, Date birthday, String major) {
		this.card = card;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
	}

	// student 会额外新增一个字段叫pig去关联IdCard这个对象对应的表
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pid", unique = true)
	public IdCard05 getCard() {
		return card;
	}

	public void setCard(IdCard05 card) {
		this.card = card;
	}

	@Id
	@GeneratedValue
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

}
