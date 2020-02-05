package bean10.t04_one2one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="ANN04_IDCARD")
public class IdCard {

	@Id
	@GeneratedValue(generator = "pid")
	@GenericGenerator(name = "pid", strategy = "assigned")
	@Column(length = 18)
	private String pid;
	private String sname;

	public IdCard() {
	}

	public IdCard(String pid, String sname) {
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

}
