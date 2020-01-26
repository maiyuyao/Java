package com.essence.base.d07_interface.ex02;

public class MobileHardDisk implements IMobileStorage{

    @Override
    public void Read() {
        System.out.println("MobileHardDisk Read start...");
        System.out.println("MobileHardDisk Read end...");
    }

    @Override
    public void Write() {
        System.out.println("MobileHardDisk write start...");
        System.out.println("MobileHardDisk write end...");
    }

}