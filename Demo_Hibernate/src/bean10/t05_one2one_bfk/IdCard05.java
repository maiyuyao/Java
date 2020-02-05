package bean10.t05_one2one_bfk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ANN05_IDCARD")
public class IdCard05 {

	@Id
	@GeneratedValue(generator = "pid")
	@GenericGenerator(name = "pid", strategy = "assigned")
	@Column(length = 18)
	private String pid;
	private String sname;

	@OneToOne(mappedBy = "card")
	private Students05 stu;

	public IdCard05() {
	}

	public IdCard05(String pid, String sname) {
		this.pid = pid;
		this.sname = sname;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Students05 getStu() {
		return stu;
	}

	public void setStu(Students05 stu) {
		this.stu = stu;
	}

}
