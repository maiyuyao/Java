package bean10.t04_one2one;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ann04_Students")
public class Students04 {

	private IdCard card;
	private int sid;
	private String gender;
	private Date birthday;
	private String major;

	public Students04() {
	}

	public Students04(IdCard card, String gender, Date birthday, String major) {
		this.card = card;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
	}

	// Students04 会额外新增一个字段叫pig去关联IdCard这个对象对应的表
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pid", unique = true)
	public IdCard getCard() {
		return card;
	}

	public void setCard(IdCard card) {
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
