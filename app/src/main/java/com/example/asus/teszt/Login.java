package com.example.asus.teszt;

import java.util.Random;

public class Login implements SignUp {
    @Override
    public int kiertekeles(String username, String password) {

        Random r = new Random();
        int rand = r.nextInt(3);
        return rand;
    }
}
