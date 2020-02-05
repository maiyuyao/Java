package bean10.t10_many2Many_bfk;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Ann10_Teacher")
public class Teacher10 {

	@Id
	@GeneratedValue(generator = "tid")
	@GenericGenerator(name = "tid", strategy = "assigned")
	@Column(length = 10)
	private String tid;
	private String tname;

	// 双向关联，教师持有学生的集合,将主控方交给学生来处理
	@ManyToMany(mappedBy = "teach")
	private Set<Students10> stu;

	public Teacher10() {
	}

	public Teacher10(String tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}

	public String getTid() {
		return tid;
	}

	public String getTname() {
		return tname;
	}

	public Set<Students10> getStu() {
		return stu;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setStu(Set<Students10> stu) {
		this.stu = stu;
	}

}
