package com.essence.base.d07_interface.ex02;

public class Computer {
	
	//定义一个属性类
	private IMobileStorage _usbDrive;

	//定义一个无参的构造方法
	public Computer() {
	}

	//定义一个带参的构造方法
	public Computer(IMobileStorage _usbDrive) {
		this._usbDrive = _usbDrive;
	}
	
	//定义getter和setter
	public IMobileStorage get_usbDrive() {
		return _usbDrive;
	}

	public void set_usbDrive(IMobileStorage _usbDrive) {
		this._usbDrive = _usbDrive;
	}
	

    //定义接口的方法
	public void ReadData() {
		this._usbDrive.Read();
	}

	public void WriteData() {
		this._usbDrive.Write();
	}
}