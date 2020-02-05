package bean01;

public class Address {

	private String postalCode;
	private String phone;
	private String address;

	// 空的构造函数
	public Address() {
	}

	// 全部变量的构造函数
	public Address(String postalCode, String phone, String address) {
		this.postalCode = postalCode;
		this.phone = phone;
		this.address = address;
	}

	// geter和seter方法
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [postalCode=" + postalCode + ", phone=" + phone + ", address=" + address + "]";
	}

}
