package com.essence.base.d07_interface.ex02;

public class FlashDisk implements IMobileStorage{
    @Override
    public void Read() {
        System.out.println("FlashDisk Read start...");
        System.out.println("FlashDisk Read end...");
    }

    @Override
    public void Write() {
        System.out.println("FlashDisk write start...");
        System.out.println("FlashDisk write end...");
    }
}