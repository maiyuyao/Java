package com.essence.base.d07_interface.ex02;

public class MP3Player implements IMobileStorage{
    @Override
    public void Read() {
        System.out.println("MP3 Read start...");
        System.out.println("MP3 Read end...");
    }

    @Override
    public void Write() {
        System.out.println("MP3 write start...");
        System.out.println("MP3 write end...");
    }

    public void PlayMusic(){
        System.out.println("MP3 Music is playing...");
    }
}