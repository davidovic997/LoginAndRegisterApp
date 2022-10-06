package com.link.logovanje;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText novokorisnickoime, novasifra;
    Button signupbutton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);

        novokorisnickoime = (EditText) findViewById(R.id.novokorisnickoIme);
        novasifra = (EditText) findViewById(R.id.novasifra);

        signupbutton = (Button) findViewById(R.id.signUp);
        DB = new DBHelper(this);

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = novokorisnickoime.getText().toString();
                String password = novasifra.getText().toString();

                if(user.equals("") || password.equals(""))
                    Toast.makeText(Register.this, "Unesite sva polja", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = DB.insertData(user, password);
                    if(insert == true){
                        Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}


