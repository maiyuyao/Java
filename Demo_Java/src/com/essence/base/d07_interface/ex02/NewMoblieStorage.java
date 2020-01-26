package com.essence.base.d07_interface.ex02;

public class NewMoblieStorage implements IMobileStorage{
    @Override
    public void Read() {
        System.out.println("New Read start...");
        System.out.println("New Read end...");
    }

    @Override
    public void Write() {
        System.out.println("New write start...");
        System.out.println("New write end...");
    }
}