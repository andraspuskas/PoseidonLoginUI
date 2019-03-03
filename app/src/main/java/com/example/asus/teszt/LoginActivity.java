package com.example.asus.teszt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView hiba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        configureRegisterButton();

        hiba = (TextView) findViewById(R.id.LoginError);

        final CardView hibapanel = (CardView) findViewById(R.id.ErrorMassage);
        CardView logingomb = (CardView) findViewById(R.id.LoginButton);
        logingomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText) findViewById(R.id.UsernameText);
                EditText pass = (EditText) findViewById(R.id.PasswordText);
                Login s = new Login();
                int eredmeny = s.kiertekeles(user.getText().toString(), pass.getText().toString());

                if(eredmeny == 0){ // Minden helyes
                    hibapanel.setVisibility(View.INVISIBLE);
                    openBejelentkezve();
                } else if (eredmeny == 1){ // A felhasználónév vagy a jelszó hibás
                    hiba.setText("A felhasználónév vagy a jelszó helytelen!");
                    hibapanel.setVisibility(View.VISIBLE);
                } else if (eredmeny == 2){ // Minden mezőt ki kell tölteni
                    hiba.setText("Minden mezőt ki kell tölteni!");
                    hibapanel.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    private void configureRegisterButton(){
        TextView regisztracio = (TextView) findViewById(R.id.LoginOldaliRegisztraciosButton);
        regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });
    }

    public void openRegistration(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void openBejelentkezve(){
        Intent intent = new Intent(this, Bejelentkezve.class);
        startActivity(intent);
    }

}
