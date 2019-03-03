package com.example.asus.teszt;

import java.util.Random;

public class Register implements Registration{

    @Override
    public int kiertekeles(String username, String password, String verfypassword) {
        Random r = new Random();
        int rand = r.nextInt(3);
        return rand;
    }
}