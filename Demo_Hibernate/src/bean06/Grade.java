package bean06;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int gid;
	private String gname;
	private String gdesc;
	
	// 在一方添加多方的集合,元素没有重复，用set
	private Set<Student> students = new HashSet<Student>();

	// 创建一个不带参的构造方法
	public Grade() {
	}

	// 创建带2个参数的构造方法
	public Grade(String gname, String gdesc) {
		this.gname = gname;
		this.gdesc = gdesc;
	}

	// 创建带4个参数的构造方法
	public Grade(int gid, String gname, String gdesc) {
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
