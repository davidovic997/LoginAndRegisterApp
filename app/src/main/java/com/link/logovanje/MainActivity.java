package com.link.logovanje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText korisnickoime, sifratxt;
    Button loginbutton;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        korisnickoime = (EditText) findViewById(R.id.novokorisnickoIme);
        sifratxt = (EditText) findViewById(R.id.novasifra);

        loginbutton = (Button) findViewById(R.id.buttonLogin);
        db = new DBHelper(this);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String korisnicko_ime = korisnickoime.getText().toString();
                String sifra = sifratxt.getText().toString();

                Boolean checkuserNamePassword = db.checkuserNamePassword(korisnicko_ime, sifra);
                if(checkuserNamePassword == true){
                    Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFULL!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), Register.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "REGISTRACIJA", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
