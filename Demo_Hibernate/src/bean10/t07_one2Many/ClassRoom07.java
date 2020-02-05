package bean10.t07_one2Many;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Ann07_ClassRoom")
public class ClassRoom07 {

	@Id
	@GeneratedValue(generator = "cid")
	@GenericGenerator(name = "cid", strategy = "assigned")
	@Column(length = 10)
	private String cid;
	private String cname;

	// 一方持有多方的集合，加载方式是懒加载
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	private Set<Students07> students;

	public ClassRoom07() {
	}

	public ClassRoom07(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<Students07> getStudents() {
		return students;
	}

	public void setStudents(Set<Students07> students) {
		this.students = students;
	}

}
