package bean10.t01_class;

import javax.persistence.Embeddable;

//定义关联，一个数据结构作为主表的几个列，而非子表
@Embeddable
public class Address {

	private String posCode;
	private String address;
	private String phone;

	public Address() {
	}
	
	public Address(String posCode, String address, String phone) {
		this.posCode = posCode;
		this.address = address;
		this.phone = phone;
	}


	public String getPosCode() {
		return posCode;
	}

	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
