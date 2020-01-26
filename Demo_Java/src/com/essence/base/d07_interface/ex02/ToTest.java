package com.essence.base.d07_interface.ex02;

import org.junit.Test;

public class ToTest {
	
	@Test
	public void program1() {
		Computer computer = new Computer();
		IMobileStorage mp3Player = new MP3Player();
		IMobileStorage flashDisk = new FlashDisk();
		IMobileStorage moblieHardDisk = new MobileHardDisk();

		System.out.println("MP3 inital:");
		computer.set_usbDrive(mp3Player);
		computer.WriteData();
		System.out.println("====================");

		System.out.println("moblieHardDisk inital:");
		computer.set_usbDrive(moblieHardDisk);
		computer.ReadData();
		System.out.println("====================");

		System.out.println("flashDisk inital:");
		computer.set_usbDrive(flashDisk);
		computer.ReadData();
		computer.WriteData();
		System.out.println();
	}
	
	
	//通过接口编程，新增一个设备
	@Test
    public void program2(){
        Computer computer = new Computer();
        IMobileStorage newMobileStorage = new NewMoblieStorage();
        computer.set_usbDrive(newMobileStorage);
        newMobileStorage.Write();
        newMobileStorage.Read();

    }
	
	
	//适配器模式+接口编程
	@Test
    public void program3(){
        Computer computer = new Computer();
        SuperStorageAdapter superStorageAdapter = new SuperStorageAdapter();
        SuperStorage superStorage = new SuperStorage();
        superStorageAdapter.set_superStorage(superStorage);

        System.out.println("new super storage with adapter:");
        computer.set_usbDrive(superStorageAdapter);
        computer.ReadData();
        computer.WriteData();
        System.out.println();
    }
	

}