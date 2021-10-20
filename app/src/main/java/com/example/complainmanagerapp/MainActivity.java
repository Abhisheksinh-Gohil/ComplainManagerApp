package com.example.complainmanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    CheckBox isAdmin;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        isAdmin = findViewById(R.id.isAdmin);

        submit = findViewById(R.id.submit);

        isAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAdmin.isChecked())
                    password.setVisibility(View.VISIBLE);
                else
                    password.setVisibility(View.INVISIBLE);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                boolean admin = isAdmin.isChecked();
                if(admin){
                    Intent redirectToAdmin = new Intent(MainActivity.this,ComplainList.class);
                    startActivity(redirectToAdmin);
                }else{
                    Intent redirectToUserComplainForm = new Intent(MainActivity.this,ComplainActivity.class);
                    redirectToUserComplainForm.putExtra("Email",Email);
                    startActivity(redirectToUserComplainForm);
                }
            }
        });
    }
}