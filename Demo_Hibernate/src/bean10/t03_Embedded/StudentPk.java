package bean10.t03_Embedded;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 18)
	private String id;
	@Column(length = 8)
	private String pid;

	public StudentPk() {
	}

	public StudentPk(String id, String pid) {
		this.id = id;
		this.pid = pid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
