package bean10.t06_many2One;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Ann06_ClassRoom")
public class ClassRoom06 {

	@Id
	@GeneratedValue(generator="cid")
	@GenericGenerator(name="cid", strategy="assigned")
	@Column(length=10)
	private String cid;
	
	@Column(length=50)
	private String cname;

	public ClassRoom06() {
	}

	public ClassRoom06(String cid, String cname) {
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

}
