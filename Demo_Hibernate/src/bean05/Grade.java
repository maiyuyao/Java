package bean05;

import java.io.Serializable;

public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	private int gid;
	private String gname;
	private String gdesc;

	// 创建一个不带参的构造方法
	public Grade() {
	}

	// 创建带2个参数的构造方法
	public Grade(String gname, String gdesc) {
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

}
