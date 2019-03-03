package com.example.asus.teszt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView hiba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        hiba = (TextView) findViewById(R.id.LoginError);

        configureLoginButton();

        CardView reggomb = (CardView) findViewById(R.id.RegisterButton);
        reggomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText) findViewById(R.id.UsernameText);
                EditText pass = (EditText) findViewById(R.id.PasswordText);
                EditText vpass = (EditText) findViewById(R.id.PasswordVerfyButton);
                Register r = new Register();
                int eredmeny = -1;
                eredmeny = r.kiertekeles(user.getText().toString(), pass.getText().toString(), vpass.getText().toString());
                Log.i("INfo tag", String.valueOf(eredmeny));
                if(eredmeny == 0){ // Minden helyes
                    openBejelentkezve();
                } else if (eredmeny == 1){ // A felhasználónév már foglalat
                    hiba.setText("A felhasználónév már foglalt!");
                } else if (eredmeny == 2){ // A két jelszó nem eggyezik meg
                    hiba.setText("A két jelszó nem eggyezik meg!");
                } else if (eredmeny == 3){ // Minden mezőt ki kell tölteni
                    hiba.setText("Minden mezőt ki kell tölteni!");
                }

            }
        });

    }

    private void configureLoginButton(){
        TextView login = (TextView) findViewById(R.id.backButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    public void openLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openBejelentkezve(){
        Intent intent = new Intent(this, Bejelentkezve.class);
        startActivity(intent);
    }

}

